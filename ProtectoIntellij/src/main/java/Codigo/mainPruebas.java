package Codigo;


import Vistas.DatosCompartidos;

import java.util.Iterator;

public class mainPruebas {
    public static void main(String[] args){
        BusA busA = new BusA();
            busA.iterator_A.setElementAt(1,2,0);
        BusB busB = new BusB();
            busB.iterator_B.setElementAt(1,2,0);
        BusC busC = new BusC();
            busC.iterator_C.setElementAt(1,2,0);
            Recorridos aux = Recorridos.bucarRecorrido(Ciudades.CONCEPCION,Ciudades.CHILLAN);

    }
}
