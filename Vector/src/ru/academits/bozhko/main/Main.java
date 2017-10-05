package ru.academits.bozhko.main;

import ru.academits.bozhko.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector myVector1 = new Vector(3);
        Vector myVector2 = new Vector(new double[]{10, 5.6});
        Vector myVector3 = new Vector(4, new double[]{10, 12, 3});
        Vector myVector4 = new Vector(myVector2);

        System.out.printf("Разрядность вектора 1: %d, и его координаты %s %n", myVector1.getSize(), myVector1.toString());
        System.out.printf("Разрядность вектора 2: %d, и его координаты %s %n", myVector2.getSize(), myVector2.toString());
        System.out.printf("Координаты вектора 3: %s %n", myVector3.toString());
        System.out.printf("Координаты вектора 4: %s %n%n", myVector4.toString());

        myVector1.setComponents(1, 15.2);
        System.out.printf("Изменяем вектора 1, внеся значение по индексу. Координаты вектора 1: %s %n%n", myVector1.toString());

        myVector3.sumVectors(myVector4);
        System.out.printf("Сумма вектора 3 и вектора 4: %s (нестатический метод)%n", myVector3.toString());
        System.out.printf("Проверка метода на изменение объекта. Координаты вектора 3: %s %n%n", myVector3.toString());

        Vector myVector5 = Vector.sumVectors(myVector2, myVector4);
        System.out.printf("Сумма вектора 2 и вектора 4: %s (статический метод)%n", myVector5.toString());
        System.out.printf("Проверка метода на изменение объекта. Координаты вектора 2: %s %n%n", myVector2.toString());

        myVector3.sumVectors(myVector5);
        System.out.printf("Вычитание из вектора 3 вектор 5: %s (нестатический метод)%n", myVector3.toString());
        System.out.printf("Проверка метода на изменение объекта. Координаты вектора 3: %s %n%n", myVector3.toString());

        Vector myVector6 = Vector.residualVectors(myVector4, myVector1);
        System.out.printf("Вычитание из вектора 4 вектор 1: %s (статический метод)%n", myVector6.toString());
        System.out.printf("Проверка метода на изменение объекта. Координаты вектора 4: %s %n%n", myVector4.toString());

        System.out.printf("Умножение вектора 3 на скаляр 4. Координаты вектора 3: %s %n%n", myVector3.multiplyVectorByScalar(4).toString());
        System.out.printf("Скалярное произведение вектора 4 и вектора 2: %.2f %n%n", Vector.multiplyVector(myVector4, myVector2));
        System.out.printf("Разворот вектора 3. Координаты вектора 3: %s %n%n", myVector3.expandVectors().toString());

        System.out.printf("Координаты вектора 6: %s. 2 координата вектора равна %.3f %n%n", myVector6.expandVectors().toString(), myVector6.getComponents(1));

        Vector myVecror7 = new Vector(3);
        if (myVecror7.equals(myVector1)) {
            System.out.println("Вектор 7 и вектор 1 равны");
        } else {
            System.out.println("Вектор 7 и вектор 1 не равны");
        }

        if (myVecror7.hashCode() == myVector1.hashCode()) {
            System.out.println("hashCode вектора 7 и вектора 1 равны");
        } else {
            System.out.println("hashCode вектора 7 и вектора 1 не равны");
        }
    }
}
