package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botones extends JPanel {
    private JButton siguiente = new JButton("Siguiente");
    private JButton Volver = new JButton("Volver");
    private Font fuente = new Font("Arial",Font.BOLD,20);
    private JLabel derecho = new JLabel();
    private JLabel centro = new JLabel("<html> <font color = red> Debes Completar todo </font> </html>");
    private JLabel izquierdo = new JLabel();

    public Botones(){
        this.setLayout(new FlowLayout());
        this.add(Volver);
        this.add(centro);
        centro.setVisible(false);
        centro.setFont(fuente);
        this.add(siguiente);

        siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centro.setVisible(true);
            }
        });
    }
}
