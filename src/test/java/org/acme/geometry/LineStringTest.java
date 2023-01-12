package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LineStringTest {

    @Test
    public void testDefaultConstructor(){

        LineString lineString = new LineString();

        Assert.assertTrue(lineString.isEmpty());
    }
    @Test
    public void testConstructor(){

        List<Point> points = new ArrayList<Point>();
        points.add(GeometryFactory.createPoint());

        LineString lineString = new LineString(points);

        Assert.assertFalse(lineString.isEmpty());
    }

    @Test
    public void testGetNumPoints(){

        List<Point> points = new ArrayList<Point>();
        points.add(GeometryFactory.createPoint());
        points.add(GeometryFactory.createPoint());
        points.add(GeometryFactory.createPoint());

        LineString lineString = new LineString(points);

        Assert.assertEquals(3,lineString.getNumPoints());
    }

    @Test
    public void testGetPointN(){

        Point pointN = GeometryFactory.createPoint();
        List<Point> points = new ArrayList<Point>();
        points.add(pointN);

        LineString lineString = new LineString(points);

        Assert.assertEquals(pointN,lineString.getPointN(0));
    }

    @Test
    public void testGetType(){
        LineString lineString = new LineString();
        Assert.assertEquals("Linestring",lineString.getType());
    }

    @Test
    public void testTranslate(){
        double dx = 5.0;
        double dy = 10.0;
        LineString lineString = GeometryFactory.createLinestring();

        Coordinate exCoordinate = lineString.getPointN(0).getCoordinate();
        lineString.translate(dx,dy);
        Coordinate newCoordinate = lineString.getPointN(0).getCoordinate();

        Assert.assertEquals(exCoordinate.getX()+dx,newCoordinate.getX(),GeometryFactory.EPSILON);
        Assert.assertEquals(exCoordinate.getY()+dy,newCoordinate.getY(),GeometryFactory.EPSILON);
    }

    @Test
    public void testClone(){
        LineString lineString = GeometryFactory.createLinestring();

        LineString clonedLineString = lineString.clone();
        double dx = 5.0;
        double dy = 10.0;
        clonedLineString.translate(dx,dy);

        Coordinate clonedLineStringFirstCoordinate = clonedLineString.getPointN(0).getCoordinate();
        Coordinate lineStringFirstCoordinate = lineString.getPointN(0).getCoordinate();

        Assert.assertNotEquals(lineStringFirstCoordinate.getX(),clonedLineStringFirstCoordinate.getX(),GeometryFactory.EPSILON);
        Assert.assertNotEquals(lineStringFirstCoordinate.getY(),clonedLineStringFirstCoordinate.getY(),GeometryFactory.EPSILON);
    }

    @Test
    public void testGetEnvelope() {
        double xmin = 1.0;
        double ymin = 2.0;
        double xmax = 5.0;
        double ymax = 6.0;

        List<Point> points = new ArrayList<Point>();
        points.add(new Point(new Coordinate(xmin,ymin)));
        points.add(new Point(new Coordinate(xmax,ymax)));

        LineString lineString = new LineString(points);

        Envelope envelope = lineString.getEnvelope();
        
        Assert.assertEquals(xmin, envelope.getXmin(), GeometryFactory.EPSILON);
        Assert.assertEquals(ymin, envelope.getYmin(), GeometryFactory.EPSILON);
        Assert.assertEquals(xmax, envelope.getXmax(), GeometryFactory.EPSILON);
        Assert.assertEquals(ymax, envelope.getYmax(), GeometryFactory.EPSILON);
    }

}
