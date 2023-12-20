package Vistas;

import Codigo.Ciudades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * El JPanel OrigenDestino genera en el JFrame Ventana botones de Origen y Destino que
 * al presionarlos se generan nuevas ventanas con 4 posibles lugares de origen
 * y 3 posibles lugares de destino (no se considera el mismo lugar de origen como
 * destino)
 * @author Alan Yuren Ibacache Gonnelli
 * @author Juan Agustín Umaña Silva
 */

public class OrigenDestino extends JPanel {
    private ImageIcon icon = new ImageIcon("src/main/resources/logo1(1).png");
    private JButton origen;
    private JButton destino;
    private JLabel logo;
    private VentanaOrigen ventanaOrigen;
    private VentanaDestino ventanaDestino;
    private static JButton[] botones ;
    private static JButton[] botones2;
    private static Ciudades[] ciudades =  Ciudades.values();
    private static AtomicInteger index1 = new AtomicInteger(-1);
    private static AtomicInteger index2 = new AtomicInteger(-1);
    private static AtomicReference<Ciudades> ciudad1 = new AtomicReference<>();
    private static AtomicReference<Ciudades> ciudad2 = new AtomicReference<>();

    public OrigenDestino(){

        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0x083563));

        origen = new JButton("Origen");
        this.add(origen);
        DarEstilos(origen);


            origen.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (ventanaOrigen == null) {
                        botones = new JButton[ciudades.length];
                        addBotones1(botones);
                        ventanaOrigen = new VentanaOrigen(botones);
                        ListenerBotones1(botones,ventanaOrigen,index1);
                    }
                    origen.setVisible(false);
                }
            });
        logo = new JLabel(icon);
        this.add(logo);

        destino = new JButton("Destino");
        this.add(destino);
        DarEstilos(destino);
        destino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ventanaDestino == null) {
                    botones = new JButton[ciudades.length];
                    addBotones1(botones);
                    ventanaDestino = new VentanaDestino(botones);
                    ListenerBotones2(botones,ventanaDestino,index2,index1);
                }
                destino.setVisible(false);
            }
        });
    }

    public JButton getOrigen() {
        return origen;
    }

    public JButton getDestino() {
        return destino;
    }

    public AtomicReference<Ciudades> getCiudad1() {
        return ciudad1;
    }

    public AtomicReference<Ciudades> getCiudad2() {
        return ciudad2;
    }

    public static void DarEstilos(JButton btn){
        btn.setBackground(new Color(0xEEA31D));
        btn.setForeground(new Color(0,0,0));
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.setPreferredSize(new Dimension(200, 80));

    }
    public static void addBotones1(JButton[] btns){
        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton(String.valueOf(ciudades[i]));
            DarEstilos(btns[i]);
            btns[i].putClientProperty("posicion", i);
        }
    }
    public static void ListenerBotones1(JButton[] btns, JFrame frame, AtomicInteger aux){
        for (int i = 0; i < btns.length; i++) {
            final int posicion = i;
            btns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    aux.set((int) btns[posicion].getClientProperty("posicion"));
                    ciudad1.set(ciudades[posicion]);
                }
            });
        }
    }
    private void ListenerBotones2(JButton[] btns, JFrame frame, AtomicInteger aux1, AtomicInteger aux2 ) {
        for (int i = 0; i < btns.length; i++) {
            final int posicion = i;
            btns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    aux1.set((int) btns[posicion].getClientProperty("posicion"));
                    ciudad2.set(ciudades[posicion]);

                    if(aux1.get() == aux2.get()){
                        JOptionPane.showMessageDialog(null, "NO PUEDES ELEGIR A LA MISMA CIUDAD COMO DESTINO", "Error", JOptionPane.ERROR_MESSAGE);
                        index1.set(-1);
                        index2.set(-1);
                        ventanaOrigen.setVisible(true);
                        ventanaDestino.setVisible(true);
                        System.out.println("Error");
                    }
                }
            });
        }

    }
}
