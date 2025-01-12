package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    @Test
    public void testDefaultConstructor(){
        Point point = new Point();
        Assert.assertTrue(point.isEmpty());
    }

    @Test
    public void testConstructor(){
        Coordinate coordinate = GeometryFactory.createCoordinate();
        Point point = new Point(coordinate);
        Assert.assertSame(coordinate, point.getCoordinate());
    }

    @Test
    public void testGetType(){
        Point point = new Point();
        Assert.assertEquals("Point",point.getType());
    }

    @Test
    public void testTranslate(){
        double dx = 5.0;
        double dy = 10.0;
        Coordinate coordinate = GeometryFactory.createCoordinate();
        Point point = new Point(coordinate);

        point.translate(dx,dy);

        Assert.assertEquals(coordinate.getX()+dx,point.getCoordinate().getX(),GeometryFactory.EPSILON);
        Assert.assertEquals(coordinate.getY()+dy,point.getCoordinate().getY(),GeometryFactory.EPSILON);
    }

    @Test
    public void testClone(){
        Point point = GeometryFactory.createPoint();

        Point clonedPoint = point.clone();
        double dx = 5.0;
        double dy = 10.0;
        clonedPoint.translate(dx,dy);

        Coordinate clonedPointCoordinate = clonedPoint.getCoordinate();
        Coordinate pointCoordinate = point.getCoordinate();

        Assert.assertNotEquals(pointCoordinate.getX(),clonedPointCoordinate.getX(),GeometryFactory.EPSILON);
        Assert.assertNotEquals(pointCoordinate.getY(),clonedPointCoordinate.getY(),GeometryFactory.EPSILON);
    }

    @Test
    public void testGetEnvelope() {
        Point point = GeometryFactory.createPoint();

        Envelope envelope = point.getEnvelope();

        Assert.assertEquals(point.getEnvelope().getXmin(), point.getCoordinate().getX(), GeometryFactory.EPSILON);
        Assert.assertEquals(point.getEnvelope().getYmin(), point.getCoordinate().getY(), GeometryFactory.EPSILON);
        Assert.assertEquals(point.getEnvelope().getXmax(), point.getCoordinate().getX(), GeometryFactory.EPSILON);
        Assert.assertEquals(point.getEnvelope().getYmax(), point.getCoordinate().getY(), GeometryFactory.EPSILON);
    }

    @Test
    public void testGeometryAsText() {
        Point point = new Point(new Coordinate(3.0,4.0));
        assertEquals("POINT(3.0 4.0)", point.asText().trim());
    }


}
