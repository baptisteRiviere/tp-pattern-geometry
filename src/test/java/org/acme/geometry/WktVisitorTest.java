package org.acme.geometry;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WktVisitorTest {

    @Test
    public void testVisitWithPoint() {
        WktVisitor visitor = new WktVisitor();
        Geometry geometry = new Point(new Coordinate(3.0, 4.0));
        geometry.accept(visitor);
        assertEquals("POINT(3.0 4.0)", visitor.getResult());
    }

    @Test
    public void testVisitWithLineString() {
        WktVisitor visitor = new WktVisitor();
        Geometry geometry = GeometryFactory.createLinestring();
        geometry.accept(visitor);
        assertEquals("LINESTRING(1.0 5.0,8.0 2.0)", visitor.getResult());
    }

    @Test
    public void testVisitWithGeometryCollection() {
        WktVisitor visitor = new WktVisitor();
        Geometry geometry = GeometryFactory.createGeometryCollection();
        geometry.accept(visitor);
        assertEquals("GEOMETRYCOLLECTION (POINT(1.0 1.0),LINESTRING(1.0 5.0,8.0 2.0))", visitor.getResult());
    }

}
