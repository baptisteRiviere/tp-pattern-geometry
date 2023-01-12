package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor {

    private PrintStream out;

    public LogGeometryVisitor(){
        this(System.out);
    }

    public LogGeometryVisitor(PrintStream out){
        this.out = out;
    }

    @Override
    public void visit(Point point) {
        StringBuilder builder = new StringBuilder();
        builder.append("Je suis un point avec x=");
        builder.append(point.getCoordinate().getX());
        builder.append(" et y=");
        builder.append(point.getCoordinate().getY());
        this.out.println(builder.toString());
    }

    @Override
    public void visit(LineString lineString) {
        StringBuilder builder = new StringBuilder();
        builder.append("Je suis une polyligne définir par ");
        builder.append(lineString.getNumPoints());
        builder.append(" point(s)");
        this.out.println(builder.toString());
    }

    @Override
    public void visit(GeometryCollection geometryCollection) {
        StringBuilder builder = new StringBuilder();
        builder.append("Je suis une collection de géométries de ");
        builder.append(geometryCollection.getNumGeometries());
        builder.append(" géométries");
        this.out.println(builder.toString());
    }
}
