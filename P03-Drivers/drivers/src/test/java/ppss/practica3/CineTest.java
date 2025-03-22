package ppss.practica3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CineTest {

    int solicitados;
    boolean reservaEsperada, reservaReal;
    Cine cine;

    @Test
    void reservaButacasC1() {
        boolean[] asientos = {};
        int solicitados = 3;

        Cine cine = new Cine();
        assertThrows(ButacasException.class, () -> {
            cine.reservaButacas(asientos, solicitados);
        }, "No se puede procesar la solicitud");
    }

    @Test
    void reservaButacasC2() throws ButacasException {
        boolean[] asientos = {};
        solicitados = 0;

        reservaEsperada = false;
        boolean[] asientosEsperados = {};
        cine = new Cine();
        reservaReal = cine.reservaButacas(asientos, solicitados);

        assertAll("TestC2",
                () -> assertEquals(reservaEsperada, reservaReal),
                () -> assertArrayEquals(asientosEsperados, asientos)
        );
    }

    @Test
    void reservaButacasC3() throws ButacasException {
        boolean[] asientos = {false, false, false, true, true};
        solicitados = 2;

        reservaEsperada = true;
        boolean[] asientosEsperados = {true, true, false, true, true};
        cine = new Cine();
        reservaReal = cine.reservaButacas(asientos, solicitados);

        assertAll("TestC3",
                () -> assertEquals(reservaEsperada, reservaReal),
                () -> assertArrayEquals(asientosEsperados, asientos)
        );
    }

    @Test
    void reservaButacasC4() throws ButacasException {
        boolean[] asientos = {true, true, true};
        solicitados = 1;

        reservaEsperada = false;
        boolean[] asientosEsperados = {true, true, true};
        cine = new Cine();
        reservaReal = cine.reservaButacas(asientos, solicitados);

        assertAll("TestC4",
                () -> assertEquals(reservaEsperada, reservaReal),
                () -> assertArrayEquals(asientosEsperados, asientos)
        );
    }
}