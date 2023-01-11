package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

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

}
