package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    public static final double EPSILON = 1.0e-15;

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

        Assert.assertEquals(coordinate.getX()+dx,point.getCoordinate().getX(),EPSILON);
        Assert.assertEquals(coordinate.getY()+dy,point.getCoordinate().getY(),EPSILON);
    }

}
