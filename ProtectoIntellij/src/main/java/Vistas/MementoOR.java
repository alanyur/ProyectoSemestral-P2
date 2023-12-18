package Vistas;

public class MementoOR {
    private VentanaOrigen estado;
    public MementoOR(VentanaOrigen estado){
        this.estado=estado;
    }
    public VentanaOrigen getEstado() {
        return estado;
    }
}
