package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class GeometryFactory {

    public static final double EPSILON = 1.0e-15;

    public static Coordinate createCoordinate() {
        Coordinate c = new Coordinate(1.0,1.0);
        return c;
    }

    public static Point createPoint() {
        Coordinate c = GeometryFactory.createCoordinate();
        return new Point(c);
    }

    public static LineString createLinestring() {
        List<Point> points = new ArrayList<Point>();

        Coordinate c1 = new Coordinate(1.0,5.0);
        Point point1 = new Point(c1);
        points.add(point1);

        Coordinate c2 = new Coordinate(8.0,2.0);
        Point point2 = new Point(c2);
        points.add(point2);

        LineString linestring = new LineString(points);
        return linestring;
    }

    public static GeometryCollection createGeometryCollection() {
        List<Geometry> geometries = new ArrayList<Geometry>();
        geometries.add(GeometryFactory.createPoint());
        geometries.add(GeometryFactory.createLinestring());

        GeometryCollection geometryCollection = new GeometryCollection(geometries);

        return geometryCollection;
    }
}
