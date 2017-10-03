package ru.academits.bozhko.vector;

import java.util.Arrays;

public class Vector {

    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("инициализация не прошла, размерность <=0");
        }
        this.components = new double[n];
        for (int i = 0; i < n; i++) {
            this.components[i] = (double) 0;
        }
    }

    public Vector(Vector vector) {
        this.components = vector.components;
    }

    public Vector(double[] array) {
        int n = array.length;
        this.components = new double[n];
        System.arraycopy(array, 0, this.components, 0, n);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("инициализация не прошла, размерность <=0");
        }
        int arrayLength = array.length;
        this.components = new double[n];
        System.arraycopy(array, 0, this.components, 0, arrayLength);
        for (int i = arrayLength; i < n; i++) {
            this.components[i] = (double) 0;
        }
    }

    public int getSize() {
        return this.components.length;
    }

    public double[] getComponents() {
        return components;
    }

    public void setComponents(double[] components) {
        this.components = components;
    }

    public String toString() {
        String componentsString = "{";
        for (Double element : components) {
            componentsString = String.format("%s%s, ", componentsString, element);
        }
        return String.format("%s}", componentsString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector)) return false;

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

    public Vector sumVectors(Vector secondArray) {
        int fistLength = components.length;
        int secondLength = secondArray.getSize();
        double[] newVector = new double[(fistLength > secondLength) ? fistLength : secondLength];
        if (fistLength > secondLength) {
            System.arraycopy(components, 0, newVector, 0, components.length);
            for (int i = 0; i < secondLength; i++) {
                newVector[i] = newVector[i] + secondArray.components[i];
            }
        } else {
            System.arraycopy(secondArray.components, 0, newVector, 0, secondArray.getSize());
            for (int i = 0; i < fistLength; i++) {
                newVector[i] = newVector[i] + components[i];
            }
        }
        return new Vector(newVector);
    }

    public Vector expandVectors() {
        for (int i = 0; i < components.length; i++) {
            components[i] = (-1) * components[i];
        }
        return new Vector(this);
    }

    public Vector residualVectors(Vector secondArray) {
        int fistLength = components.length;
        int secondLength = secondArray.getSize();
        double[] newVector = new double[(fistLength > secondLength) ? fistLength : secondLength];
        if (fistLength > secondLength) {
            System.arraycopy(components, 0, newVector, 0, components.length);
            for (int i = 0; i < secondLength; i++) {
                newVector[i] = newVector[i] - secondArray.components[i];
            }
        } else {
            System.arraycopy(secondArray.components, 0, newVector, 0, secondArray.getSize());
            for (int i = 0; i < newVector.length; i++) {
                newVector[i] = (-1) * newVector[i];
            }
            for (int i = 0; i < fistLength; i++) {
                newVector[i] = newVector[i] + components[i];
            }
        }
        return new Vector(newVector);
    }
}