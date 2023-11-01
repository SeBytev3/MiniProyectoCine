package Entity;

public class Pelicula {
    
    
    private String nombre;
    
    private String idioma;
    
    private Tipo tipo;
    
    private long duracion;

    public String getNombre() {
        return nombre;
    }

    public String getIdioma() {
        return idioma;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    public Pelicula(String nombre, String idioma, Tipo tipo, long duracion) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.tipo = tipo;
        this.duracion = duracion;
    }
    
    

}
