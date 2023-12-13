package Vistas;

import Codigo.Buses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

/**
 * Ventana genera un JFrame con instancias de diferentes tipos de ventanas
 * (OrigenDestino, Buses, Asientos, etc.) y un JPanel con un botón el cual
 * las irá cambiando (o cerrara el JFrame en caso de que sea el último tipo
 * de ventana por elegir)
 * @author Alan Yuren Ibacache Gonnelli
 * @author Juan Agustín Umaña Silva
 */

public class Ventana extends JFrame {
    private String Ruta;
    private OrigenDestino origenDestino;
    private VentanaBuses venbu;
    private VentanaAsientos ventanaAsientos;
    private JButton siguiente;
    private JPanel[] paneles = new JPanel[3];
    private HashMap<JLabel, Buses> mapaLabelBuses;
    private JLabel LabelSelec;
    private int index = 0;
    public Ventana(){
        this.setLayout(null);
        this.setBounds(0,0,1200,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

         /*vena = new VentanaAsientos();
        this.add(vena);
        vena.setBounds(0 ,0 ,1200,500);
        vena.setVisible(true); */
        /*
        venbu = new VentanaBuses();
        this.add(venbu);
        venbu.setBounds(0 ,0 ,1200,500);
        venbu.setVisible(true); */


        /*this.add(botones);
        botones.setBounds(0,500,1200,200);
        botones.setVisible(true);
        botones.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                QueAbrir(botones.getCount1());
                QueCerra(botones.getCount2());
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });*/
        origenDestino = new OrigenDestino();
        String Or = origenDestino.getRuta();
        this.add(origenDestino);
        origenDestino.setBounds(0 ,0 ,1200,500);
        origenDestino.setVisible(true);








        //ventanaAsientos = new VentanaAsientos();
        /*ventanaAsientos.setMapa(mapaLabelBuses);
        Buses selec = mapaLabelBuses.get(LabelSelec);
        ventanaAsientos.setBusSelec(selec);*/


        paneles[0] = origenDestino;
        paneles[1] = venbu;
        paneles[2] = ventanaAsientos;


        siguiente = new JButton("Siguiente");
        this.add(siguiente);
        siguiente.setBounds(1000,500,100,100);
        siguiente.addActionListener(new ActionListener() {
            int h=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                paneles[index].setVisible(false);

                // Incrementa el índice al siguiente panel
                index = (index + 1) % paneles.length;
                if (index == 1){
                    venbu = new VentanaBuses(OrigenDestino.Ruta);

                    Ventana.this.add(venbu);
                    venbu.setBounds(0 ,0 ,1200,500);
                    paneles[index] = venbu;
                }
                if(index == 2){
                    Buses busSeleccionado = venbu.getBusSeleccionado();
                    int numeroAsientos = (busSeleccionado != null) ? busSeleccionado.getAsientos() : 0;
                    ventanaAsientos = new VentanaAsientos(numeroAsientos);
                    Ventana.this.add(ventanaAsientos);
                    ventanaAsientos.setBounds(0, 0, 1200, 500);
                    paneles[index] = ventanaAsientos;
                }

                // Muestra el siguiente panel
                paneles[index].setVisible(true);
                h++;
                if(h>2){
                    System.exit(0);
                }

            }
        });




        this.setVisible(true);
    }

}
