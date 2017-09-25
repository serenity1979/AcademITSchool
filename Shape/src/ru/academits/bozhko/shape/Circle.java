package ru.academits.bozhko.shape;

/**
 * Created by Serenity on 21.09.2017.
 */

public class Circle implements Shape {
    private double radiusLength;

    public Circle(double radiusLength) {
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
        return Math.PI * Math.pow(radiusLength, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radiusLength;
    }

    @Override
    public String toString() {
        return " Круг с радиусом " + radiusLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null || o.getClass() !=this.getClass()) return false;
        return radiusLength == ((Circle) o).radiusLength;
    }

    @Override
    public int hashCode() {
        final int prime = 30;
        int hash = 1;
        hash = prime * hash + (int) radiusLength;
        return hash;
    }
}


