package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * VentanaDestino: JFrame que funciona para seleccionar cual sera la cuidad de destino del pasajero
 * Hace una instancia de VentanaOrigen para poder saber que cuidad se elegio como origen.
 * @ Juan Agustin Umaña Silva
 * @ Alan Yuren Ibacache Gonelli
 */
public class VentanaDestino extends JFrame {
    private JPanel Panel;
    private String destino = "Y aqui la otra";
    public VentanaDestino(JButton[] botones){

        this.setBounds(600,0,500, 300);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(true);

        Panel = new JPanel();
        this.add(Panel);
        for (int i = 0; i < botones.length; i++) {
            Panel.add(botones[i]);
        }


    }

    public String getDestino() {
        return destino;
    }
}
