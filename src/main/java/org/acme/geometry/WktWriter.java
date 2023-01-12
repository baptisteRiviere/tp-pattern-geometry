package org.acme.geometry;

public class WktWriter {

    public String write(Geometry geometry) {
        StringBuilder builder = new StringBuilder();
        builder.append(geometry.getType().toUpperCase());
        if ( geometry instanceof Point ){
            Point point = (Point) geometry;
            builder.append("(");
            builder.append(point.getCoordinate().getX());
            builder.append(" ");
            builder.append(point.getCoordinate().getY());
            builder.append(")");
        }else if ( geometry instanceof LineString ){
            LineString lineString = (LineString) geometry;
            builder.append("(");
            for (int pointIndex = 0; pointIndex < lineString.getNumPoints(); pointIndex++) {
                Point point = lineString.getPointN(pointIndex);
                builder.append(point.getCoordinate().getX());
                builder.append(" ");
                builder.append(point.getCoordinate().getY());
                if (pointIndex < lineString.getNumPoints() -1) {
                    builder.append(",");
                }
            }
            builder.append(")");
        }else{
            throw new RuntimeException("geometry type not supported");
        }
        String wktObject = builder.toString();
        return wktObject;
    }
}
