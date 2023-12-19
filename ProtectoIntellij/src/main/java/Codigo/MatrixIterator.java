package Codigo;

import java.util.Iterator;

public class MatrixIterator implements Iterator<Integer> {
    private int[][] matrix;
    private int filas;
    private int col;

    public MatrixIterator(int[][] matrix) {
        this.matrix = matrix;
        filas = 0;
        col = 0;
    }
    public void setElementAt(int value, int filaIndex, int colIndex) {
        if (filaIndex < matrix.length && colIndex < matrix[filaIndex].length) {
            matrix[filaIndex][colIndex] = value;
        }
    }
    public void setElement(int value) {
        if (filas < matrix.length && col < matrix[filas].length) {
            matrix[filas][col] = value;
        }
    }

    @Override
    public boolean hasNext() {
        return filas < matrix.length && col < matrix[filas].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No hay más elementos en la matriz");
        }
        int element = matrix[filas][col];
        col++;
        if (col >= matrix[filas].length) {
            col = 0;
            filas++;
        }
        return element;
    }
    @Override
    public void remove() {

    }
}
