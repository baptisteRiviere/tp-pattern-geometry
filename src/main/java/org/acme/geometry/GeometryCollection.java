package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class GeometryCollection extends AbstractGeometry {

    List<Geometry> geometries;

    public GeometryCollection() {
        geometries = new ArrayList<Geometry>();
    }

    public GeometryCollection(List<Geometry> geometries) {
        this.geometries = geometries;
    }

    public int getNumGeometries() {
        return this.geometries.size();
    }

    public Geometry getGeometryN(int n) {
        return this.geometries.get(n);
    }

    @Override
    public String getType() {
        return "GeometryCollection";
    }

    @Override
    public boolean isEmpty() {
        if (geometries.size() == 0) {
            return true;
        } else {
            for (Geometry geometry : geometries) {
                if (! geometry.isEmpty()) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public void translate(double dx, double dy) {
        for (Geometry geometry : geometries) {
            geometry.translate(dx,dy);
        }
        this.triggerChange();
    }

    @Override
    public GeometryCollection clone() {
        List<Geometry> clonedGeometries = new ArrayList<Geometry>();
        for (Geometry geometry : geometries) {
            clonedGeometries.add(geometry.clone());
        }
        GeometryCollection clonedGeometryCollection = new GeometryCollection(clonedGeometries);
        return clonedGeometryCollection;
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }

}
