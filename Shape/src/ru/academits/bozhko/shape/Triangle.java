package ru.academits.bozhko.shape;

public class Triangle implements Shape {
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Triangle(double pointAX, double pointAY, double pointBX, double pointBY, double pointCX, double pointCY) {
        super();
        this.pointA = new Point(pointAX, pointAY);
        this.pointB = new Point(pointBX, pointBY);
        this.pointC = new Point(pointCX, pointCY);
    }

    @Override
    public double getWidth() {
        return Math.max(pointA.getX(), Math.max(pointB.getX(), pointC.getX())) - Math.min(pointA.getX(), Math.min(pointB.getX(), pointC.getX()));

    }

    @Override
    public double getHeight() {
        return Math.max(pointA.getY(), Math.max(pointB.getY(), pointC.getY())) - Math.min(pointA.getY(), Math.min(pointB.getY(), pointC.getY()));
    }

    @Override
    public double getArea() {

        return Math.abs((pointA.getX() - pointC.getX()) * (pointB.getY() - pointC.getY()) - (pointB.getX() - pointC.getX()) * (pointA.getY() - pointC.getY())) / 2;
    }

    @Override
    public double getPerimeter() {
        return pointA.getDistance(pointB) + pointB.getDistance(pointC) + pointC.getDistance(pointA);
    }

    public String toString() {
        return " Треугольник , вершины которого находятся в точках А(" + pointA.getX() + ", " + pointA.getY() + "), B(" + pointB.getX() + ", " + pointB.getY() + "), C(" + pointC.getX() + ", " + pointC.getY() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return pointA.equals(triangle.pointA) && pointB.equals(triangle.pointB) && pointC.equals(triangle.pointC);
    }

    @Override
    public int hashCode() {
        final int prime = 33;
        int hash = 1;
        hash = prime * hash + (pointA != null ? pointA.hashCode() : 0);
        hash = prime * hash + (pointB != null ? pointB.hashCode() : 0);
        hash = prime * hash + (pointC != null ? pointC.hashCode() : 0);
        return hash;
    }
}