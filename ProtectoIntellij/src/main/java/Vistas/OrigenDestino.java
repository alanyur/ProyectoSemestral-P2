package Vistas;

import javax.swing.*;
import javax.swing.border.Border;
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
    private JLabel logo;
    static String Ruta = "";
    private VentanaOrigen ventanaOrigen;
    private VentanaDestino ventanaDestino;

    public OrigenDestino(){

        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0x083563));

        origen = new JButton("Origen");
        this.add(origen);
        DarEstilos(origen);


            origen.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                     ventanaOrigen = new VentanaOrigen();
                    //Ruta += ventanaOrigen.getOrigen();

                    origen.setVisible(false);

                }
            });
        //originatorOR.setEstado(ventanaOrigen);
        //CaretakerOR.addmementoOR(originatorOR.guardar());

        logo = new JLabel(icon);
        this.add(logo);

        destino = new JButton("Destino");
        this.add(destino);
        DarEstilos(destino);
        destino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 ventanaDestino = new VentanaDestino();
                //Ruta += "-" + ventanaDestino.getDestino();
                destino.setVisible(false);
            }
        });


    }
    public String getRuta() {
        return Ruta;
    }

    public VentanaOrigen getOrigen() {
        return ventanaOrigen;
    }

    public VentanaDestino getDestino() {
        return ventanaDestino;}

    public void DarEstilos(JButton btn){
        btn.setBackground(new Color(0xEEA31D));
        btn.setForeground(new Color(0,0,0));
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.setPreferredSize(new Dimension(200, 80));

    }
}
