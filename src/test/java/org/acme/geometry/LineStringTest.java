package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LineStringTest {

    public static final double EPSILON = 1.0e-15;

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

        Assert.assertEquals(exCoordinate.getX()+dx,newCoordinate.getX(),EPSILON);
        Assert.assertEquals(exCoordinate.getY()+dy,newCoordinate.getY(),EPSILON);
    }

}
