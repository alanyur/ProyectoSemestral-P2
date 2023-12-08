package Vistas;

import javax.swing.*;

public class PanelPrincipal extends JLabel {
    public OrigenDestino origenDestino;
    public PanelPrincipal(){
        origenDestino = new OrigenDestino();
        this.add(origenDestino);
        this.add(origenDestino);
        origenDestino.setBounds(0 ,0 ,1200,500);
        origenDestino.setVisible(true);
    }
}
