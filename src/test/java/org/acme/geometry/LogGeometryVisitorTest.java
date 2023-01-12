package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LogGeometryVisitorTest {
    @Test
    public void testVisitPoint(){

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);

        Geometry geometry = new Point(new Coordinate(3.0,4.0));
        geometry.accept(visitor);

        String result = os.toString();

        Assert.assertEquals("Je suis un point avec x=3.0 et y=4.0",result.trim());
        // result.trim permet de supprimer les \n et espaces vides
    }

    @Test
    public void testVisitLineString(){

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);

        Geometry geometry = GeometryFactory.createLinestring();
        geometry.accept(visitor);

        String result = os.toString();

        Assert.assertEquals("Je suis une polyligne définir par 2 point(s)",result.trim());
        // result.trim permet de supprimer les \n et espaces vides
    }
}
