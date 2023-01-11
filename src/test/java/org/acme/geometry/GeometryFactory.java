package org.acme.geometry;

public class GeometryFactory {

    public static Coordinate createCoordinate() {
        Coordinate c = new Coordinate(45.0,45.0);
        return c;
    }

    public static Point createPoint() {
        Coordinate c = GeometryFactory.createCoordinate();
        return new Point(c);
    }
}
