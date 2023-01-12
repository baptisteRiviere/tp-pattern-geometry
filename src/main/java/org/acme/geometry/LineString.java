package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {

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
    }
}
