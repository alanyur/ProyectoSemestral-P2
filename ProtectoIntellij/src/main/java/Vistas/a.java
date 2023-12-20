package Vistas;

import javax.swing.*;

public class a extends Exception{
    public a(){
        super("a");
        JOptionPane.showMessageDialog(null, "INTENTE DE NUEVO, SELECCIONE CON SENTIDO", "Error", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
}
