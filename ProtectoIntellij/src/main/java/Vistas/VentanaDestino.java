package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static Vistas.VentanaOrigen.mapaBotonCiudad;

/**
 * VentanaDestino: JFrame que funciona para seleccionar cual sera la cuidad de destino del pasajero
 * Hace una instancia de VentanaOrigen para poder saber que cuidad se elegio como origen.
 * @ Juan Agustin Umaña Silva
 * @ Alan Yuren Ibacache Gonelli
 */
public class VentanaDestino extends VentanaOrigen {
    private JPanel Panel;
    private ArrayList<JButton> Ciudades = (ArrayList<JButton>) DatosCompartidos.getBtnCiu().clone();
    public VentanaDestino(){
        Ciudades = (ArrayList<JButton>) DatosCompartidos.getBtnCiu().clone();

        this.setSize(500, 500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(true);

        Panel = new JPanel();
        this.add(Panel);

        for (JButton ciudadButton : Ciudades) {
            Panel.add(ciudadButton);
            ciudadButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton botonPresionado = (JButton) e.getSource();
                    String ciudadSeleccionada = mapaBotonCiudad.get(botonPresionado);
                    DatosCompartidos.setDestino(ciudadSeleccionada);
                    VentanaDestino.this.setVisible(false);
                    //aquí puedes agregar lógica adicional si es necesario
                }
            });
        }
    }


}
