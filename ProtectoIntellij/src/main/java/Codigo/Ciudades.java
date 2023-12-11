package Codigo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public enum Ciudades {
    SANTIAGO("Santiago"),
    VALPARAISO("Valparaíso"),
    CONCEPCION("Concepción"),
    CHILLAN("Chillán");

    private final String nombreCiudad;
    private JButton botonCiudad;

    Ciudades(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
        this.botonCiudad = new JButton();
        this.botonCiudad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al hacer clic en el botón de la ciudad
                System.out.println("Has seleccionado: " + Ciudades.this.getNombreCiudad());
            }
        });
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public JButton getBotonCiudad() {
        return botonCiudad;
    }
}