package ru.academits.bozhko.shapes;

/**
 * Created by Serenity on 20.09.2017.
 */
public class Square implements Shapes {

    private double sideLength;

    public Square(double sideLength) {
        super();
        this.sideLength = sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return Math.pow(sideLength, 2);
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }

}
