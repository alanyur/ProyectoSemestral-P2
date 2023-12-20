package Vistas;

import Codigo.Buses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

/**
 * Ventana genera un JFrame con instancias de diferentes tipos de ventanas
 * (OrigenDestino, Buses, Asientos, etc.) y un JPanel con un botón el cual
 * las irá cambiando (o cerrara el JFrame en caso de que sea el último tipo
 * de ventana por elegir)
 * @author Alan Yuren Ibacache Gonnelli
 * @author Juan Agustín Umaña Silva
 */

public class Ventana extends JFrame {
    private JLabel texto1;
    private JLabel texto2;
    private OrigenDestino origenDestino;
    private VentanaBuses venbu;
    private VentanaAsientos ventanaAsientos;
    private JButton siguiente;
    private JButton anterior;
    private JPanel[] paneles = new JPanel[4];
    private HashMap<JLabel, Buses> mapaLabelBuses;
    private JLabel Pasaje;
    private int index = 0;
    public Ventana() {
        texto2 = new JLabel();
        texto2.setBounds(450,515,400,100);
        this.add(texto2);
        texto2.setVisible(true);
        texto1 = new JLabel("Elija un Origen y un Destino para la ruta de su Bus");
        texto1.setBounds(450,500,400,100);
        this.add(texto1);
        texto1.setVisible(true);
        CaretakerBu caretakerBu = new CaretakerBu();
        CaretakerOd caretakerOd = new CaretakerOd();
        //CaretakerOR caretakerOR = new CaretakerOR();
        //CaretakerDE caretakerDE = new CaretakerDE();
        OriginatorBu originatorBu = new OriginatorBu();
        OriginatorOd originatorOd = new OriginatorOd();
        //OriginatorOR originatorOR = new OriginatorOR();
        //OriginatorDE originatorDE = new OriginatorDE();
        this.setLayout(null);
        this.setBounds(0, 0, 1200, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        origenDestino = new OrigenDestino();
        this.add(origenDestino);
        origenDestino.setBounds(0, 0, 1200, 500);
        origenDestino.setVisible(true);
        originatorOd.setEstado(origenDestino); //se guarda el estado de esta ventana
        CaretakerOd.addmementoOd(originatorOd.guardar());//se utiliza para recuperarlo más tarde
        originatorBu.setEstado(venbu); //puede que tenga que ubicarlo despues del listener de aceptar
        CaretakerBu.addmementoBus(originatorBu.guardar());


        //originatorOR.setEstado(origenDestino.getOrigen());
        //CaretakerOR.addmementoOR(originatorOR.guardar());
        //originatorDE.setEstado(origenDestino.getDestino());
        //CaretakerDE.addmementoDE(originatorDE.guardar());



        //ventanaAsientos = new VentanaAsientos();
        /*ventanaAsientos.setMapa(mapaLabelBuses);
        Buses selec = mapaLabelBuses.get(LabelSelec);
        ventanaAsientos.setBusSelec(selec);*/


        paneles[0] = origenDestino;
        paneles[1] = venbu;
        paneles[2] = ventanaAsientos;


        siguiente = new JButton("Siguiente");
        this.add(siguiente);
        siguiente.setBounds(1000,500,150,100);
        siguiente.setFont(new Font("Arial", Font.BOLD,20));
        siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    paneles[index].setVisible(false);

                    // Incrementa el índice al siguiente panel
                    index = (index + 1) % paneles.length;//circular increment
                    if (index == 1) {
                        venbu = new VentanaBuses(origenDestino.getCiudad1().get(),origenDestino.getCiudad2().get());

                        Ventana.this.add(venbu);
                        venbu.setBounds(0, 0, 1200, 500);
                        paneles[index] = venbu;
                        anterior.setVisible(true);
                        texto1.setText("Elija el Bus de su preferencia");
                        texto2.setVisible(true);
                        texto2.setText("Se tomará en cuenta el último que presione");
                    }
                    if (index == 2) {
                        Buses busSeleccionado = venbu.getBusSeleccionado();
                        int numeroAsientos = (busSeleccionado != null) ? busSeleccionado.getAsientos() : 0;
                        ventanaAsientos = new VentanaAsientos(numeroAsientos,venbu.getBus(),venbu.getRuta(),venbu.getHorario());
                        Ventana.this.add(ventanaAsientos);
                        ventanaAsientos.setBounds(0, 0, 1200, 500);
                        paneles[index] = ventanaAsientos;
                        siguiente.setText("Finalizar");
                        texto1.setText("Elija el o los asientos que quiera comprar");
                        texto2.setVisible(true);
                        texto2.setText("Si ya terminó presione Finalizar");
                    }
                    if (index == 3) {
                        ventanaAsientos.guardar();
                        System.exit(0);
                    }
                    // Muestra el siguiente panel
                    paneles[index].setVisible(true);

            }
        });
        anterior = new JButton("Anterior");
        this.add(anterior);
        anterior.setBounds(100,500,100,100);
        anterior.setVisible(false);
        anterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Restaura el estado del panel actual al estado anterior
                if(index==1) { //aqui se devuelve al primer apartado (pero los botones no son parte de este (creo))
                    //creo que hay que hacer memento para ventana destino y ventana origen
                    originatorOd.restaurar(caretakerOd.getmementoOd(0));
                    //origenDestino.resetorigen();
                    //originatorOR.restaurar(caretakerOR.getmementoOR(0));
                    //originatorDE.restaurar(caretakerDE.getmementoDE(0));
                    anterior.setVisible(false);
                    //origenDestino.getOrigen().reiniciarCiudades();
                    origenDestino = new OrigenDestino();
                    texto1.setText("Si quiere otra ruta, actualice la página");
                    texto2.setVisible(false);
                }
                if(index==2) {
                    originatorBu.restaurar(caretakerBu.getmementobu(0));
                    siguiente.setText("Siguiente");
                    texto1.setText("Elija el Bus de su preferencia");
                    texto2.setText("Se tomará en cuenta el último que presione");
                }
                if(index==0){
                    System.exit(0);
                }
                // Oculta el panel actual
                paneles[index].setVisible(false);

                // Actualiza el índice al panel anterior
                index = (index - 1 + paneles.length) % paneles.length; //circular decrement

                // Muestra el panel anterior
                paneles[index].setVisible(true);


            }
        });
        this.setVisible(true);
    }

}
