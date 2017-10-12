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
        System.out.printf("вектор строка [1]:%s%n", myMatrix1.getRow(0));
        System.out.printf("вектор столбец [1]:%s%n", myMatrix1.getColumn(0));

        System.out.printf("Транспорнирование матрицы:%s%n", myMatrix1.transposeMatrix().toString());

        Matrix myMatrix2 = new Matrix(myMatrix1);
        System.out.printf("Умножение на скаляр:%s%n", myMatrix2.multiplyMatrixByScalar(2).toString());

        System.out.println("Сложение матриц:");
        Matrix myMatrix3 = Matrix.sumMatrix(myMatrix1, myMatrix2);
        System.out.printf("- нестатитечский метод: M1 %s и М2 %s M3:%s%n", myMatrix1.toString(), myMatrix2.toString(), myMatrix3.toString());
        System.out.printf("                        M1 %s и М2 %s%n", myMatrix1.toString(), myMatrix2.toString());
        System.out.printf("- статитечский метод:   М1 %s и М2 %s   :%s%n", myMatrix1.toString(), myMatrix2.toString(), myMatrix1.sumMatrix(myMatrix2).toString());
        System.out.printf("                        M1 %s и М2 %s%n%n", myMatrix1.toString(), myMatrix2.toString());

        System.out.println("Вычитание матриц: ");
        Matrix myMatrix4 = new Matrix(new double[][]{{15, 6}, {25.3, 5}, {14, 7.8}});
        Matrix myMatrix5 = Matrix.subtractionMatrix(myMatrix4, myMatrix3);
        System.out.printf("- нестатитечский метод: M4 %s и М3 %s M5:%s%n", myMatrix4.toString(), myMatrix3.toString(), myMatrix5.toString());
        System.out.printf("                        M4 %s и М3 %s%n", myMatrix4.toString(), myMatrix3.toString());
        System.out.printf("- статитечский метод:   М4 %s и М3 %s   :%s%n", myMatrix4.toString(), myMatrix3.toString(), myMatrix4.subtractionMatrix(myMatrix3).toString());
        System.out.printf("                        M4 %s и М3 %s%n", myMatrix4.toString(), myMatrix3.toString());

        Matrix myMatrix6 = new Matrix(new double[][]{{10, 2}, {3, 4}});
        System.out.printf("Определитель матрицы M6 %s = %.4f%n", myMatrix6.toString(), myMatrix6.getDeterminant());
        Matrix myMatrix7 = Matrix.multiplicationMatrixs(myMatrix3, myMatrix6);
        System.out.printf("Умножение матриц M3 %s и М6 %s = M7 %s%n", myMatrix3.toString(), myMatrix6.toString(), myMatrix7.toString());
        Vector myVector2 = myMatrix3.transposeMatrix().multiplicationMatrixVector(myVector1);
        System.out.printf("Умножение матрицы M3 %s на вектор V1 %s = V2 %s%n", myMatrix3.toString(), myVector1.toString(), myVector2.toString());
    }
}