package Codigo;

import java.io.*;

/**
 * Buses: Representa cualquier tipo de Bus.
 * @ Juan Agustin Umaña Silva
 * @ Alan Yuren Ibacache Gonelli
 */
public abstract class Buses implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int asientos;
    private int pisos;

    public Buses() {

    }

    public abstract int getAsientos();
    public abstract int getPisos();
    public abstract int getFilas();
    public abstract int getColumnas();
    public void llenar(MatrixIterator iterator){
        while (iterator.hasNext()) {
            iterator.setElement(0);
            iterator.next();
        }
    }
    public  void Print(MatrixIterator iterator,int[][] MatrizData){
        int count = 0;
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
            count++;
            if (count == MatrizData[0].length) { // Añade un salto de línea después de cada fila
                System.out.println();
                count = 0;
            }
        }
    }
    public static void GuardarBus(Buses bus, String archivo){
        try(ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo))) {
            salida.writeObject(bus);
            System.out.println("Bus guardado en: " + archivo);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static Buses CargarBus(String archivo){
        try(ObjectInput entrada = new ObjectInputStream(new FileInputStream(archivo))){
            Buses bus = (Buses) entrada.readObject();
            System.out.println("Bus cargado desde: " + archivo);
            return bus;
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

}

