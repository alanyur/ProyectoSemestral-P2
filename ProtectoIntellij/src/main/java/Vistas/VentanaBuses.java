package Vistas;

import javax.swing.*;
import java.awt.*;

public class VentanaBuses extends JPanel {
    private JButton A;
    private JButton B;
    private JButton C;


    public VentanaBuses() {
        this.setBackground(new Color(6, 0, 27));
        A=new JButton("A");
        B=new JButton("B");
        C=new JButton("C");
        setLayout(new FlowLayout());
        this.add(A);
        this.add(B);
        this.add(C);
    }
}
