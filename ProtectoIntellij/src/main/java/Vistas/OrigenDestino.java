package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrigenDestino extends JPanel {
    private ImageIcon icon = new ImageIcon("src/main/resources/logo1.png");
    private JButton origen, destino;
    private JButton siguiente = new JButton("Siguiente");
    private JLabel logo;
    public OrigenDestino(){
        this.setLayout(null);
        this.setBackground(new Color(61, 100, 227));
        this.add(origen);
        this.add(destino);

        logo = new JLabel(icon);
        this.add(logo);

        origen = new JButton("Origen");
        this.add(origen);

        destino = new JButton("Destino");
        this.add(destino);

    }
}
