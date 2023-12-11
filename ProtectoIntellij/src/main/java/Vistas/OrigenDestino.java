package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrigenDestino extends JPanel {
    private ImageIcon icon = new ImageIcon("src/main/resources/logo1(1).png");
    private JButton origen;
    private JButton destino;
    private JButton siguiente = new JButton("Siguiente");
    private JLabel logo;
    private String Ruta;
    private String TextOrigen;
    private String TextDestino;
    public OrigenDestino(){
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(61, 100, 227));

        origen = new JButton("Origen");
        this.add(origen);
            origen.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    VentanaOrigen ventanaOrigen = new VentanaOrigen();
                    TextOrigen = ventanaOrigen.getOrigen();
                }
            });

        logo = new JLabel(icon);
        this.add(logo);

        destino = new JButton("Destino");
        this.add(destino);
        destino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaDestino ventanaDestino = new VentanaDestino();
                TextDestino = ventanaDestino.getDestino();
            }
        });



    }

    public String getRuta() {
        return Ruta;
    }
}
