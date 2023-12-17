package Vistas;

public class MementoOd {
    private OrigenDestino estado;
    public MementoOd(OrigenDestino estado){
        this.estado=estado;
    }
    public OrigenDestino getEstado() {
        return estado;
    }
}
