package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class GeometryListenerTest {

    @Test
    public void testListener(){

        Geometry g = new Point(new Coordinate(3.0, 4.0));
        g = new GeometryWithCachedEnvelope(g);
        double minX = g.getEnvelope().getXmin();
        g.translate(5.0,5.0);
        double newMinX = g.getEnvelope().getXmin();
        assertNotEquals(minX,newMinX,GeometryFactory.EPSILON);

    }

}
