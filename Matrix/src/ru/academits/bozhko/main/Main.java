package ru.academits.bozhko.main;

import ru.academits.bozhko.matrix.Matrix;
import ru.academits.bozhko.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix myMatrix = new Matrix(2, 3);
        myMatrix.setVectorRowOfMatrix(0, new Vector(new double[]{10, 5.2, 25}));
        System.out.println(myMatrix.toString());
        myMatrix.setVectorColumnOfMatrix(1, new Vector(new double[]{16, 32}));
        System.out.println(myMatrix.toString());
        Vector myVector = new Vector(new double[]{11, 15, 19});
        myMatrix.setVectorRowOfMatrix(1, myVector);
        System.out.println(myMatrix.toString());
        System.out.printf("Размер матрицы %dx%d%n", myMatrix.getSizeOfRow(), myMatrix.getSizeOfColumn());
        System.out.printf("вектор строка [1]:%s%n", myMatrix.getRowOfMatrix(0));
        System.out.printf("вектор столбец [1]:%s%n", myMatrix.getColumnOfMatrix(0));
        System.out.printf("Транспорнирование матрицы:%s%n", myMatrix.transposeMatrix().toString());
        System.out.printf("Умножение на скаляр:%s%n", myMatrix.multiplyMatrixByScalar(2).toString());
    }
}
