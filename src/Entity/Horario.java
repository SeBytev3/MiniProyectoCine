package Entity;

public class Horario {

    private int codigoHora;
    private String hora;
    private int dia;
    private String nombreDia;
    
    public Horario(int codigoHora, int dia) {
        this.codigoHora = codigoHora;
        this.dia = dia;

        switch (codigoHora) {
            case 1:
                hora = "14:00 hasta las 16:30";
                break;
            case 2:
                hora = "16:30 hasta las 19:00";
                break;
            case 3:
                hora = "19:00 hasta las 21:00";
                break;
        }

        switch (dia) {
            case 1:
                nombreDia = "Lunes";
                break;
            case 2:
                nombreDia = "Martes";
                break;
            case 3:
                nombreDia = "Miercoles";
                break;
            case 4:
                nombreDia = "Jueves";
                break;
            case 5:
                nombreDia = "Viernes";
                break;
            case 6:
                nombreDia = "Sabado";
                break;
            case 7:
                nombreDia = "Domingo";
                break;
        }
    }

    public int getCodigoHora() {
        return codigoHora;
    }

    public void setCodigoHora(int codigoHora) {
        this.codigoHora = codigoHora;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }
}
