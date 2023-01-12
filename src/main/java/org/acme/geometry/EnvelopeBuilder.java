package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder {

    private List<Double> xVals = new ArrayList<Double>();

    private List<Double> yVals = new ArrayList<Double>();

    public void insert(Coordinate coordinate) {
        xVals.add(coordinate.getX());
        yVals.add(coordinate.getY());
    }

    public Envelope getEnvelope() {
        Coordinate botomLeft = new Coordinate(Collections.min(xVals),Collections.min(yVals));
        Coordinate topright = new Coordinate(Collections.max(xVals),Collections.max(yVals));
        Envelope envelope = new Envelope(botomLeft,topright);
        return envelope;
    }



}
