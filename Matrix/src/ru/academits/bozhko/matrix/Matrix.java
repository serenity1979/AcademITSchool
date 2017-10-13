package ru.academits.bozhko.matrix;

import ru.academits.bozhko.vector.Vector;

import java.util.Arrays;


public class Matrix {
    private Vector[] rows;

    public Matrix(int n, int m) {
        if (n <= 0) {
            throw new IllegalArgumentException("инициализация не прошла, размерность (строк) <=0");
        }

        if (m <= 0) {
            throw new IllegalArgumentException("инициализация не прошла, размерность (колонок) <=0");
        }

        rows = new Vector[n];
        for (int i = 0; i < n; ++i) {
            rows[i] = new Vector(m);
        }
    }

    public Matrix(Matrix matrix) {
        int n = matrix.getRowsCount();
        rows = new Vector[n];
        for (int i = 0; i < n; ++i) {
            rows[i] = matrix.getRow(i);
        }
    }

    public Matrix(double[][] array) {
        int n = array.length;
        if (n <= 0) {
            throw new IllegalArgumentException("инициализация не прошла, размерность (строк) <=0");
        }

        int m = 0;
        for (double[] element : array) {
            m = Math.max(m, element.length);
        }
        if (m <= 0) {
            throw new IllegalArgumentException("инициализация не прошла, размерность (колонок) <=0");
        }

        rows = new Vector[n];
        for (int i = 0; i < n; ++i) {
            this.rows[i] = new Vector(m, array[i]);
        }
    }

    public Matrix(Vector[] arrayOfVector) {
        int n = arrayOfVector.length;
        if (n <= 0) {
            throw new IllegalArgumentException("инициализация не прошла, размерность <=0");
        }

        int m = 0;
        for (Vector element : arrayOfVector) {
            m = Math.max(m, element.getSize());
        }

        rows = new Vector[n];
        for (int i = 0; i < n; ++i) {
            this.rows[i] = new Vector(m);
            for (int j = 0; j < arrayOfVector[i].getSize(); ++j) {
                this.rows[i].setComponent(j, arrayOfVector[i].getComponent(j));
            }
        }
    }

    public int getColumnsCount() {
        return this.rows[0].getSize();
    }

    public int getRowsCount() {
        return this.rows.length;
    }

    public Vector getRow(int indexN) {
        if (indexN >= this.getRowsCount() || indexN < 0) {
            throw new IndexOutOfBoundsException("выход за границы,несуществующий индекс");
        }
        return new Vector(rows[indexN]);
    }

    public Vector getColumn(int indexM) {
        if (indexM >= this.getColumnsCount() || indexM < 0) {
            throw new IndexOutOfBoundsException("выход за границы,несуществующий индекс");
        }

        int n = this.getRowsCount();
        Vector columnVector = new Vector(n);
        for (int j = 0; j < n; ++j) {
            columnVector.setComponent(j, rows[j].getComponent(indexM));
        }
        return columnVector;
    }

    public void setVectorRowOfMatrix(int indexN, Vector coordinateVector) {
        if (indexN >= this.getRowsCount() || indexN < 0) {
            throw new IndexOutOfBoundsException("выход за границы,несуществующий индекс");
        }
        if (coordinateVector.getSize() != getColumnsCount()) {
            throw new IllegalArgumentException("длина вектора не соответствует размеру матрицы");
        }
        this.rows[indexN] = new Vector(coordinateVector);
    }

    public void setVectorColumnOfMatrix(int indexM, Vector coordinateVector) {
        if (indexM >= getColumnsCount() || indexM < 0) {
            throw new IndexOutOfBoundsException("выход за границы,несуществующий индекс");
        }
        int n = this.getRowsCount();
        if (indexM > 0 && coordinateVector.getSize() != n) {
            throw new IllegalArgumentException("длина вектора не соответствует размеру матрицы");
        }
        for (int j = 0; j < n; ++j) {
            this.rows[j].setComponent(indexM, coordinateVector.getComponent(j));
        }
    }

    @Override
    public String toString() {
        StringBuilder componentsString = new StringBuilder();
        componentsString.append("{");
        for (Vector element : rows) {
            componentsString.append(element.toString()).append(",");
        }
        componentsString.deleteCharAt(componentsString.length() - 1);
        return componentsString.append("}").toString();
    }

    public Matrix transposeMatrix() {
        int n = getColumnsCount();
        Vector[] transposeMatrix = new Vector[n];
        for (int i = 0; i < n; ++i) {
            transposeMatrix[i] = getColumn(i);
        }
        rows = transposeMatrix;
        return this;
    }

    public Matrix multiplyMatrixByScalar(double scalar) {
        for (Vector vector : rows) {
            vector.multiplyVectorByScalar(scalar);
        }
        return this;
    }

