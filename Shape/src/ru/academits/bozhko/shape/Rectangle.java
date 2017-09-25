package ru.academits.bozhko.shape;

/**
 * Created by Serenity on 21.09.2017.
 */

public class Rectangle implements Shape {

    private double sideWidth;
    private double sideHeight;

    public Rectangle(double sideWidth, double sideHeight) {
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
    public String toString() {
        return " Прямоуголник с высотой " + sideWidth + " и шириной " + sideHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null || o.getClass() !=this.getClass()) return false;
        if (((Rectangle) o).sideWidth != sideWidth) return false;
        return ((Rectangle) o).sideHeight == sideHeight;
    }

    @Override
    public int hashCode() {
        final int prime = 34;
        int hash = 1;
        hash = prime * hash + (int) sideWidth;
        hash = prime * hash + (int) sideHeight;
        return hash;
    }
}

