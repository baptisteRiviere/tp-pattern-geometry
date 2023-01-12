package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry {

    private Geometry original;

    private Envelope cachedEnvelope;

    public GeometryWithCachedEnvelope(Geometry original) {
        this.original = original;
        cachedEnvelope = this.original.getEnvelope();
    }

    @Override
    public Envelope getEnvelope() {
        return this.cachedEnvelope;
    }

    @Override
    public String getType() {
        return this.original.getType();
    }

    @Override
    public boolean isEmpty() {
        return this.original.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        this.original.translate(dx,dy);
    }

    @Override
    public Geometry clone() {
        return new GeometryWithCachedEnvelope(this.original.clone()); // partie délicate
    }



    @Override
    public void accept(GeometryVisitor visitor) {

    }
}
