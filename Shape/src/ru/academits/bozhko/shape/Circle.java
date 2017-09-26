package ru.academits.bozhko.shape;

public class Circle implements Shape {
    private double radius;

    public Circle(double radiusLength) {
        this.radius = radiusLength;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return " Круг с радиусом " + radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        final int prime = 30;
        int hash = 1;
        hash = prime * hash + (int) radius;
        return hash;
    }
}


