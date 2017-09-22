package ru.academits.bozhko.main;

import ru.academits.bozhko.shapes.*;

public class Main {
    public static void main(String[] args) {
        Shapes[] myShapes = {
                new Square(5),
                new Circle(2),
                new Triangle(1, 1, 10, 2, 6, 25),
                new Rectangle(10, 6),
                new Triangle(0, 0, 5, 3, 6, 1),
                new Square(8),
                new Circle(8),
                new Rectangle(6, 15),
        };
        for (Shapes element : myShapes) {
            System.out.printf(" площадь %6.2f , периметр %6.2f - %s %n", element.getArea(), element.getPerimeter(), element.PrintShapes());
        }
        System.out.println();

        int maxAreaIndex = foundMaxArea(myShapes);
        int maxPerimeterIndex = foundMaxPerimeter(foundMaxPerimeter(-1, myShapes), myShapes);
        System.out.printf("Фигура с максимальной площадью %8.2f %s %n", myShapes[maxAreaIndex].getArea(), myShapes[maxAreaIndex].PrintShapes());
        System.out.printf("Фигура с максимальным периметром %6.2f %s %n", myShapes[maxPerimeterIndex].getPerimeter(), myShapes[maxPerimeterIndex].PrintShapes());

    }

    public static int foundMaxArea(Shapes... listShapes) {
        double maxArea = listShapes[0].getArea();
        int maxAreaIndex = 0;
        for (int i = 0; i < listShapes.length; i++) {
            maxAreaIndex = (listShapes[i].getArea() > maxArea) ? i : maxAreaIndex;
            maxArea = listShapes[maxAreaIndex].getArea();
        }
        return maxAreaIndex;
    }

    public static int foundMaxPerimeter(int missedIndex, Shapes... listShapes) {
        double maxPerimeter = listShapes[0].getPerimeter();
        int maxPerimeterIndex = 0;
        for (int i = 0; i < listShapes.length; i++) {
            if (i != missedIndex) {
                maxPerimeterIndex = (listShapes[i].getPerimeter() > maxPerimeter) ? i : maxPerimeterIndex;
                maxPerimeter = listShapes[maxPerimeterIndex].getPerimeter();
            }
        }
        return maxPerimeterIndex;
    }

}