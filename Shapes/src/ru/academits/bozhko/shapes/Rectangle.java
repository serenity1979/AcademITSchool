package ru.academits.bozhko.shapes;

/**
 * Created by Serenity on 21.09.2017.
 */
public class Rectangle implements Shapes {

    private double sideWidth;
    private double sideHeight;

    public Rectangle(double sideWidth, double sideHeight) {
        super();
        this.sideWidth = sideWidth;
        this.sideHeight = sideHeight;
    }

    @Override
    public double getWidth() {
        return sideWidth;
    }

    @Override
    public double getHeight() {
        return sideHeight;
    }

    @Override
    public double getArea() {
        return sideHeight * sideWidth;
    }

    @Override
    public double getPerimeter() {
        return (sideWidth + sideHeight) * 2;
    }

    @Override
    public String PrintShapes() {
        return " Прямоуголник с высотой " + sideWidth + " и шириной " + sideHeight;
    }
}
