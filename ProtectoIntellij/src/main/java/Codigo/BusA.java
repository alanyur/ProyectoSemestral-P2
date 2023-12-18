package Codigo;

/**
 * BusA: Representa al tipo de bus pequeño, 20 asientos, 1 piso.
 * @author Juan Agustín Umaña Silva
 * @author Alan Yuren Ibacache Gonelli
 */
public class BusA extends Buses implements Bus_Iterator{
    private static final long serialVersionUID = 2L;
    private int asientos = 20;
    private int pisos = 1;
    private int filas = asientos/4;
    private int columnas = 4;
    private int[][] MatrizData = new int[filas][columnas];

    public BusA() {
        Bus_Iterator.Llenar(MatrizData);

    }

    public void PrintData(){
        for (int i = 0; i < MatrizData.length ; i++) {
            for (int j = 0; j < MatrizData[i].length; j++) {
                System.out.print(MatrizData[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int getAsientos() {
        return asientos;
    }
    public int getPisos(){
        return pisos;
    }


    @Override
    public boolean hasNext() {
        return filas < MatrizData.length && columnas < MatrizData[filas].length;
    }

    @Override
    public int getNext() {
        if(!hasNext()){
            throw new IndexOutOfBoundsException("No hay más elementos en la matriz");
        }
        int elemento = MatrizData[filas][columnas];
        columnas++;
        if(columnas >= MatrizData[filas].length){
            filas++;
            columnas = 0;
        }
        return elemento;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int[][] getMatrizData() {
        return MatrizData;
    }
}
