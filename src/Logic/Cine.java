
package Logic;

import Entity.*;
import util.Utilidades;

import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Espinosa
 */
public class Cine {
    
    private ArrayList<Sala> salas;
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Cartelera> carteleras;

    public Cine() {
        crearPeliculas();
        crearSalas();
        carteleras =  new ArrayList<>();
    }
    
    public void crearPeliculas() {
        Pelicula p1 = new Pelicula("El señor de los anillos", "español", new Tipo(2), 178);
        Pelicula p2 = new Pelicula("El Padrino", "español", new Tipo(2), 175);
        Pelicula p3 = new Pelicula("Avatar", "español", new Tipo(1), 162);
        peliculas = new ArrayList<>();
        peliculas.add(p1);
        peliculas.add(p2);
        peliculas.add(p3);
    }
    
    public void crearSalas() {
        Sala s1 = new Sala(new Tipo(2), "1", new Silla[8][12]);
        Sala s2 = new Sala(new Tipo(2), "2", new Silla[8][12]);
        Sala s3 = new Sala(new Tipo(1), "3", new Silla[8][12]);
        salas = new ArrayList<>();
        salas.add(s1);
        salas.add(s2);
        salas.add(s3);
    }

    public String mostrarListaPeliculasPorSala(Sala sala){
        String cadena = "";
        for (int i = 0; i < peliculas.size(); i++) {
            Pelicula p = peliculas.get(i);
            if (sala.getTipo().getCodigo() == p.getTipo().getCodigo()) {
                cadena += i + " - " + p.getNombre() + " " + p.getTipo().getTipo() + "\n";
            }
        }
        return cadena;
    }

    public void addCartelera(Cartelera c){
        c.getSala().setSillas(crearSilleteria(c.getSala().getTipo().getCodigo()));
        carteleras.add(c);
        ordenarCartelera();
    }

    public Silla[][] crearSilleteria(int tipoSala){
        Silla[][] sillas = new Silla[8][12];
        for (int i = 0; i < sillas.length; i++) {
            Silla silla = new Silla();
            silla.setDisponibilidad(true);
            Tipo tipoSilla = new Tipo();
            silla.setNumero(String.valueOf(i));
            if (tipoSala == 2) {
                if (i < 6) {
                    for (int j = 0; j < sillas[i].length; j++) {
                            silla.setLetra(Utilidades.obtenerLetra(i));
                            tipoSilla = new Tipo(3);
                            silla.setTipo(tipoSilla);
                            silla.setValor(6000);
                    }
                } else if (i > 5) {
                    for (int j = 0; j < 9; j++) {
                        silla.setLetra(Utilidades.obtenerLetra(i));
                        tipoSilla = new Tipo(4);
                        silla.setTipo(tipoSilla);
                        silla.setValor(12000);
                    }
                }
            } else if (tipoSala == 2) {
                if (i < 6) {
                    for (int j = 0; j < sillas[i].length; j++) {
                        silla.setLetra(Utilidades.obtenerLetra(i));
                        tipoSilla = new Tipo(3);
                        silla.setTipo(tipoSilla);
                        silla.setValor(10000);
                    }
                }
            }
        }
        return sillas;
    }

    public void ordenarCarteleraPorDia(){
        for (int i = 0; i < carteleras.size(); i++) {
            int dia1 = carteleras.get(i).getHorario().getDia();
            for (int j = i; j < carteleras.size(); j++) {
                int dia2 = carteleras.get(j).getHorario().getDia();
                if(dia1 > dia2){
                    Cartelera temp = carteleras.get(i);
                    carteleras.set(i, carteleras.get(j));
                    carteleras.set(j, temp);
                }
            }
        }
    }

    public void ordenarHorarioPorDia(int dia){
        for (int i = 0; i < carteleras.size(); i++) {
            if (dia == carteleras.get(i).getHorario().getDia()) {

                int hora1 = carteleras.get(i).getHorario().getCodigoHora();

                for (int j = i; j < carteleras.size(); j++) {
                    if (dia == carteleras.get(j).getHorario().getDia()) {

                        int hora2 = carteleras.get(j).getHorario().getCodigoHora();
                        if (hora1 > hora2) {
                            Cartelera temp = carteleras.get(i);
                            carteleras.set(i, carteleras.get(j));
                            carteleras.set(j, temp);
                        }
                    }
                }
            }
        }
    }

    public void ordenarCartelera(){
        ordenarCarteleraPorDia();
        for (int i = 1; i <= 7; i++) {
            ordenarHorarioPorDia(i);
        }
    }

    public void mostrarCartelera(){
        StringBuilder mensaje = new StringBuilder();

        if (carteleras.size() > 0) {
            int codDia = 1;
            mensaje.append("Lunes\n");

            for (Cartelera c: carteleras) {
                if (codDia != c.getHorario().getDia()) {
                    mensaje.append(c.getHorario().getNombreDia() + "\n");
                    codDia = c.getHorario().getDia();
                }
                mensaje.append("- " + c.getPelicula().getNombre() + " " + c.getPelicula().getTipo().getTipo());
                mensaje.append("\n    " + c.getHorario().getHora() + " - Sala # " + c.getSala().getNumero()  +"\n");

            }
        } else {
            mensaje.append("No hay cartelera programada");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    public String listaDeSalas(){
        String ListaSalas = "";
        for (Sala sala: this.salas) {
            ListaSalas += "Sala # " + sala.getNumero() + " tipo " + sala.getTipo().getTipo() + "\n";
        }
        return ListaSalas;
    }

    public Pelicula obtenerPelicula(int indice){
        return peliculas.get(indice);
    }

    public boolean validarDisponibilidad(int hora, Sala sala, int dia) {
        boolean disponible = false;

        for (Cartelera c: carteleras) {
            if (dia == c.getHorario().getDia()) {
                if (c.getSala().getNumero().equals(sala.getNumero())) {
                    if (c.getHorario().getCodigoHora() == hora) {
                        disponible = true;
                        break;
                    }
                }
            }
        }

        return disponible;
    }

    public Cartelera mostrarPeliculasDisponibles(int dia){
        ArrayList<Cartelera> peliculasDiponibles = new ArrayList<>();
        String cadena = "";
        boolean siHayFunciones = false;
        Cartelera funcion = null;
        if (carteleras.size() > 0) {

            for (Cartelera cartelera: carteleras) {
                if (cartelera.getHorario().getDia() == dia) {
                    if (peliculasDiponibles.size() > 0) {
                        for (Cartelera pelicula: peliculasDiponibles) {
                            if (!cartelera.getPelicula().getNombre().equals(cartelera.getPelicula().getNombre())) {
                                peliculasDiponibles.add(cartelera);
                            }
                        }
                    } else {
                        peliculasDiponibles.add(cartelera);
                    }
                }
            }

            for (int i = 0; i < peliculasDiponibles.size(); i++) {
                Cartelera p = peliculasDiponibles.get(i);
                cadena += i + " - " + p.getPelicula().getNombre() + " " + p.getPelicula().getTipo().getTipo() + "\n";
            }

            siHayFunciones = true;
        }

        if (siHayFunciones) {
            String codPelicula = JOptionPane.showInputDialog(cadena);

            if (codPelicula != null) {
                funcion = carteleras.get(Integer.parseInt(codPelicula));
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay cartelera programada");
        }

        return funcion;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public ArrayList<Cartelera> getCarteleras() {
        return carteleras;
    }

    public void setCarteleras(ArrayList<Cartelera> carteleras) {
        this.carteleras = carteleras;
    }
}
