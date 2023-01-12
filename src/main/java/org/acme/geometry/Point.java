package org.acme.geometry;

public class Point extends AbstractGeometry {

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

    /*
    @Override
    public Envelope getEnvelope() {
        EnvelopeBuilder builder = new EnvelopeBuilder();
        builder.insert(this.getCoordinate());
        Envelope envelope = builder.getEnvelope();
        return envelope;
    }
    */

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }


}
