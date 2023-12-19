package Codigo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecorridosTest {

    @Test
    void bucarRecorrido() {
        // Prueba para encontrar un recorrido existente
        Recorridos recorridoExistente = Recorridos.bucarRecorrido(Ciudades.CONCEPCION, Ciudades.SANTIAGO);
        assertNotNull(recorridoExistente);
        assertEquals(Ciudades.CONCEPCION, recorridoExistente.getCiudadOrigen());
        assertEquals(Ciudades.SANTIAGO, recorridoExistente.getCiudadDestino());

        // Prueba para un recorrido inexistente
        Recorridos recorridoInexistente = Recorridos.bucarRecorrido(Ciudades.CHILLAN, Ciudades.CHILLAN);
        assertNull(recorridoInexistente, "El recorrido buscado no debería existir");
    }

    @Test
    void getBuses() {
        // Verificar que se devuelva un array de buses no nulo
        Recorridos recorrido = Recorridos.CONCEPCION_A_SANTIAGO;
        assertNotNull(recorrido.getBuses());

        // Verificar la cantidad de buses para un recorrido conocido
        assertEquals(5, recorrido.getBuses().length);
    }
}