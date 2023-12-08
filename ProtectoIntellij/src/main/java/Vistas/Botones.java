package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Botones extends JPanel {
    private JButton siguiente = new JButton("Siguiente");
    private JButton Volver = new JButton("Volver");
    private Font fuente = new Font("Arial",Font.BOLD,20);
    private JLabel derecho = new JLabel();
    private JLabel centro = new JLabel("<html> <font color = red> Debes Completar todo </font> </html>");
    private JLabel izquierdo = new JLabel();
    private String Ruta;
    private boolean estado1;
    private boolean siguienteOrigenDestino;



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
                    if (estado1 != true){
                        centro.setVisible(true);
                        siguienteOrigenDestino = false;

                    }
                }
            });
        this.add(izquierdo);
            izquierdo.setVisible(true);
        this.addMouseListener(new MouseListener() {
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

            }

            @Override
            public void mouseExited(MouseEvent e) {
                centro.setVisible(false);
            }

        });
    }


    public void setRuta(String ruta) {
        Ruta = ruta;
    }

    public boolean isEstaLleno1() {
        return estado1;
    }

    public void setEstado1(boolean estado1) {
        this.estado1 = estado1;
    }

    public boolean isSiguienteOrigenDestino() {
        return siguienteOrigenDestino;
    }

    public void setSiguienteOrigenDestino(boolean siguienteOrigenDestino) {
        this.siguienteOrigenDestino = siguienteOrigenDestino;
    }
}
