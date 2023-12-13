package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *El JPanel Botones genera el botón "Siguiente" en el JFrame Ventana
 * @author Alan Yuren Ibacache Gonnelli
 * @author Juan Agustín Umaña Silva
 */

public class Botones extends JPanel {
    private int count1 = 0, count2 = 0;
    private JButton siguiente = new JButton("Siguiente");
    private JButton Volver = new JButton("Volver");
    private JLabel derecho = new JLabel();
    private JLabel izquierdo = new JLabel();

    public Botones(){
        this.setLayout(new FlowLayout());


        this.add(Volver);
        Volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count2++;
            }
        });


        this.add(siguiente);
        siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count1++;
            }
        });
    }

    public int getCount1() {
        return count1;
    }

    public int getCount2() {
        return count2;
    }
}
