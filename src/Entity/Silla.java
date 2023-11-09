package Entity;

public class Silla {

    private String numero;
    private String letra;
    private long valor;
    private Tipo tipo;
    private boolean disponibilidad;

    public Silla() {
    }

    public Silla(String numero, String letra, long valor, Tipo tipo, boolean disponibilidad) {
        this.numero = numero;
        this.letra = letra;
        this.valor = valor;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
    }

    public String getNumero() {
        return numero;
    }

    public String getLetra() {
        return letra;
    }

    public long getValor() {
        return valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
}
