package Vistas;

public class OriginatorOd {
    private OrigenDestino estado;

    public void setEstado(OrigenDestino estado) {
        this.estado = estado;
    }

    public OrigenDestino getEstado() {
        return estado;
    }
    public MementoOd guardar(){
        return new MementoOd(estado);
    }
    public void restaurar(MementoOd m){
        this.estado=m.getEstado();
    }
}
