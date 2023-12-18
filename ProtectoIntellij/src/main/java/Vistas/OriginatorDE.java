package Vistas;

public class OriginatorDE {
    private VentanaDestino estado;
    public void setEstado(VentanaDestino estado) {
        this.estado = estado;
    }

    public VentanaDestino getEstado() {
        return estado;
    }
    public MementoDE guardar(){
        return new MementoDE(estado);
    }
    public void restaurar(MementoDE m){
        this.estado=m.getEstado();
    }
}
