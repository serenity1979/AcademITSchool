package ru.academits.bozhko.main;

import ru.academits.bozhko.shapes.*;

public class Main {
    public static void main(String[] args) {
        Shapes[] myShapes = {
                new Square(5),
                new Circle(2),
                new Triangle(new Point(1, 1), new Point(10, 2), new Point(6, 25)),
                new Rectangle(10, 6),
                new Triangle(0, 0, 5, 3, 6, 1)};
        for (Shapes element : myShapes) {
            System.out.printf("площадь %.2f , периметр %.2f %n", element.getArea(), element.getPerimeter());
        }
    }
}