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
            sumOfSquares += Math.pow(element, 2);
        }
        return Math.sqrt(sumOfSquares);
    }

    public double getComponent(int index) {
        if (index >= components.length || index < 0) {
            throw new IllegalArgumentException("несуществующий индекс");
        }
        return components[index];
    }

    public void setComponent(int index, double coordinate) {
        if (index < 0 || index >= components.length) {
            throw new IllegalArgumentException("несуществующий индекс");
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
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Vector vector = (Vector) o;
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        final int prime = 30;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(components);
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
        if (maxLength - components.length > 0) {
            components = Arrays.copyOf(components, maxLength);
        }
        int minLength = Math.min(components.length, secondVector.getSize());
        for (int i = 0; i < minLength; i++) {
            this.components[i] += secondVector.components[i];
        }
        return this;
    }

    public static Vector sumVectors(Vector firstVector, Vector secondVector) {
        Vector newVector = new Vector(firstVector);
        return newVector.sumVectors(secondVector);
    }

    public Vector subtractionVectors(Vector secondVector) {
        int maxLength = Math.max(components.length, secondVector.getSize());
        if (maxLength - components.length > 0) {
            components = Arrays.copyOf(components, maxLength);
        }
        int minLength = Math.min(components.length, secondVector.getSize());
        for (int i = 0; i < minLength; ++i) {
            components[i] -= secondVector.components[i];
        }
        return this;
    }

    public static Vector subtractionVectors(Vector firstVector, Vector secondVector) {
        Vector newVector = new Vector(firstVector);
        return newVector.subtractionVectors(secondVector);
    }

    public static double multiplyVector(Vector firstVector, Vector secondVector) {
        int minLength = Math.min(firstVector.getSize(), secondVector.getSize());
        double sumOfFactors = 0;
        for (int i = 0; i < minLength; i++) {
            sumOfFactors += firstVector.getComponent(i) * secondVector.getComponent(i);
        }
        return sumOfFactors;
    }
}