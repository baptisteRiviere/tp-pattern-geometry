package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder implements GeometryVisitor {

    private List<Double> xVals = new ArrayList<Double>();

    private List<Double> yVals = new ArrayList<Double>();

    public void insert(Coordinate coordinate) {
        xVals.add(coordinate.getX());
        yVals.add(coordinate.getY());
    }

    public Envelope build() {
        Coordinate botomLeft = new Coordinate(Collections.min(xVals),Collections.min(yVals));
        Coordinate topright = new Coordinate(Collections.max(xVals),Collections.max(yVals));
        Envelope envelope = new Envelope(botomLeft,topright);
        return envelope;
    }


    @Override
    public void visit(Point point) {

        this.insert(point.getCoordinate());
    }

    @Override
    public void visit(LineString lineString) {
        for (int pointIndex = 0; pointIndex < lineString.getNumPoints(); pointIndex++) {
            Point point = lineString.getPointN(pointIndex);
            this.insert(point.getCoordinate());
        }
    }

    @Override
    public void visit(GeometryCollection geometryCollection) {
        for (int geometryIndex = 0; geometryIndex < geometryCollection.getNumGeometries(); geometryIndex++) {
            Geometry geometry = geometryCollection.getGeometryN(geometryIndex);

            Envelope envelope = geometry.getEnvelope();
            Coordinate botomLeft = new Coordinate(envelope.getXmin(), envelope.getYmin());
            Coordinate uperRight = new Coordinate(envelope.getXmax(), envelope.getYmax());

            this.insert(botomLeft);
            this.insert(uperRight);
        }
    }
}
