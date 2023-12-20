package Codigo;

/**
 * BusA: Representa al tipo de bus pequeño, 20 asientos, 1 piso.
 * @author Juan Agustín Umaña Silva
 * @author Alan Yuren Ibacache Gonelli
 */
public class BusA extends Buses {
    private static final long serialVersionUID = 2L;
    private int asientos = 20;
    private int pisos = 1;
    private int filas = asientos/4;
    private int columnas = 4;
    private int[][] MatrizData_A = new int[filas][columnas];
    public MatrixIterator iterator_A = new MatrixIterator(MatrizData_A);
    private String patente = "";

    public BusA() {
        llenar(iterator_A);
    }
    public BusA(String patente){
        this.patente = patente;
    }
    public void Print_A(){
        iterator_A = new MatrixIterator(MatrizData_A);
        Print(iterator_A,MatrizData_A);
    }
    public int getAsientos() {
        return asientos;
    }
    public int getPisos(){
        return pisos;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    @Override
    public int[][] getMatriz() {
        return MatrizData_A;
    }

    @Override
    public MatrixIterator getIterator() {
        return iterator_A;
    }

    public int[][] getMatrizData() {
        return MatrizData_A;
    }
}
