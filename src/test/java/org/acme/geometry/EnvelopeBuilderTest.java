package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeBuilderTest {

    @Test
    public void testBuild() {
        double xmin = 1.0;
        double ymin = 2.0;
        double xmax = 5.0;
        double ymax = 6.0;

        Coordinate coordinate = GeometryFactory.createCoordinate();
        EnvelopeBuilder builder = new EnvelopeBuilder();
        builder.insert(new Coordinate(xmin,ymin));
        builder.insert(new Coordinate(xmax,ymax));
        Envelope envelope = builder.build();

        Assert.assertEquals(xmin, envelope.getXmin(), GeometryFactory.EPSILON);
        Assert.assertEquals(ymin, envelope.getYmin(), GeometryFactory.EPSILON);
        Assert.assertEquals(xmax, envelope.getXmax(), GeometryFactory.EPSILON);
        Assert.assertEquals(ymax, envelope.getYmax(), GeometryFactory.EPSILON);

    }


}
