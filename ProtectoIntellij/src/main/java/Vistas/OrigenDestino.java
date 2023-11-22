package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrigenDestino extends JPanel {
    private ImageIcon icon = new ImageIcon("src/main/resources/logo1.png");
    private JButton origen = new JButton();
    private JButton destino = new JButton();
    private JButton siguiente = new JButton("Siguiente");
    private JLabel logo;
    public OrigenDestino(){
        this.setBackground(new Color(61, 100, 227));
        this.add(origen);
        this.add(destino);

        logo = new JLabel(icon);
        this.add(logo);
    }
}
