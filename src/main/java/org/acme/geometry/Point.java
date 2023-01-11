package org.acme.geometry;

public class Point implements Geometry {

    private Coordinate coordinate;

    public Point() {
        this.coordinate = new Coordinate();
    }

    public Point(Coordinate coordinate) {
        if (coordinate == null) {
            this.coordinate = new Coordinate();
        } else {
            this.coordinate = coordinate;
        }
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return coordinate.isEmpty();
    }
}
