package ru.academits.bozhko.main;

import ru.academits.bozhko.shape.*;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Shape[] myShapes = {
                new Square(5),
                new Circle(2),
                new Triangle(new Point(1, 1), new Point(10, 2), new Point(6, 25)),
                new Rectangle(10, 6),
                new Triangle(0, 0, 5, 3, 6, 1),
                new Square(8),
                new Circle(8),
                new Rectangle(6, 15),
                new Triangle(new Point(6, 1), new Point(5, 3), new Point(0, 0)),
        };

        Shape figureMaxArea = foundMaxArea(myShapes);
        System.out.printf("Фигура с максимальной площадью %8.2f %s %n", figureMaxArea.getArea(), figureMaxArea.toString());

        int orderIndex=2;
        Shape figureMaxPerimeter = foundMaxPerimeter(orderIndex, myShapes);
        System.out.printf("Фигура с максимальным периметром (%d по величине) %6.2f %s %n",orderIndex, figureMaxPerimeter.getPerimeter(), figureMaxPerimeter.toString());

        System.out.println("====== Фигуры =========");
        for (Shape element : myShapes) {
            System.out.printf(" площадь %6.2f , периметр %6.2f - %s %n", element.getArea(), element.getPerimeter(), element.toString());
        }

        System.out.println("====== Сравнение фигур. Проверка equals и HashCode =========");
        System.out.println("   - equals");
        if (myShapes[2].equals(myShapes[4])) {
            System.out.printf("Фигуры, %s и %s - равны ! %n", myShapes[2].toString(), myShapes[4].toString());
        } else {
            System.out.printf("Фигуры, %s и %s - не равны ! %n", myShapes[2].toString(), myShapes[4].toString());
        }

        if (myShapes[4].equals(myShapes[8])) {
            System.out.printf("Фигуры, %s и %s - равны ! %n", myShapes[4].toString(), myShapes[8].toString());
        } else {
            System.out.printf("Фигуры, %s и %s - не равны ! %n", myShapes[4].toString(), myShapes[8].toString());
        }
        System.out.println("   - hashCode");
        if (myShapes[4].hashCode() == myShapes[8].hashCode()) {
            System.out.printf("Фигуры, %s и %s - равны ! %n", myShapes[4].toString(), myShapes[8].toString());
        } else {
            System.out.printf("Фигуры, %s и %s - не равны ! %n", myShapes[4].toString(), myShapes[8].toString());
        }
    }


    public static Shape foundMaxArea(Shape... listShapes) {
        int arrayLength = listShapes.length;
        if (arrayLength == 0) {
            return null;
        }
        Shape[] sortArrayShape = new Shape[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            sortArrayShape[i] = listShapes[i];
        }
        Arrays.sort(sortArrayShape, new SortByArea());
        return sortArrayShape[0];
    }


    public static Shape foundMaxPerimeter(int signOrderIndex, Shape... listShapes) {
        int arrayLength = listShapes.length;
        if ((signOrderIndex > arrayLength) || (signOrderIndex <= 0) || arrayLength == 0) {
            return null;
        }
        Shape[] sortArrayShape = new Shape[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            sortArrayShape[i] = listShapes[i];
        }
        Arrays.sort(sortArrayShape, new SortByPerimeter());
        return sortArrayShape[signOrderIndex - 1];
    }

}