package util;

import Entity.Cartelera;
import Entity.Sala;
import Logic.Cine;

public class Utilidades {

    public static String obtenerDiasSemana () {

        String dias = "Lunes - 1\n";
        dias += "Martes - 2\n";
        dias += "Miercoles - 3\n";
        dias += "Jueves - 4\n";
        dias += "Viernes - 5\n";
        dias += "Sabado - 6\n";
        dias += "Domingo - 7\n";

        return  dias;
    }

    public static String obtenerHorariosDisponibles (Cine cine, Sala sala, int dia) {

        boolean h1 = true;
        boolean h2 = true;
        boolean h3 = true;

        for (Cartelera c: cine.getCarteleras()) {
            if (dia == c.getHorario().getDia()) {
                if (c.getSala().getNumero().equals(sala.getNumero())) {
                    switch (c.getHorario().getCodigoHora()) {
                        case 1:
                            h1 = false;
                            break;
                        case 2:
                            h2 = false;
                            break;
                        case 3:
                            h3 = false;
                            break;
                    }
                }
            }
        }

        StringBuilder mensajeHora = new StringBuilder();
        if (h1 || h2 || h3) {
            if (h1) {
                mensajeHora.append("Horario 1: 14:00 hasta las 16:30\n");
            }
            if (h2) {
                mensajeHora.append("Horario 2: 16:30 hasta las 19:00\n");
            }
            if (h3) {
                mensajeHora.append("Horario 3: 19:00 hasta las 21:00\n");
            }
        } else {
            mensajeHora.append("No hay horarios disponibles para la sala # " + sala.getNumero());
        }

        return mensajeHora.toString();
    }

    public static String obtenerLetra(int i) {
        String letra = "";

        switch (i) {
            case 0:
                letra = "A";
                break;
            case 1:
                letra = "B";
                break;
            case 2:
                letra = "C";
                break;
            case 3:
                letra = "D";
                break;
            case 4:
                letra = "E";
                break;
            case 5:
                letra = "F";
                break;
            case 6:
                letra = "G";
                break;
            case 7:
                letra = "H";
                break;
            default:
                letra = "Valor no válido";
        }

        return letra;
    }

}
