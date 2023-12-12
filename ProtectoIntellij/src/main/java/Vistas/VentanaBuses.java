package Vistas;

import Codigo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Random;

public  class VentanaBuses extends JPanel {
    private BusSelecListener Listener;
    public void SetBusSelecListener(BusSelecListener listener){
        this.Listener = listener;

    }
    private ImageIcon logoElige = new ImageIcon("src/main/resources/logoUltimo.png");
    private JButton A;
    private JButton B;
    private JButton C;
    private BusA busA = new BusA();
    private BusB busB = new BusB();
    private BusC busC = new BusC();
    private Buses[] Buses = new Buses[3];
    private VentanaOrigen ventanaOrigen;
    private VentanaDestino ventanaDestino;
    private JLabel LOGO;
    private JLabel[] buses = new JLabel[5];
    private Horarios[] horariosArray;
    private String Ruta;
    private String horario;
    private Random random = new Random();
    private HashMap<JLabel, Buses> mapaBusLabel = new HashMap<>();
    private JLabel labelSeleccionado;
    private  Buses busSeleccionado;



    public VentanaBuses(String ruta) {
        this.Ruta = ruta;


        //setRuta("Tu valor de Ruta aquí");

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
            buses[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    labelSeleccionado = (JLabel) e.getSource();
                    busSeleccionado = mapaBusLabel.get(labelSeleccionado);
                    seleccionarBus(busSeleccionado);


                    // Aquí puedes hacer lo que necesites con el objeto Buses seleccionado
                    System.out.println("JLabel seleccionado: " + labelSeleccionado.getText());
                    System.out.println("Objeto Buses asociado: " + busSeleccionado.getAsientos());
                }
            });
            this.add(buses[i]);
        }
        atributos();
    }
    public void atributos(){
        Buses[0] = busA;
        Buses[1] = busB;
        Buses[2] = busC;

        for (int i = 0; i < buses.length; i++) {


            int index1 = random.nextInt(horariosArray.length);
            int index2 = random.nextInt(Buses.length);

            Buses busAsociado = Buses[index2];
            int asientos = busAsociado.getAsientos();

            horario = horariosArray[index1].getHora();

            buses[i].setSize(1200,500);

            String labelText = "<html><font color='red'><b>Ruta:</b> " + Ruta + "<br><b>Horario de Salida:</b> " + horario + "<br><b>Numero de Asientos: </b> " + Integer.toString(asientos) ;




            buses[i].setText(labelText);

            mapaBusLabel.put(buses[i], busAsociado);
        }
    }

    public void setRuta(String ruta) {
        Ruta = ruta;
    }

    public JLabel getLabelSeleccionado() {
        return labelSeleccionado;
    }
    public HashMap<JLabel, Buses> getMapaBusLabel(){
        return mapaBusLabel;
    }

    public  Codigo.Buses getBusSeleccionado() {
        return busSeleccionado;
    }
    private void seleccionarBus(Buses Seleccionado) {
        if (Listener != null) {
            Listener.busSlec(Seleccionado);
        }
    }
}
