package Codigo;

public class Ciudad {
    private int codigo;
    private String Nombre;
    public Ciudad(int codigo, String Nombre){
        this.codigo = codigo;
        this.Nombre = Nombre;

    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return Nombre;
    }
}
