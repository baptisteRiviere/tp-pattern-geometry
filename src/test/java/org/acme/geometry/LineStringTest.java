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

}
