package Vistas;
import Codigo.BusA;
import Codigo.BusB;
import Codigo.BusC;
import Codigo.Buses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class VentanaAsientos extends JPanel {
    private BusA bus; //aqui debo hacer algo para que cambie segun el boton a pulsar
    private ImageIcon icon = new ImageIcon ("src/main/resources/asientos.png");
    private static JButton[] sillas;
    private JButton botonci;
    public VentanaAsientos(){
       /* botonci = new JButton("prueba");
        this.add(botonci); */
        bus = new BusA();
        int x = bus.getAsientos();
        int y= 0;
        int z= 0;
        sillas = new JButton[x];
        setLayout(null);
        this.setBackground(new Color(66, 10, 127));
        for(int i=0; i<x;i++) {
            z=i;
            Image imagenOriginal = icon.getImage();
            Image imagenEscalada = imagenOriginal.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon iconEscalado = new ImageIcon(imagenEscalada);
        sillas[i]= new JButton(iconEscalado);
        if(i<x/2) {
            sillas[i].setBounds(0, i * 25, 20, 20);
        }
        else{
            sillas[i].setBounds(40, y * 25, 20, 20);
            y++;
        }
            int finalZ = z;
            sillas[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("en el asiento" + finalZ);
            }
        });
        //tengo que cambiarle el tamaño a la imagen
        this.add(sillas[i]);
        }
    }
}
