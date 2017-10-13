package ru.academits.bozhko.main;

import ru.academits.bozhko.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector myVector1 = new Vector(3);
        Vector myVector2 = new Vector(new double[]{10, 5.2});
        Vector myVector3 = new Vector(4, new double[]{10, 12, 3});
        Vector myVector4 = new Vector(myVector2);

        System.out.printf("Разрядность вектора 1: %d, и его координаты %s %n", myVector1.getSize(), myVector1.toString());
        System.out.printf("Разрядность вектора 2: %d, и его координаты %s %n", myVector2.getSize(), myVector2.toString());
        System.out.printf("Координаты вектора 3: %s %n", myVector3.toString());
        System.out.printf("Координаты вектора 4: %s %n%n", myVector4.toString());

        myVector1.setComponent(1, 15.2);
        System.out.printf("Изменяем вектора 1, внеся значение по индексу. Координаты вектора 1: %s %n", myVector1.toString());
        System.out.printf("Координаты вектора 4: %s. 2 координата вектора равна %.3f %n", myVector4.expandVectors().toString(), myVector4.getComponent(1));

        System.out.printf("Длина вектора 3: %.3f %n%n", myVector3.getLength());

        System.out.printf("Прибавление к вектору другого вектора:например, V3 %s и V4 %s %n", myVector3.toString(), myVector4.toString());
        Vector myVector5 = Vector.sumVectors(myVector4, myVector3);
        System.out.printf("-(статический метод)   вектор 4 и вектор 3: %s %n", myVector5.toString());
        System.out.printf("                      Координаты вектора 4: %s %n", myVector4.toString());
        myVector3.sumVectors(myVector4);
        System.out.printf("-(нестатический метод) вектор 3 и вектор 4: %s %n", myVector3.toString());
        System.out.printf("                      Координаты вектора 3: %s %n%n", myVector3.toString());

        System.out.printf("Вычитание из вектора другого вектора: например, V4 %s и V1 %s %n", myVector4.toString(), myVector1.toString());
        Vector myVector6 = Vector.subtractVectors(myVector4, myVector1);
        System.out.printf("-(статический метод)   из вектора 4 вектор 1: %s %n", myVector6.toString());
        System.out.printf("                        Координаты вектора 4: %s %n", myVector4.toString());
        myVector4.subtractVectors(myVector1);
        System.out.printf("-(нестатический метод) из вектора 4 вектор 1: %s %n", myVector4.toString());
        System.out.printf("                        Координаты вектора 4: %s %n%n", myVector4.toString());

        System.out.printf("Умножение вектора 3 на скаляр 4. Координаты вектора 3: %s %n%n", myVector3.multiplyVectorByScalar(4).toString());
        System.out.printf("Скалярное произведение вектора 4 и вектора 2: %.2f %n%n", Vector.multiplyVector(myVector4, myVector2));
        System.out.printf("Разворот вектора 3. Координаты вектора 3: %s %n%n", myVector3.expandVectors().toString());

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
