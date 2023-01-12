package org.acme.geometry;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry {

    private List<GeometryListener> listeners = new ArrayList<GeometryListener>();

    public String asText() {
        WktVisitor wktVisitor = new WktVisitor();
        this.accept(wktVisitor);
        return wktVisitor.getResult();
    }

    public Envelope getEnvelope() {
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
        this.accept(envelopeBuilder);
        return envelopeBuilder.build();
    }

    public abstract Geometry clone();

    public void addListener(GeometryListener listener) {
        listeners.add(listener);
    }

    protected void triggerChange() {
        for (GeometryListener listener : listeners) {
            listener.onChange(this);
        }
    }

}
