package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WktWriterTest {

    @Test
    public void testWriteWithPoint() {
        Geometry g = new Point(new Coordinate(3.0,4.0));
        WktWriter writer = new WktWriter();
        assertEquals("POINT(3.0 4.0)", writer.write(g));
    }

    @Test
    public void testWriteWithLineString() {
        Geometry g = GeometryFactory.createLinestring();
        WktWriter writer = new WktWriter();
        assertEquals("LINESTRING(1.0 5.0,8.0 2.0)", writer.write(g));
    }

}
