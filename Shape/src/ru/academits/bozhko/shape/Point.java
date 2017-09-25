package ru.academits.bozhko.shape;

/**
 * Created by Serenity on 09.09.2017.
 */
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    protected double getX() {
        return x;
    }

    protected double getDistance(Point p) {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }

    protected void setX(double x) {
        this.x = x;
    }

    protected double getY() {
        return y;
    }

    protected void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null || o.getClass() !=this.getClass()) return false;
        Point point = (Point) o;
        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        final int prime = 32;
        int hash = 1;
        hash = prime * hash + (int) x;
        hash = prime * hash + (int) y;
        return hash;
    }
}






