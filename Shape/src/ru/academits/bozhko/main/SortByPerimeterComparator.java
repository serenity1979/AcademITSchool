package ru.academits.bozhko.main;

import ru.academits.bozhko.shape.Shape;

import java.util.Comparator;

public class SortByPerimeterComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape obj1, Shape obj2) {
        double parameter1 = obj1.getPerimeter();
        double parameter2 = obj2.getPerimeter();

        return Double.compare(parameter2, parameter1);
    }
}