package Vistas;

import javax.swing.*;
import java.util.ArrayList;

public class DatosCompartidos {
    private static String origen = "";
    private static String destino = "";
    private static ArrayList<JButton> btnCiu = new ArrayList<>();
    private static ArrayList<String> ciudadesSeleccionadas = new ArrayList<>();
    private static String Ruta = "";

    public static ArrayList<String> getCiudadesSeleccionadas() {
        return ciudadesSeleccionadas;
    }

    public static void setCiudadesSeleccionadas(ArrayList<String> ciudadesSeleccionadas) {
        DatosCompartidos.ciudadesSeleccionadas = ciudadesSeleccionadas;
    }

    public static String getOrigen() {
        return origen;
    }

    public static void setOrigen(String origen) {
        DatosCompartidos.origen = origen;
    }

    public static String getDestino() {
        return destino;
    }

    public static void setDestino(String ciudadDestino) {
        if (destino.isEmpty()) {
            destino = ciudadDestino;
        }
    }

    public static ArrayList<JButton> getBtnCiu() {
        return btnCiu;
    }

    public static void setBtnCiu(ArrayList<JButton> btnCiu) {
        DatosCompartidos.btnCiu = btnCiu;
    }

    public static String getRuta() {
        return Ruta;
    }

    public static void setRuta(String ruta) {
        Ruta = ruta;
    }
}
