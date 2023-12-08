package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ventana extends JFrame {
    private Botones botones;
    private PanelPrincipal panelPrincipal;
    //private OrigenDestino origenDestino;
    //OrigenDestino
        private boolean estado1;
        private boolean esVisible = true;
    public Ventana(){
        this.setLayout(null);
        this.setBounds(0,0,1200,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        panelPrincipal = new PanelPrincipal();
        this.add(panelPrincipal);
        panelPrincipal.setBounds(0 ,0 ,1200,500);
        panelPrincipal.setVisible(true);

        botones = new Botones();
        botones.setEstado1(estado1);
        this.add(botones);
        botones.addMouseListener(new MouseListener() {
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
                botones.setEstado1(estado1);

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        // imprimir la ruta en pantalla
        botones.setRuta(panelPrincipal.origenDestino.RutaElejida(
                            panelPrincipal.origenDestino.getCiudad1(),
                            panelPrincipal.origenDestino.getCiudad2()
                        )
        );
        botones.setBounds(0,500,1200,200);
        botones.setVisible(true);
        this.setVisible(true);
    }
    public void actualizarEstado(boolean nuevoEstado) {
        estado1 = nuevoEstado;
    }
    public void actualizacionDe( boolean nuevo, boolean antiguo ){
        antiguo = nuevo;
    }
}
