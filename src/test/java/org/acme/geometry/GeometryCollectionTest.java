package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GeometryCollectionTest {


    @Test
    public void testDefaultConstructor(){
        GeometryCollection geometryCollection = new GeometryCollection();
        Assert.assertTrue(geometryCollection.isEmpty());
        Assert.assertEquals("GeometryCollection",geometryCollection.getType());
    }


    @Test
    public void testConstructor() {

        List<Geometry> geometries = new ArrayList<Geometry>();
        geometries.add(GeometryFactory.createPoint());
        geometries.add(GeometryFactory.createLinestring());

        GeometryCollection geometryCollection = new GeometryCollection(geometries);

        Assert.assertEquals(2,geometryCollection.getNumGeometries());
    }


    @Test
    public void testClone(){
        GeometryCollection geometryCollection = GeometryFactory.createGeometryCollection();
        GeometryCollection geometryCollectionCloned = geometryCollection.clone();
        Assert.assertNotSame(geometryCollectionCloned,geometryCollection);
    }



    @Test
    public void testGetEnvelope() {
        double minX = 0.0;
        double maxY = 100.0;

        List<Geometry> geometries = new ArrayList<Geometry>();
        geometries.add(GeometryFactory.createPoint());
        geometries.add(GeometryFactory.createLinestring());
        geometries.add(new Point(new Coordinate(minX,maxY)));

        GeometryCollection geometryCollection = new GeometryCollection(geometries);

        Envelope envelope = geometryCollection.getEnvelope();

        Assert.assertEquals(geometryCollection.getEnvelope().getXmin(), minX, GeometryFactory.EPSILON);
        Assert.assertEquals(geometryCollection.getEnvelope().getYmax(), maxY, GeometryFactory.EPSILON);
    }

    @Test
    public void isNotEmpty() {
        GeometryCollection geometryCollection = GeometryFactory.createGeometryCollection();
        Assert.assertFalse(geometryCollection.isEmpty());
    }

    @Test
    public void isEmptyBecauseOfEmptyGeometries() {
        Point point = new Point();
        List<Geometry> geometries = new ArrayList<Geometry>();
        geometries.add(point);
        GeometryCollection geometryCollection = new GeometryCollection(geometries);

        Assert.assertTrue(geometryCollection.isEmpty());
    }

}
