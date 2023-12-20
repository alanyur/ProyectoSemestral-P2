package Vistas;

import Codigo.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.HashMap;

/**
 * VentanaBuses es un JPanel que dependiendo de lo seleccionado anteriormente
 * se instancia en el JFrame Ventana con una cantidad de busesLabel (JLabels) con una ruta
 * específica (la seleccionada) que son seleccionables
 * @author Alan Yuren Ibacache Gonnelli
 * @author Juan Agustín Umaña Silva
 */
public  class VentanaBuses extends JPanel {
    private ImageIcon logoElige = new ImageIcon("src/main/resources/logoUltimo.png");
    /*private BusA bus1 = new BusA();
    private BusB bus2 = new BusB();
    private BusB bus3 = new BusB();
    private BusB bus4 = new BusB();
    private BusC bus5 = new BusC();*/
    private Buses[] Buses1;
    private JLabel LOGO;
    private JLabel[] busesLabel = new JLabel[5];
    private Horarios[] horariosArray = {
            Horarios.HORA_8,
            Horarios.HORA_10,
            Horarios.HORA_12,
            Horarios.HORA_14,
            Horarios.HORA_16
    };
    private String Ruta;
    private Ciudades origen;
    private Ciudades destino;
    private String horario;
    private HashMap<JLabel, Buses> mapaBusLabel = new HashMap<>();
    private JLabel labelSeleccionado;
    private  Buses busSeleccionado;
    private Border borde = BorderFactory.createLineBorder(new Color(0x7C8284), 2);
    private Recorridos recorridoDelBus;



    public VentanaBuses(Ciudades origen, Ciudades destino) throws a {
        if(origen==null || destino==null){
            throw new a();
        }
        this.origen = origen;
        this.destino = destino;
        Ruta = origen.getNombreCiudad() + "-" + destino.getNombreCiudad();
        recorridoDelBus = Recorridos.bucarRecorrido(origen,destino);
        Buses1 = recorridoDelBus.getBuses();


        //setRuta("Tu valor de Ruta aquí");

        LOGO = new JLabel(logoElige);
        this.add(LOGO);



        this.setBackground(new Color(0x083563));
        setLayout(new GridLayout(2,1));


        for(int i = 0; i < busesLabel.length; i++) {
            busesLabel[i] = new JLabel();
            final int index = i;
            busesLabel[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    labelSeleccionado = (JLabel) e.getSource();
                    busSeleccionado = mapaBusLabel.get(labelSeleccionado);
                    JLabel label = (JLabel) e.getSource();
                    label.setBackground(new Color(0xFFFFFF));
                    label.setOpaque(true);
                    label.repaint();
                    horario = horariosArray[index].getHora();


                    // Aquí puedes hacer lo que necesites con el objeto Buses seleccionado
                    //System.out.println("JLabel seleccionado: " + labelSeleccionado.getText());
                    System.out.println("Objeto Buses asociado: " + busSeleccionado.getAsientos());
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    JLabel label = (JLabel) e.getSource();
                    label.setBackground(new Color(0xEEA31D));
                    label.setOpaque(true);
                    label.repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    JLabel label = (JLabel) e.getSource();
                    label.setBackground(new Color(0x083563));
                    label.setOpaque(true);
                    label.repaint();
                }
            });
            this.add(busesLabel[i]);
            LabelEstilos(busesLabel[i]);
        }
        atributos();
    }
    public Buses getBus(){
        return busSeleccionado;
    }
    public void atributos(){
        for (int i = 0; i < busesLabel.length; i++) {


            Buses busAsociado = Buses1[i];
            int asientos = busAsociado.getAsientos();


            busesLabel[i].setSize(1200,500);

            String labelText = "<html><font color='black'><b>Ruta:</b> " + Ruta + "<br><b>Horario de Salida:</b> " + horariosArray[i].getHora() + "<br><b>Numero de Asientos: </b> " + Integer.toString(asientos) ;

            busesLabel[i].setText(labelText);

            mapaBusLabel.put(busesLabel[i], busAsociado);

            String rutaCarpeta = "src/main/datos";

            File carpeta = new File(rutaCarpeta);

            String archivo = Ruta +"-"+ horariosArray[i].getHora() +"-"+ asientos + ".dat";

            Buses.GuardarBus(busAsociado,carpeta.getPath() + "/" +archivo);

        }
    }

    public void setRuta(String ruta) {
        Ruta = ruta;
    }
    public String getRuta(){
        return Ruta;
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

    public void LabelEstilos( JLabel jLabel ){
           jLabel.setBackground(new Color(238, 163, 29));
           jLabel.setForeground(new Color(0,0,0));
           jLabel.setFont(new Font("Arial", Font.BOLD, 15));
           jLabel.setBorder(borde);
    }

    @Override
    public String toString() {
        return "VentanaBuses{" +
                "Ruta ='" + Ruta + '\'' +
                ", origen =" + origen +
                ", destino =" + destino +
                ", horario ='" + horario + '\'' +
                '}';
    }

    public String getHorario() {
        return horario;
    }

    public void Cargar(Buses[] aux){
        for (int i = 0; i < aux.length; i++) {
            //Codigo.Buses.
        }
    }
}
