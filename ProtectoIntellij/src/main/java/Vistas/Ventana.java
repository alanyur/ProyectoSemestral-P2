package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ventana extends JFrame {
    private String Ruta;
    private Botones botones = new Botones();
    private OrigenDestino origenDestino;
    private VentanaBuses venbu;
    private VentanaAsientos vena;
    private VentanaAsientos ventanaAsientos;
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


        this.add(botones);
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
        });

        origenDestino = new OrigenDestino();
        Ruta = origenDestino.getRuta();
        this.add(origenDestino);
        origenDestino.setBounds(0 ,0 ,1200,500);
        origenDestino.setVisible(true);

        venbu = new VentanaBuses();
        venbu.setRuta(Ruta);
        this.add(venbu);
        venbu.setBounds(0 ,0 ,1200,500);
        venbu.setVisible(false);

        ventanaAsientos = new VentanaAsientos();
        this.add(ventanaAsientos);
        ventanaAsientos.setBounds(0 ,0 ,1200,500);
        ventanaAsientos.setVisible(false);




        this.setVisible(true);
    }
    public void QueAbrir(int aux){
        if(aux == 1){
            origenDestino.setVisible(false);
            venbu.setVisible(true);
        } else if(aux == 2) {
            venbu.setVisible(false);
            ventanaAsientos.setVisible(true);
        }
    }
    public void QueCerra(int aux){
        if(aux == 1 ){
            ventanaAsientos.setVisible(false);
            venbu.setVisible(true);
        } else if(aux == 2){
            venbu.setVisible(false);
            origenDestino.setVisible(true);
        }
    }
}
