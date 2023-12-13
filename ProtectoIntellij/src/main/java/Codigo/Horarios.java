package Codigo;

/**
 * Horarios: enum que representa los horarios en los que sale cada bus desde 08:00AM hasta 22:00PM
 *  @ Juan Agustin Umaña Silva
 *   @ Alan Yuren Ibacache Gonelli
 */
public enum Horarios {
    HORA_8("08:00AM"),
    HORA_10("10:00AM"),
    HORA_12("12:00PM"),
    HORA_14("14:00PM"),
    HORA_16("16:00PM"),
    HORA_18("18:00PM"),
    HORA_20("20:00PM"),
    HORA_22("22:00PM");

    private final String hora;

    Horarios(String hora) {
        this.hora = hora;
    }

    public String getHora() {
        return hora;
    }
}

