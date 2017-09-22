package ru.academits.bozhko.shapes;

/**
 * Created by Serenity on 21.09.2017.
 */
public class Circle implements Shapes {
    private double radiusLength;

    public Circle(double radiusLength) {
        super();
        this.radiusLength = radiusLength;
    }

    @Override
    public double getWidth() {
        return 2 * radiusLength;
    }

    @Override
    public double getHeight() {
        return 2 * radiusLength;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * Math.pow(radiusLength, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radiusLength;
    }

    @Override
    public String PrintShapes() {
        return " Круг с радиусом " + radiusLength;
    }
}
