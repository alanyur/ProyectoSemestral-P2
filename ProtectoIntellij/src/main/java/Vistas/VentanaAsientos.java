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
    private BusC bus; //aqui debo hacer algo para que cambie segun el boton a pulsar
    private ImageIcon icon = new ImageIcon ("src/main/resources/asientos.png");
    private ImageIcon icon2 = new ImageIcon ("src/main/resources/asientopremium.png");
    private static JButton[] sillas;
    private JButton botonci;
    public VentanaAsientos(){ //podriamos poner aca un parametro que estara dado por las otras ventanas
       /* botonci = new JButton("prueba");
        this.add(botonci); */
        bus = new BusC();
        int x = bus.getAsientos();
        int y= 0;
        int w=0;
        int v=0;
        int z= 0;
        sillas = new JButton[x];
        setLayout(null);
        this.setBackground(new Color(66, 10, 127));
        for(int i=0; i<x;i++) {
            z=i;
            Image imagenOriginal = (i < x / 2) ? icon.getImage() : icon2.getImage();
            Image imagenEscalada = imagenOriginal.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon iconEscalado = new ImageIcon(imagenEscalada);
        sillas[i]= new JButton(iconEscalado);
        if(bus.getPisos()==1) {
            if (i < x / 2) {
                sillas[i].setBounds(0, i * 25, 20, 20);
            } else {
                sillas[i].setBounds(40, y * 25, 20, 20);
                y++;
            }

        }
        if(bus.getPisos()==2){
            if (i < x / 4) {
                sillas[i].setBounds(0, i * 25, 20, 20);
            } else if(i < x /2)  {
                sillas[i].setBounds(40, y * 25, 20, 20);
                y++;}
            else if(i < x *3/4)  {
                sillas[i].setBounds(80, w * 25, 20, 20);
                w++;}
            else   {
                sillas[i].setBounds(120, v * 25, 20, 20);
                v++;}
            }
            int finalZ = z;
        if(i < x /2) {
            sillas[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.print("en el asiento" + finalZ);
                }
            });
            //tengo que cambiarle el tamaño a la imagen
            this.add(sillas[i]);
         }
        else{
            sillas[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.print("en el asiento (premium) " + finalZ);
                }
            });
            //tengo que cambiarle el tamaño a la imagen
            this.add(sillas[i]);
        }
        }
    /*for(int i=0; i<bus.getAsientos();i++) {

        }*/
    }
}
