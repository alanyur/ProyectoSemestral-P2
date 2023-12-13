package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton siguiente = new JButton("Siguiente");
    private JLabel logo;
    static String Ruta = "";
    private String TextOrigen;
    private String TextDestino;
    public OrigenDestino(){
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(61, 100, 227));

        origen = new JButton("Origen");
        this.add(origen);
            origen.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    VentanaOrigen ventanaOrigen = new VentanaOrigen();
                    //Ruta += ventanaOrigen.getOrigen();
                }
            });

        logo = new JLabel(icon);
        this.add(logo);

        destino = new JButton("Destino");
        this.add(destino);
        destino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaDestino ventanaDestino = new VentanaDestino();
                //Ruta += "-" + ventanaDestino.getDestino();
            }
        });



    }

    public String getRuta() {
        return Ruta;
    }
}
