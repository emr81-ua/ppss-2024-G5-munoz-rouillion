package ppss.practica3;


public class Cine {
    public boolean reservaButacas(boolean[] asientos, int solicitados) throws ButacasException {
        if (solicitados <= 0) {
            return false; // No se pueden reservar 0 butacas
        }

        if (asientos.length < solicitados) {
            throw new ButacasException("No se puede procesar la solicitud");
        }

        boolean reserva = false;
        int j = 0;
        int sitiosLibres = 0;
        int primerLibre = -1; // Se inicializa correctamente

        while (j < asientos.length && sitiosLibres < solicitados) {
            if (!asientos[j]) {
                if (sitiosLibres == 0) {
                    primerLibre = j; // Guardamos la posición inicial de la reserva
                }
                sitiosLibres++;
            } else {
                sitiosLibres = 0;
                primerLibre = -1; // Reseteamos la posición inicial
            }
            j++;
        }

        if (sitiosLibres == solicitados) {
            reserva = true;
            for (int k = primerLibre; k < primerLibre + solicitados; k++) {
                asientos[k] = true; // Reservamos los asientos
            }
        }

        return reserva;
    }
}