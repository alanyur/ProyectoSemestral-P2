package Codigo;

public enum Recorridos {
    CONCEPCION_A_SANTIAGO(Ciudades.CONCEPCION, Ciudades.SANTIAGO),
    CONCEPCION_A_VALPARAISO(Ciudades.CONCEPCION, Ciudades.VALPARAISO),
    CONCEPCION_A_CHILLAN(Ciudades.CONCEPCION,Ciudades.CHILLAN),
    SANTIAGO_A_CONCEPCION(Ciudades.SANTIAGO, Ciudades.CONCEPCION),
    SANTIAGO_A_VALPARAISO(Ciudades.SANTIAGO, Ciudades.VALPARAISO),
    SANTIAGO_A_CHILLAN(Ciudades.SANTIAGO, Ciudades.CHILLAN),
    VALPARAISO_A_CONCEPCION(Ciudades.VALPARAISO, Ciudades.CONCEPCION),
    VALPARAISO_A_SANTIAGO(Ciudades.VALPARAISO, Ciudades.SANTIAGO),
    VALPARAISO_A_CHILLAN(Ciudades.VALPARAISO, Ciudades.CHILLAN),
    CHILLAN_A_CONCEPCION(Ciudades.CHILLAN, Ciudades.CONCEPCION),
    CHILLAN_A_SANTIAGO(Ciudades.CHILLAN, Ciudades.SANTIAGO),
    CHILLAN_A_VALPARAISO(Ciudades.CHILLAN, Ciudades.VALPARAISO);

    private final Ciudades ciudadOrigen;
    private final Ciudades ciudadDestino;
    private Buses[] buses = {new BusA(), new BusB(), new BusB(),new BusB(), new BusC()};

    Recorridos(Ciudades ciudadOrigen, Ciudades ciudadDestino) {
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }
    public static Recorridos bucarRecorrido(Ciudades origen, Ciudades destino){
        Recorridos[][] recorridosEncontrados = new Recorridos[Ciudades.values().length][Recorridos.values().length];
        int index = 0;

        for (Recorridos recorridos: Recorridos.values()) {
            if(recorridos.getCiudadOrigen() == origen && recorridos.getCiudadDestino() == destino ){
                return recorridos;
            }
        }
        return null;
    }

    public Ciudades getCiudadOrigen() {
        return ciudadOrigen;
    }

    public Ciudades getCiudadDestino() {
        return ciudadDestino;
    }

    public Buses[] getBuses() {
        return buses;
    }
}

