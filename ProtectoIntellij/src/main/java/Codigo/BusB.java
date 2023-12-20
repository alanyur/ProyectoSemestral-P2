package Codigo;

/**
 *
 *   BusB: Representa al tipo de bus mediano, 30 asientos, 1 piso.
 *   @author Juan Agustín Umaña Silva
 *   @author Alan Yuren Ibacache Gonelli
 *
 */
public class BusB extends Buses {
    private static final long serialVersionUID = 3L;
    private int asientos = 32;
    private int pisos = 1;
    private int filas = asientos/4;
    private int columnas = 4;
    private int[][] MatrizData_B = new int[filas][columnas];
    public MatrixIterator iterator_B = new MatrixIterator(MatrizData_B);
    private String patente = "";

    public BusB() {
        llenar(iterator_B);
    }

    public BusB(String patente) {
        this.patente = patente;
    }
    public void Print_B(){
        iterator_B = new MatrixIterator(MatrizData_B);
        Print(iterator_B,MatrizData_B);
    }
    public int getAsientos() {
        return asientos;
    }
    public int getPisos(){
        return pisos;
    }


    @Override
    public int getFilas() {
        return filas;
    }

    @Override
    public int getColumnas() {
        return columnas;
    }

    @Override
    public MatrixIterator getIterator() {
        return iterator_B;
    }
}