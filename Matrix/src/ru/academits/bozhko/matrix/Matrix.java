package ru.academits.bozhko.matrix;

import ru.academits.bozhko.vector.Vector;


public class Matrix {
    private Vector[] componentsMatrix;

    public Matrix(int n, int m) {
        if (n <= 0) {
            throw new IllegalArgumentException("инициализация не прошла, размерность <=0");
        }
        //    this.componentsMatrix = new double[n][m];
        componentsMatrix = new Vector[n];
        for (int i = 0; i < n; ++i) {
            componentsMatrix[i] = new Vector(m);
        }
    }

    public Matrix(Matrix matrix) {
        int n = matrix.getSizeOfRow();
        int m = matrix.getSizeOfRow();
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("инициализация не прошла, размерность <=0");
        }
        //  this.componentsMatrix = Arrays.copyOf(matrix.componentsMatrix, matrix.components.length);

        componentsMatrix = new Vector[n];
        for (int i = 0; i < n; ++i) {
            componentsMatrix[i] = new Vector(matrix.getRowOfMatrix(i));
        }
    }

    public Matrix(double[][] array) {
        int n = array.length;
        if (n <= 0) {
            throw new IllegalArgumentException("инициализация не прошла, размерность <=0");
        }
        for (int i = 0; i < n; ++i) {
            this.componentsMatrix[i] = new Vector(array[i]);
        }
    }

    public Matrix(Vector[] arrayOfVector) {
        int n = arrayOfVector.length;
        if (n <= 0) {
            throw new IllegalArgumentException("инициализация не прошла, размерность <=0");
        }
        componentsMatrix = arrayOfVector;
    }

    public int getSizeOfColumn() {
        return this.componentsMatrix[0].getSize();
    }

    public int getSizeOfRow() {
        return this.componentsMatrix.length;
    }

    /*  public double getComponentMatrix(int indexN, int indexM) {
          if (indexN >= componentsMatrix.length || indexN < 0) {
              throw new IllegalArgumentException("несуществующий индекс");
          }
          if (indexM >= componentsMatrix[indexN].getSize() || indexM < 0) {
              throw new IllegalArgumentException("несуществующий индекс");
          }
          return componentsMatrix[indexN].getComponent(indexM);
      }

      public void setComponentMatrix(int indexN, int indexM, double coordinate) {
          if (indexN >= componentsMatrix.length || indexN < 0) {
              throw new IllegalArgumentException("несуществующий индекс");
          }
          if (indexM >= componentsMatrix[indexN].getSize() || indexM < 0) {
              throw new IllegalArgumentException("несуществующий индекс");
          }
          this.componentsMatrix[indexN].setComponent(indexM, coordinate);
      }
  */
    public Vector getRowOfMatrix(int indexN) {
        if (indexN >= componentsMatrix.length || indexN < 0) {
            throw new IllegalArgumentException("несуществующий индекс");
        }
        return componentsMatrix[indexN];
    }

    public Vector getColumnOfMatrix(int indexM) {

        if (indexM >= componentsMatrix[0].getSize() || indexM < 0) {
            throw new IllegalArgumentException("несуществующий индекс");
        }
        int n = componentsMatrix.length;
        Vector columnVector = new Vector(n);
        for (int j = 0; j < n; ++j) {
            columnVector.setComponent(j, componentsMatrix[j].getComponent(indexM));
        }
        return columnVector;
    }

    public void setVectorRowOfMatrix(int indexN, Vector coordinateVector) {
        //todo пересмотреть условие n строки, m колонки
        if (indexN >= componentsMatrix.length || indexN < 0) {
            throw new IllegalArgumentException("несуществующий индекс");
        }
        if (indexN > 0 && coordinateVector.getSize() != componentsMatrix[0].getSize()) {
            throw new IllegalArgumentException("длина вектора не соответствует размеру матрицы");
        }
        this.componentsMatrix[indexN] = new Vector(coordinateVector);
    }

    public void setVectorColumnOfMatrix(int indexM, Vector coordinateVector) {
        if (indexM >= componentsMatrix[0].getSize() || indexM < 0) {
            throw new IllegalArgumentException("несуществующий индекс");
        }
        int n = componentsMatrix.length;
        if (indexM > 0 && coordinateVector.getSize() != n) {
            throw new IllegalArgumentException("длина вектора не соответствует размеру матрицы");
        }
        for (int j = 0; j < n; ++j) {
            this.componentsMatrix[j].setComponent(indexM, coordinateVector.getComponent(j));
        }
    }

    @Override
    public String toString() {
        StringBuilder componentsString = new StringBuilder();
        componentsString.append("{");
        for (Vector element : componentsMatrix) {
            componentsString.append(element.toString()).append(",");
        }
        componentsString.deleteCharAt(componentsString.length() - 1);
        return componentsString.append("}").toString();
    }

    public Matrix transposeMatrix() {
        int n = componentsMatrix[0].getSize();
        Vector[] transposeMatrix = new Vector[n];
        for (int i = 0; i < n; ++i) {
            transposeMatrix[i] = getColumnOfMatrix(i);
        }
        componentsMatrix = transposeMatrix;
        return this;
    }

    public Matrix multiplyMatrixByScalar(double scalar) {
        for (int i = 0; i < componentsMatrix.length; i++) {
            componentsMatrix[i].multiplyVectorByScalar(scalar);
        }
        return this;
    }
}
