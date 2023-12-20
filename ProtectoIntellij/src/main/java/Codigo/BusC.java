package Codigo;

/**
 *
 *   BusC: Representa al tipo de bus grande, 60 asientos, 2 piso.
 *   @author Juan Agustín Umaña Silva
 *   @author Alan Yuren Ibacache Gonelli
 *
 */
public class BusC extends Buses {
    private static final long serialVersionUID = 4L;
    private int asientos = 64;
    private int pisos = 2;
    private int filas = asientos/8;
    private int columnas = 8;
    private int[][] MatrizData_C = new int[ (asientos/2) /4 ][8];
    public MatrixIterator iterator_C = new MatrixIterator(MatrizData_C);
    private String patente = "";

    public BusC() {
        llenar(iterator_C);
    }

    public BusC(String patente) {
        this.patente = patente;
    }
    public void Print_C(){
        iterator_C = new MatrixIterator(MatrizData_C);
        Print(iterator_C,MatrizData_C);
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
        return iterator_C;
    }
}
