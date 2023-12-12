package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ventana extends JFrame {
    private String Ruta;
    private OrigenDestino origenDestino;
    private VentanaBuses venbu;
    private VentanaAsientos vena;
    private VentanaAsientos ventanaAsientos;
    private JButton siguiente;
    private JPanel[] paneles = new JPanel[3];
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


        venbu = new VentanaBuses();
        Ventana.this.add(venbu);
        venbu.setBounds(0 ,0 ,1200,500);
        venbu.setVisible(false);





        ventanaAsientos = new VentanaAsientos();
        this.add(ventanaAsientos);
        ventanaAsientos.setBounds(0 ,0 ,1200,500);
        ventanaAsientos.setVisible(false);

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
