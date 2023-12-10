package Vistas;

import Codigo.Horarios;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class VentanaBuses extends JPanel {
    private ImageIcon logoElige = new ImageIcon("src/main/resources/logoUltimo.png");
    private JButton A;
    private JButton B;
    private JButton C;
    private VentanaOrigen ventanaOrigen;
    private VentanaDestino ventanaDestino;
    private JLabel LOGO;
    private JLabel[] buses = new JLabel[5];
    private Horarios[] horariosArray;
    private String Ruta;
    private String horario;
    private Random random = new Random();


    public VentanaBuses() {

        setRuta("Tu valor de Ruta aquí");

        LOGO = new JLabel(logoElige);
        this.add(LOGO);


        horariosArray = Horarios.values();
        this.setBackground(new Color(6, 0, 27));
        setLayout(new GridLayout(2,1));

        /*A = new JButton("");
        this.add(A);

        B = new JButton("B");
        this.add(B);

        C = new JButton("C");
        this.add(C);*/


        for(int i = 0; i < buses.length; i++) {
            buses[i] = new JLabel();
            this.add(buses[i]);
        }
        atributos();
    }
    public void atributos(){
        for (int i = 0; i < buses.length; i++) {
            int index = random.nextInt(horariosArray.length);

            horario = horariosArray[index].getHora();

            buses[i].setSize(1200,500);

            String labelText = "<html><b>Ruta:</b> " + Ruta + "<br><b>Horario de Salida:</b> " + horario + "</html>";

            buses[i].setText(labelText);
        }
    }

    public void setRuta(String ruta) {
        Ruta = ruta;
    }
}
