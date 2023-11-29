package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaOrigen extends JFrame {
    private String[] Cuidades = {"Concepcion, Santiago, Valparaiso, Chillan"};
    private JPanel Panel;
    private static ArrayList<JButton> Ciudades = new ArrayList<>();
    public VentanaOrigen() {
        Ciudades.clear();
        this.setSize(500, 500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(true);

        Panel = new JPanel();
        this.add(Panel);
        LlenarCuidades();
        AsignarImagen();
        for (int i = 0; i < Ciudades.size(); i++) {
            int index = i;
            Panel.add(Ciudades.get(index));
            Ciudades.get(index).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Ciudades.remove(index);
                    VentanaOrigen.this.setVisible(false);
                }
            });
        }
    }

    public void LlenarCuidades() {
        for (int i = 0; i < 4; i++) {
            JButton ciudad = new JButton();
            Ciudades.add(i, ciudad);
        }
    }

    public void AsignarImagen() {
        ImageIcon concepcion = new ImageIcon("src/main/resources/ConcepcionBton.png");
            Ciudades.get(0).setIcon(concepcion);
        ImageIcon Chillan = new ImageIcon("src/main/resources/ChillanBton.png");
            Ciudades.get(1).setIcon(Chillan);
        ImageIcon Santiago = new ImageIcon("src/main/resources/SantiagoBton.png");
            Ciudades.get(2).setIcon(Santiago);
        ImageIcon Valparaiso = new ImageIcon("src/main/resources/ValparaísoBton.png");
            Ciudades.get(3).setIcon(Valparaiso);
    }

    public static ArrayList<JButton> getCiudades() {
        return Ciudades;
    }
}
