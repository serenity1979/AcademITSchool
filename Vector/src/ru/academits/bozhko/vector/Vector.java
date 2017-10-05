package ru.academits.bozhko.vector;

import java.util.Arrays;

public class Vector {

    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("инициализация не прошла, размерность <=0");
        }
        this.components = new double[n];
    }

    public Vector(Vector vector) {
        this.components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        int n = array.length;
        if (n <= 0) {
            throw new IllegalArgumentException("инициализация не прошла, размерность <=0");
        }
        this.components = Arrays.copyOf(array, n);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("инициализация не прошла, размерность <=0");
        }
        this.components = Arrays.copyOf(array, n);
    }

    public int getSize() {
        return this.components.length;
    }

    public double getLength() {
        double sumOfSquares = 0;
        for (double element : components) {
            sumOfSquares = sumOfSquares + Math.pow(element, 2);
        }
        return Math.sqrt(sumOfSquares);
    }

    public double getComponent(int index) {
        if (index >= components.length) {
            return 0;
        }
        return components[index];
    }

    public void setComponent(int index, double coordinate) {
        if (index < 0) {
            throw new IllegalArgumentException("несуществующий индекс");
        }
        if (index >= components.length) {
            int delta = index - components.length;
            System.arraycopy(new double[delta], 0, components, components.length, delta);
        }
        this.components[index] = coordinate;
    }

    @Override
    public String toString() {
        StringBuilder componentsString = new StringBuilder();
        componentsString.append("{");
        for (double element : components) {
            componentsString.append(element).append(",");
        }
        componentsString.deleteCharAt(componentsString.length() - 1);
        return componentsString.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Vector vector = (Vector) o;
        return Arrays.equals(components, vector.components);// && (components.length == vector.getSize());
    }

    @Override
    public int hashCode() {
        final int prime = 30;
        int hash = 1;
        hash = prime * hash + prime * components.length + Arrays.hashCode(components);
        return hash;
    }

    public Vector multiplyVectorByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] = scalar * components[i];
        }
        return this;
    }

    public Vector expandVectors() {
        return multiplyVectorByScalar(-1);
    }

    public Vector sumVectors(Vector secondVector) {
        int maxLength = Math.max(components.length, secondVector.getSize());
        int delta = maxLength - components.length;
        if (delta < 0) {
            System.arraycopy(new double[delta], 0, components, components.length, delta);
        }
        int minLength = Math.min(components.length, secondVector.getSize());
        for (int i = 0; i < minLength; i++) {
            this.components[i] = this.components[i] + secondVector.components[i];
        }
        return this;
    }

    public static Vector sumVectors(Vector firstVector, Vector secondVector) {
        Vector newVector = new Vector(firstVector);
        return newVector.sumVectors(secondVector);
    }

    public Vector residualVectors(Vector secondVector) {
        int maxLength = Math.max(components.length, secondVector.getSize());
        int delta = maxLength - components.length;
        if (delta < 0) {
            System.arraycopy(new double[delta], 0, components, components.length, delta);
        }
        int minLength = Math.min(components.length, secondVector.getSize());
        for (int i = 0; i < minLength; ++i) {
            components[i] = components[i] - secondVector.components[i];
        }
        return this;
    }

    public static Vector residualVectors(Vector firstVector, Vector secondVector) {
        Vector newVector = new Vector(firstVector);
        return newVector.residualVectors(secondVector);
    }

    public static double multiplyVector(Vector firstVector, Vector secondVector) {
        int minLength = (firstVector.getSize() < secondVector.getSize()) ? firstVector.getSize() : secondVector.getSize();
        double sumOfFactors = 0;
        for (int i = 0; i < minLength; i++) {
            sumOfFactors = sumOfFactors + firstVector.getComponent(i) * secondVector.getComponent(i);
        }
        return sumOfFactors;
    }

}