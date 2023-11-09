package Entity;

public class Cartelera {

    private Horario horario;
    private Sala sala;
    private Pelicula pelicula;
    
    
    public Cartelera(Horario horario, Sala sala, Pelicula pelicula) {
        this.horario = horario;
        this.sala = sala;
        this.pelicula = pelicula;
    }

    public Horario getHorario() {
        return horario;
    }

    public Sala getSala() {
        return sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

       

}
