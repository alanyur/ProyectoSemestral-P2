package Codigo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusesTest {
    private Buses bus = new BusA();
    private int[][] matrix = new int[100][100];
    @Test
    void llenarTest() {
        MatrixIterator iterator = new MatrixIterator(matrix);
        bus.llenar(iterator);

        for (int[] elementos:matrix) {
            for (int elemento: elementos) {
                assertEquals(0,elemento);
            }
        }
    }
}