package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        for (int i = 0; i < Ciudades.size(); i++) {
            int index = i;
            Panel.add(Ciudades.get(index));
            Ciudades.get(index).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Ciudades.remove(index);
                    VentanaDestino.this.setVisible(false);
                    //aquí podemos agregar algo para que la ventana sepa las direcciones
                }
            });
        }
    }
}
