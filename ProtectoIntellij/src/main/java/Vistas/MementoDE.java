package Vistas;

public class MementoDE {
    private VentanaDestino estado;
    public MementoDE(VentanaDestino estado){
        this.estado=estado;
    }
    public VentanaDestino getEstado() {
        return estado;
    }
}