    public Matrix sumMatrix(Matrix secondMatrix) {
        if (getRowsCount() != secondMatrix.getRowsCount() && getColumnsCount() != secondMatrix.getColumnsCount()) {
            throw new IllegalArgumentException("матрицы разных размеров");
        }
        for (int i = 0; i < getRowsCount(); ++i) {
            rows[i].sumVectors(secondMatrix.getRow(i));
        }
        return this;
    }

    public Matrix subtractMatrix(Matrix secondMatrix) {
        if (getRowsCount() != secondMatrix.getRowsCount() && getColumnsCount() != secondMatrix.getColumnsCount()) {
            throw new IllegalArgumentException("Матрицы разных размеров");
        }
        for (int i = 0; i < this.getRowsCount(); ++i) {
            rows[i].subtractVectors(secondMatrix.getRow(i));
        }
        return this;
    }

    public static Matrix sumMatrix(Matrix firstMatrix, Matrix secondMatrix) {
        if (firstMatrix.getRowsCount() != secondMatrix.getRowsCount() && firstMatrix.getColumnsCount() != secondMatrix.getColumnsCount()) {
            throw new IllegalArgumentException("матрицы разных размеров");
        }
        Matrix newMatrix = new Matrix(firstMatrix);
        return newMatrix.sumMatrix(secondMatrix);
    }

    public static Matrix subtractMatrix(Matrix firstMatrix, Matrix secondMatrix) {
        if (firstMatrix.getRowsCount() != secondMatrix.getRowsCount() && firstMatrix.getColumnsCount() != secondMatrix.getColumnsCount()) {
            throw new IllegalArgumentException("матрицы разных размеров");
        }
        Matrix newMatrix = new Matrix(firstMatrix);
        return newMatrix.subtractMatrix(secondMatrix);
    }

    public double getDeterminant() {
        int n = getRowsCount();
        int m = getColumnsCount();
        if (n != m) {
            throw new IllegalArgumentException("матрица не квадратная");
        }
        if (n == 1) {
            return rows[0].getComponent(0);
        }
        if (n == 2) {
            return rows[0].getComponent(0) * rows[1].getComponent(1) - rows[1].getComponent(0) * rows[0].getComponent(1);
        }
        return getDeterminant(this);
    }

    private static double getDeterminant(Matrix matrix) {
        int n = matrix.getRowsCount();
        if (n == 2) {
            return matrix.getRow(0).getComponent(0) * matrix.getRow(1).getComponent(1) - matrix.getRow(1).getComponent(0) * matrix.getRow(0).getComponent(1);
        }

        double sum = 0;
        for (int j = 0; j < n; ++j) {
            Matrix minor = new Matrix(n - 1, n - 1);
            for (int k = 1; k < n; ++k) {
                Vector newMinorRow = new Vector(n - 1);
                int l = 0;
                for (int v = 0; v < n - 1; ++v) {
                    if (l == j) {
                        ++l;
                    }
                    newMinorRow.setComponent(v, matrix.getRow(k).getComponent(l));
                    ++l;
                }
                minor.setVectorRowOfMatrix(k - 1, newMinorRow);
            }
            sum += Math.pow((double) -1, j) * matrix.getRow(0).getComponent(j) * getDeterminant(minor);
        }
        return sum;
    }

    public static Matrix multiplyMatrix(Matrix firstMatrix, Matrix secondMatrix) {
        int m1 = firstMatrix.getColumnsCount();
        int n2 = secondMatrix.getRowsCount();
        if (n2 != m1) {
            throw new IllegalArgumentException("матрицы не согласованы");
        }
        int n1 = firstMatrix.getRowsCount();
        int m2 = secondMatrix.getColumnsCount();
        Matrix newMatrix = new Matrix(n1, m2);
        for (int i = 0; i < n1; ++i) {
            Vector newVector = new Vector(m2);
            for (int j = 0; j < m2; ++j) {
                newVector.setComponent(j, Vector.multiplyVector(firstMatrix.getRow(i), secondMatrix.getColumn(j)));
            }
            newMatrix.setVectorRowOfMatrix(i, newVector);
        }
        return newMatrix;
    }

    public Vector multiplyMatrixVector(Vector vector) {
        int m1 = getColumnsCount();
        int n2 = vector.getSize();
        if (n2 != m1) {
            throw new IllegalArgumentException("матрица и вектор не согласованы");
        }
        int n1 = getRowsCount();
        Vector newVector = new Vector(n1);
        for (int i = 0; i < n1; ++i) {
            newVector.setComponent(i, Vector.multiplyVector(getRow(i), vector));

        }
        return newVector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Matrix matrix = (Matrix) o;
        return Arrays.equals(rows, matrix.rows);
    }

    @Override
    public int hashCode() {
        final int prime = 30;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(rows);
        return hash;
    }
}