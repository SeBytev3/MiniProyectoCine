package Entity;

public class Sala {

    private Tipo tipo;
    private String numero;
    private Silla[][] sillas;
    
    public Sala(Tipo tipo, String numero, Silla[][] sillas) {
        this.tipo = tipo;
        this.numero = numero;
        this.sillas = sillas;
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
