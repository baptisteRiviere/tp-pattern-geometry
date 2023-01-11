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
        Assert.assertEquals(coordinate, point.getCoordinate());
    }

}
