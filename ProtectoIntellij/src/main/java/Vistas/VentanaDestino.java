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
    private JFrame ventanaOrigen = new VentanaOrigen();
    private JFrame ventanaDestino;
    private ArrayList<JButton> Ciudades = VentanaOrigen.getCiudades();
    private String Destino;
    public VentanaDestino(){
        Destino = "";
        //OriginatorDE originatorDE = new OriginatorDE();
        //CaretakerDE caretakerDE = new CaretakerDE();
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
                    JButton botonPresionado = (JButton) e.getSource();
                    VentanaDestino.this.setVisible(false);
                    //aquí podemos agregar algo para que la ventana sepa las direcciones
                }
            });
        }
    }

    public String getDestino() {
        return Destino;
    }
}
