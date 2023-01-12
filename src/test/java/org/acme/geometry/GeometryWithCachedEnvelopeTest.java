package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeometryWithCachedEnvelopeTest {



    @Test
    public void testGetEnvelope() {

        Geometry g = new Point(new Coordinate(3.0, 3.0));
        g = new GeometryWithCachedEnvelope(g); // décoration
        Envelope a = g.getEnvelope(); // calcul et stockage dans cachedEnvelope
        Envelope b = g.getEnvelope(); // renvoi de cachedEnvelope
        assertSame(a, b);
    }

    @Test
    public void testGetType() {

        Geometry g = new Point(new Coordinate(3.0, 3.0));
        g = new GeometryWithCachedEnvelope(g); // décoration
        assertEquals("Point", g.getType());
    }

    @Test
    public void testIsEmpty() {

        Geometry g = new Point();
        g = new GeometryWithCachedEnvelope(g);
        assertTrue(g.isEmpty());
    }

    /*
    @Test
    public void testTranslate(){
        double dx = 5.0;
        double dy = 10.0;
        Coordinate coordinate = GeometryFactory.createCoordinate();
        Geometry g = new Point(coordinate);
        g = new GeometryWithCachedEnvelope(g);

        g.translate(dx,dy);

        Assert.assertEquals(coordinate.getX()+dx,point.getCoordinate().getX(),GeometryFactory.EPSILON);
        Assert.assertEquals(coordinate.getY()+dy,point.getCoordinate().getY(),GeometryFactory.EPSILON);
    }
    */

}
