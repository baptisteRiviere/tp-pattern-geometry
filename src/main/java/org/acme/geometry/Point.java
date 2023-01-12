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
        return "Point";
    }

    @Override
    public boolean isEmpty() {
        return coordinate.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {

        Coordinate newCoordinate = new Coordinate(
                this.coordinate.getX() + dx,
                this.coordinate.getY() + dy
        );

        this.coordinate = newCoordinate;
    }

    @Override
    public Point clone() {
        Point clonedPoint = new Point(this.coordinate);
        return clonedPoint;
    }

}
