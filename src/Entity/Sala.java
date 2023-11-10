package Entity;

import util.Utilidades;

public class Sala {

    private Tipo tipo;
    private String numero;
    private Silla[][] sillas;
    
    public Sala(Tipo tipo, String numero, Silla[][] sillas) {
        this.tipo = tipo;
        this.numero = numero;
        this.sillas = sillas;
    }

    public String obtenerSilleteriaComoTexto() {
        StringBuilder silleteriaTexto = new StringBuilder();
        silleteriaTexto.append("     1     2     3     4     5     6     7     8     9     10    11    12\n");

        for (int i = 0; i < sillas.length; i++) {
            silleteriaTexto.append(Utilidades.obtenerLetra(i)).append("   ");
            for (int j = 0; j < sillas[i].length; j++) {
                Silla silla = sillas[i][j];
                if (silla != null) {
                    if (silla.isDisponibilidad()) {
                        silleteriaTexto.append("[_]   ");
                    } else {
                        silleteriaTexto.append("[x]   ");
                    }
                } else {
                    silleteriaTexto.append("     "); // Espacio en blanco para sillas nulas
                }
            }
            silleteriaTexto.append("\n"); // Salto de línea para la siguiente fila
        }

        return silleteriaTexto.toString();
    }


    public Tipo getTipo() {
        return tipo;
    }

    public String getNumero() {
        return numero;
    }

    public Silla[][] getSillas() {
        return sillas;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setSillas(Silla[][] sillas) {
        this.sillas = sillas;
    }

    
}
