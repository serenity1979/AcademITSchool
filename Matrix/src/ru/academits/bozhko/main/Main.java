package ru.academits.bozhko.main;

import ru.academits.bozhko.matrix.Matrix;
import ru.academits.bozhko.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix myMatrix1 = new Matrix(2, 3);
        myMatrix1.setVectorRowOfMatrix(0, new Vector(new double[]{10, 5.2, 25}));
        System.out.println(myMatrix1.toString());

        myMatrix1.setVectorColumnOfMatrix(1, new Vector(new double[]{16, 32}));
        System.out.println(myMatrix1.toString());
        Vector myVector1 = new Vector(new double[]{11, 15, 19});
        myMatrix1.setVectorRowOfMatrix(1, myVector1);
        System.out.println(myMatrix1.toString());
        System.out.printf("Размер матрицы %dx%d%n", myMatrix1.getRowsCount(), myMatrix1.getColumnsCount());
        System.out.printf("вектор строка  [1]:%s%n", myMatrix1.getRow(0));
        System.out.printf("вектор столбец [1]:%s%n", myMatrix1.getColumn(0));

        System.out.printf("Транспорнирование матрицы:%s%n", myMatrix1.transposeMatrix());

        Matrix myMatrix2 = new Matrix(myMatrix1);
        System.out.printf("Умножение на скаляр:%s%n", myMatrix2.multiplyMatrixByScalar(2));

        System.out.println("Сложение матриц:");
        Matrix myMatrix3 = Matrix.sumMatrix(myMatrix1, myMatrix2);
        System.out.printf("- нестатитечский метод: M1 %s и М2 %s M3:%s%n", myMatrix1, myMatrix2, myMatrix3);
        System.out.printf("                        M1 %s и М2 %s%n", myMatrix1, myMatrix2);
        System.out.printf("- статитечский метод:   М1 %s и М2 %s M1:%s%n", myMatrix1, myMatrix2, myMatrix1.sumMatrix(myMatrix2));
        System.out.printf("                        M1 %s и М2 %s%n%n", myMatrix1, myMatrix2);

        System.out.println("Вычитание матриц: ");
        Matrix myMatrix4 = new Matrix(new double[][]{{15, 6}, {25.3, 5}, {14, 7.8}});
        Matrix myMatrix5 = Matrix.subtractMatrix(myMatrix4, myMatrix3);
        System.out.printf("- нестатитечский метод: M4 %s и М3 %s M5:%s%n", myMatrix4, myMatrix3, myMatrix5);
        System.out.printf("                        M4 %s и М3 %s%n", myMatrix4, myMatrix3);
        System.out.printf("- статитечский метод:   М4 %s и М3 %s M4:%s%n", myMatrix4, myMatrix3, myMatrix4.subtractMatrix(myMatrix3));
        System.out.printf("                        M4 %s и М3 %s%n%n", myMatrix4, myMatrix3);

        Matrix myMatrix6 = new Matrix(new double[][]{{10, 2, -9, 5}, {3, 4, -15, 0}, {10, -2, -1, 16}, {-1, -4, 0, -6}});
        System.out.printf("Определитель матрицы M6 %s = %.4f%n%n", myMatrix6.toString(), myMatrix6.getDeterminant());
        Matrix myMatrix7 = new Matrix(new double[][]{{10, 2, -1, 7}, {3, 4, 0, -6}});
        Matrix myMatrix8 = Matrix.multiplyMatrix(myMatrix3, myMatrix7);
        System.out.printf("Умножение матриц M3 %s и М6 %s = M8 %s%n%n", myMatrix3.toString(), myMatrix7.toString(), myMatrix8.toString());
        Vector myVector2 = myMatrix3.transposeMatrix().multiplyMatrixVector(myVector1);
        System.out.printf("Умножение матрицы M3 %s на вектор V1 %s = V2 %s%n", myMatrix3.toString(), myVector1.toString(), myVector2.toString());
        Matrix myMatrix9 = new Matrix(new Vector[]{myVector1, myVector2});
        System.out.printf("V1:%s и V2:%s матрица М9 %s%n", myVector1, myVector2, myMatrix9);

        Matrix myMatrix10 = new Matrix(new double[][]{{11.0, 15.0, 19.0}, {2475.0, 2121.0, 0.0}});
        System.out.printf("М10: %s%n", myMatrix10);
        if (myMatrix9.equals(myMatrix10)) {
            System.out.print("Матрица 9 и Матрица 10 равны,");
        } else {
            System.out.print("Матрица 9 и Матрица 10 не равны,");
        }
        if (myMatrix9.hashCode() == myMatrix10.hashCode()) {
            System.out.print(" hashCode матрицы 9 и матрицы 10 равны,");
        } else {
            System.out.print(" hashCode матрицы 9 и матрицы 10 не равны,");
        }

        if (myMatrix9.hashCode() == myMatrix3.hashCode()) {
            System.out.print(" hashCode матрицы 9 и матрицы 3 равны.");
        } else {
            System.out.print(" hashCode матрицы 9 и матрицы 3 не равны.");
        }
    }
}