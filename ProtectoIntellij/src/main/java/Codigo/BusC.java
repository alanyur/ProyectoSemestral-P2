package Codigo;

/**
 *
 *   BusC: Representa al tipo de bus grande, 60 asientos, 2 piso.
 *   @author Juan Agustín Umaña Silva
 *   @author Alan Yuren Ibacache Gonelli
 *
 */
public class BusC extends Buses implements Bus_Iterator{
    private static final long serialVersionUID = 4L;
    private int asientos = 64;
    private int pisos = 2;
    private int filas = asientos/8;
    private int columnas = 8;
    private int[][] MatrizData = new int[ (asientos/2) /4 ][8];

    public BusC() {
        //RellenoMatriz(MatrizData);
    }
    public void PrintData(){
        for (int i = 0; i < MatrizData.length ; i++) {
            for (int j = 0; j < MatrizData[i].length; j++) {
                System.out.print(MatrizData[i][j] + " ");
            }
            System.out.println();
        }
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
    public int getAsientos() {
        return asientos;
    }
    public int getPisos(){
        return pisos;
    }

}
