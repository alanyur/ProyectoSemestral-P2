package Vistas;

public class OriginatorOR {
    private VentanaOrigen estado;

    public void setEstado(VentanaOrigen estado) {
        this.estado = estado;
    }

    public VentanaOrigen getEstado() {
        return estado;
    }
    public MementoOR guardar(){
        return new MementoOR(estado);
    }
    public void restaurar(MementoOR m){
        this.estado=m.getEstado();
    }
}
