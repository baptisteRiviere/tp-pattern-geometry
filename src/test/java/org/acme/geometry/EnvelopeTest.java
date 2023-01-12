package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {

    @Test
    public void testDefaultConstructor(){
        Envelope envelope = new Envelope();
        Assert.assertTrue(envelope.isEmpty());
    }

    @Test
    public void testConstructor(){
        Coordinate bottomLeft = GeometryFactory.createCoordinate();
        Coordinate topright = GeometryFactory.createCoordinate();

        Envelope envelope = new Envelope(bottomLeft, topright);

        Assert.assertFalse(envelope.isEmpty());
    }

    @Test
    public void testGetters() {
        double xmin = 1.0;
        double ymin = 2.0;
        double xmax = 5.0;
        double ymax = 6.0;

        Coordinate bottomLeft = new Coordinate(xmin,ymin);
        Coordinate topright = new Coordinate(xmax,ymax);
        Envelope envelope = new Envelope(bottomLeft, topright);

        Assert.assertEquals(xmin, envelope.getXmin(), GeometryFactory.EPSILON);
        Assert.assertEquals(ymin, envelope.getYmin(), GeometryFactory.EPSILON);
        Assert.assertEquals(xmax, envelope.getXmax(), GeometryFactory.EPSILON);
        Assert.assertEquals(ymax, envelope.getYmax(), GeometryFactory.EPSILON);

    }



}
