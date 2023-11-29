package Vistas;

import javax.swing.*;
import java.util.ArrayList;

public class VentanaDestino extends JFrame {
    private JPanel Panel;
    private JFrame ventanaOrigen;
    private JFrame ventanaDestino;
    private ArrayList<JButton> Ciudades = VentanaOrigen.getCiudades();
    public VentanaDestino(){
        this.setSize(500,500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(true);

        Panel = new JPanel();
        this.add(Panel);
        for (int i = 0; i < Ciudades.size(); i++) {
            Panel.add(Ciudades.get(i));
        }
    }
}
