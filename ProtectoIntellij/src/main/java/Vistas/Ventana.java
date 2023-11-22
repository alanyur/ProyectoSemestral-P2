package Vistas;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private Botones botones;
    private OrigenDestino origenDestino;
    public Ventana(){
        this.setLayout(null);
        this.setBounds(0,0,1200,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        origenDestino = new OrigenDestino();
        this.add(origenDestino);
        origenDestino.setBounds(0 ,0 ,1200,500);
        origenDestino.setVisible(true);

        botones = new Botones();
        this.add(botones);
        botones.setBounds(0,500,1200,200);
        botones.setVisible(true);

        this.setVisible(true);
    }
}
