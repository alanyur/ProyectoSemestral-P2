package Vistas;
//a
import Codigo.Ciudades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * VentanaOrigen: JFrame que sirve para seleccionar la cuidad de origen del pasajero
 * Esta clase implementa parte de la ruta en VentanaBuses
 * @ Juan Agustin Umaña Silva
 * @ Alan Yuren Ibacache Gonelli
 */
public class VentanaOrigen extends JFrame {
    private JPanel Panel;
    private String Origen = "Deberia estar la ciudad aqui";
    protected static HashMap<JButton, String> mapaBotonCiudad;

    public VentanaOrigen(JButton[] botones) {

        this.setSize(500, 300);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(true);

        Panel = new JPanel();
        this.add(Panel);
        for (int i = 0; i < botones.length; i++) {
            Panel.add(botones[i]);
        }

    }
    public String getOrigen() {
        return Origen;
    }
}
