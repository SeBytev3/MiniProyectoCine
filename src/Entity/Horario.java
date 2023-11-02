package Entity;

public class Horario {
    
    
    private String hora;
    
    private int dia;
    
    
    public Horario(String hora, int dia) {
        this.hora = hora;
        this.dia = dia;
    }
    

    public String getHora() {
        return hora;
    }

    public int getDia() {
        return dia;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    
}
