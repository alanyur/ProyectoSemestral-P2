package Vistas;

import Codigo.Ciudad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrigenDestino extends JPanel {
    private Ciudad[] ciudades = {
            new Ciudad(1,"Concepcion"),
            new Ciudad(2,"Santiago"),
            new Ciudad(3,"Valparaíso"),
            new Ciudad(4,"Chillán")
    };
    private ImageIcon icon = new ImageIcon("src/main/resources/logo1(1).png");
    private JButton origen, destino;
    private Object ciudad1, ciudad2;
    private JLabel logo;
    private String textoCiudadDestino;
    private boolean estaLleno = false;
    public OrigenDestino(){
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(61, 100, 227));

        origen = new JButton("Origen");
        this.add(origen);
            origen.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Object ciudadOrigen = JOptionPane.showInputDialog(
                            null,
                            "Seleccione Un Origen",
                            "Origen",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new Object[] {
                                    "Seleccione",
                                    ciudades[0].getNombre(),
                                    ciudades[1].getNombre(),
                                    ciudades[2].getNombre(),
                                    ciudades[3].getNombre()
                            },
                            "Seleccione"
                    );
                    if(ciudadOrigen.equals("Seleccione")){
                        JOptionPane.showMessageDialog(
                                null,
                                "Por favor elije una cuidad como origen o destino",
                                "ERROR_MESSAGE",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                    if(ciudadOrigen != null){
                        actualizarEstado(true);
                    }
                }
            });

        logo = new JLabel(icon);
        this.add(logo);

        destino = new JButton("Destino");
        this.add(destino);
        destino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //VentanaDestino ventanaDestino = new VentanaDestino();
                Object ciudadDestino = JOptionPane.showInputDialog(
                        null,
                        "Seleccione Un Destino",
                        "Destino",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[] {
                                "Seleccione",
                                ciudades[0].getNombre(),
                                ciudades[1].getNombre(),
                                ciudades[2].getNombre(),
                                ciudades[3].getNombre()
                        },
                        "Seleccione"
                );
                        //Hacer que no se pueda elegir el mismo origen como destino
                ciudad2 = ciudadDestino;
                if(ciudadDestino == ciudad1){
                    JOptionPane.showMessageDialog(
                            null,
                            "No puedes seleccionar como cuidad de destino tu misma ciudad de origen",
                            "ERROR_MESSAGE",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else if( ciudadDestino.equals("Seleccione") ) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Por favor elije una cuidad como origen o destino",
                            "ERROR_MESSAGE",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
                if( ciudadDestino != null ){
                    actualizarEstado(true);
                }

            }
        });


    }
    public String RutaElejida(String origen, String destino){
        String Ruta = origen+ "-" +destino;
        return Ruta;
    }

    public String getCiudad1() {
        return (String) ciudad1;
    }

    public String getCiudad2() {
        return (String) ciudad2;
    }

    public boolean isEstaLleno() {
        return estaLleno;
    }

    public void setEstaLleno(boolean estaLleno) {
        this.estaLleno = estaLleno;
    }
    public void actualizarEstado(boolean nuevoEstado) {
        estaLleno = nuevoEstado;
    }
}
