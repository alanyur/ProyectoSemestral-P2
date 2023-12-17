package Vistas;

public class OriginatorBu {
    private VentanaBuses estado;

    public void setEstado(VentanaBuses estado) {
        this.estado = estado;
    }

    public VentanaBuses getEstado() {
        return estado;
    }
    public MementoBu guardar(){
        return new MementoBu(estado);
    }
    public void restaurar(MementoBu m){
        this.estado=m.getEstado();
    }
}
