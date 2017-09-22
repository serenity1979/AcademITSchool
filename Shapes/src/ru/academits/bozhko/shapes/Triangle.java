package ru.academits.bozhko.shapes;

/**
 * Created by Serenity on 21.09.2017.
 */

public class Triangle implements Shapes {

    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        super();
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
        return getWidth() * getHeight() / 2;
    }

    @Override
    public double getPerimeter() {
        return pointA.getDistance(pointB) + pointB.getDistance(pointC) + pointC.getDistance(pointA);
    }

    public String PrintShapes() {
        return " Треугольник , вершины которого находятся в точках А(" + pointA.getX() + ", " + pointA.getY() + "), B(" + pointB.getX() + ", " + pointB.getY() + "), C(" + pointC.getX() + ", " + pointC.getY() + ")";
    }
}

