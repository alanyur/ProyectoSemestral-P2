package Codigo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MatrixIteratorTest {
    private static int[][] matrizTest = new int[100][100];

    @BeforeAll
    public static void llenar(){
        for (int i = 0; i < matrizTest.length; i++) {
            for (int j = 0; j < matrizTest[i].length; j++) {
                matrizTest[i][j] = 0;
            }
        }
        MatrixIterator iterator = new MatrixIterator(matrizTest);
    }

    @Test
    void setElementAt() {

        MatrixIterator iterator = new MatrixIterator(matrizTest);
        Random random = new Random();
        int count = 0;
        int index1 = random.nextInt(101);
        int index2 = random.nextInt(101);
        for (int i = 0; i < 100; i++) {
            iterator.setElementAt(i,index1,index2);
            int elemento = matrizTest[index1][index2];
            assertEquals(i, elemento, "El valor en la matriz no coincide con el establecido");
            count++;
        }
        assertEquals(100, count, "No se establecieron 100 elementos en la matriz");
    }

    @Test
    void setElement() {
        MatrixIterator iterator = new MatrixIterator(matrizTest);
        iterator.setElement(10);
        assertEquals(10,matrizTest[0][0]);
    }

    @Test
    void hasNextVacia() {
        int[][] vacia = new int[0][0];
        MatrixIterator iteratorVacio = new MatrixIterator(vacia);
        assertFalse(iteratorVacio.hasNext());
    }
    @Test
    void hasNextUnica() {
        int[][] unico = {{1}};
        MatrixIterator iteratorUnico = new MatrixIterator(unico);
        assertTrue(iteratorUnico.hasNext());
        iteratorUnico.next();
        assertFalse(iteratorUnico.hasNext());
    }
    @Test
    void hasNext() {
        MatrixIterator iterator = new MatrixIterator(matrizTest);
        assertTrue(iterator.hasNext());
        for (int i = 0; i < matrizTest.length * matrizTest[0].length; i++) {
            iterator.next();
        }
        assertFalse(iterator.hasNext());
    }
    @Test
    void nextIteratorVacio() {
        int[][] matrix = new int[0][0];
        MatrixIterator iteratorVacio = new MatrixIterator(matrix);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            while (iteratorVacio.hasNext()) {
                iteratorVacio.next();
            }
            iteratorVacio.next();
        });
    }

    @Test
    void nextIterator() {
        MatrixIterator iterator = new MatrixIterator(matrizTest);
        for(int[] elementos:matrizTest) {
            for (int elemento:elementos) {
                assertTrue(iterator.hasNext());
                assertEquals(elemento,iterator.next());
            }
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    void remove() {
        //no tenemos definido este metodo
    }
}