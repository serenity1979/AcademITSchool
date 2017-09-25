package ru.academits.bozhko.shape;

/**
 * Created by Serenity on 20.09.2017.
 */


public class Square implements Shape {

    private double sideLength;

    public Square(double sideLength) {
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

    @Override
    public String toString() {
        return " Квадрат со стороной " + sideLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null || o.getClass() !=this.getClass()) return false;
        return ((Square) o).sideLength == sideLength;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + (int) sideLength;
        return hash;
    }
}


