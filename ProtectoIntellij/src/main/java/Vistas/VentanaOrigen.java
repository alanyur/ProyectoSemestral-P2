package Vistas;

import Codigo.Ciudades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * VentanaOrigen: JFrame que sirve para seleccionar la cuidad de origen del pasajero
 * Esta clase implementa parte de la ruta en VentanaBuses
 *
 */
public class VentanaOrigen extends JFrame {
    private JPanel Panel;
    private String Origen;
    private static HashMap<JButton, String> mapaBotonCiudad;
    private static ArrayList<JButton> CiudadesArrayList = new ArrayList<>();
    private static ArrayList<String> NombresCiudades = new ArrayList<>();
    public VentanaOrigen(int u){

    }
    public VentanaOrigen() {
        mapaBotonCiudad = new HashMap<>();
        Origen = "";

        CiudadesArrayList.clear();
        this.setSize(500, 500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(true);

        Panel = new JPanel();
        this.add(Panel);

        LlenarCuidades();
        AsignarImagen();

        for (int j = 0; j < CiudadesArrayList.size(); j++ ) {
            mapaBotonCiudad.put(CiudadesArrayList.get(j), NombresCiudades.get(j) ); // Asociamos el botón con la ciudad

            CiudadesArrayList.get(j).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton botonPresionado = (JButton) e.getSource();
                    String ciudadSeleccionada = mapaBotonCiudad.get(botonPresionado); //  la ciudad asociada al botón

                    OrigenDestino.Ruta += ciudadSeleccionada; //  el nombre de la ciudad seleccionada en la variable Origen
                    botonPresionado.setVisible(false);

                    VentanaOrigen.this.setVisible(false);
                }
            });

            Panel.add(CiudadesArrayList.get(j));
        }
        System.out.println(Origen);
    }


    public void LlenarCuidades() {
        for(Ciudades ciudad : Ciudades.values()){
            CiudadesArrayList.add(ciudad.getBotonCiudad());
            NombresCiudades.add(ciudad.getNombreCiudad());
        }
    }

    public void AsignarImagen() {
        ImageIcon concepcion = new ImageIcon("src/main/resources/ConcepcionBton.png");
        ImageIcon Chillan = new ImageIcon("src/main/resources/ChillanBton.png");
        ImageIcon Santiago = new ImageIcon("src/main/resources/SantiagoBton.png");
        ImageIcon Valparaiso = new ImageIcon("src/main/resources/ValparaísoBton.png");

        CiudadesArrayList.get(0).setIcon(Santiago);
        CiudadesArrayList.get(1).setIcon(Valparaiso);
        CiudadesArrayList.get(2).setIcon(concepcion);
        CiudadesArrayList.get(3).setIcon(Chillan);
    }

    public static ArrayList<JButton> getCiudades() {
        return CiudadesArrayList;
    }

    public static HashMap<JButton, String> getMapaBotonCiudad() {
        return mapaBotonCiudad;
    }

    public void setMapaBotonCiudad(HashMap<JButton, String> mapaBotonCiudad) {
        this.mapaBotonCiudad = mapaBotonCiudad;
    }

    public static ArrayList<String> getNombresCiudades() {
        return NombresCiudades;
    }

    public static void setNombresCiudades(ArrayList<String> nombresCiudades) {
        NombresCiudades = nombresCiudades;
    }

    public String getOrigen() {
        return Origen;
    }
}
