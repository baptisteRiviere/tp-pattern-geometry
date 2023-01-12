package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry {

    private List<Point> points;

    public LineString() {
        points = new ArrayList<Point>();
    }

    public LineString(List<Point> points) {
        if (points == null) {
            this.points = new ArrayList<Point>();
        } else {
            this.points = points;
        }
    }

    public int getNumPoints() {
        return this.points.size();
    }

    public Point getPointN(int n) {
        return this.points.get(n);
    }

    @Override
    public String getType() {
        return "Linestring";
    }

    @Override
    public boolean isEmpty() {
        return points.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {

        List<Point> newPoints = new ArrayList<Point>();

        for(Point point : points){
            point.translate(dx,dy);
            newPoints.add(point);
        }

        this.points = newPoints;
        this.triggerChange();
    }

    @Override
    public LineString clone() {
        List<Point> clonedPoints = new ArrayList<Point>();

        for(Point point : points){
            Coordinate clonedCoordinate = new Coordinate(point.getCoordinate().getX(),point.getCoordinate().getY());
            Point clonedPoint = new Point(clonedCoordinate);
            clonedPoints.add(clonedPoint);
        }

        LineString clonedLineString = new LineString(clonedPoints);
        return clonedLineString;
    }

    /*
    @Override
    public Envelope getEnvelope() {
        EnvelopeBuilder builder = new EnvelopeBuilder();
        for(Point point : points) {
            builder.insert(point.getCoordinate());
        }
        Envelope envelope = builder.getEnvelope();
        return envelope;
    }
    */

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
