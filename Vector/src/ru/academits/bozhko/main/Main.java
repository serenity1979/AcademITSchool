package ru.academits.bozhko.main;

import ru.academits.bozhko.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector myVector1 = new Vector(3);
        Vector myVector2 = new Vector(new double[]{10, 5.6});
        Vector myVector3 = new Vector(4, new double[]{10, 12, 3});
        Vector myVector4 = new Vector(myVector2);

        System.out.printf("Разрядность вектора 1: %s - %d %n", myVector1.toString(), myVector1.getSize());
        System.out.printf("Разрядность вектора 2: %s - %d %n", myVector2.toString(), myVector2.getSize());
        System.out.printf("Кооррдинаты вектора 3: %s %n", myVector3.toString());
        System.out.printf("Кооррдинаты вектора 4: %s %n", myVector4.toString());

        Vector myVector5 = myVector3.sumVectors(myVector4);
        System.out.printf("Координаты вектора 5 (вектор 3 + вектор 4): %s %n", myVector5.toString());

        Vector myVector6 = myVector3.residualVectors(myVector4);
        System.out.printf("Координаты вектора 6 (вектор 3 - вектор 4): %s %n", myVector6.toString());

        Vector myVector7 = myVector4.residualVectors(myVector3);
        System.out.printf("Координаты вектора 7 (вектор 4 - вектор 3): %s %n", myVector7.toString());

        Vector myVector8 = myVector7.expandVectors();
        System.out.printf("Координаты вектора 8 (разворот вектора 7): %s %n", myVector8.toString());

    }
}
