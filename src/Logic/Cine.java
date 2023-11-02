
package Logic;

import Entity.*;

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

    public String mostrarListapeliculas(){
        String cadena = "";
        for (int i = 0; i < peliculas.size(); i++) {
            Pelicula p = peliculas.get(i);
            cadena += i + " - " + p.getNombre() + ", ";
        }
        return cadena;
    }

    public void addCartelera(Cartelera c){
        carteleras.add(c);
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

                int hora1 = Integer.parseInt(carteleras.get(i).getHorario().getHora());

                for (int j = i; j < carteleras.size(); j++) {
                    if (dia == carteleras.get(j).getHorario().getDia()) {

                        int hora2 = Integer.parseInt(carteleras.get(j).getHorario().getHora());
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

    public void mostrarCartelera(){
        ordenarCarteleraPorDia();
        for (int i = 1; i <= 7; i++) {
            ordenarHorarioPorDia(i);
        }

        StringBuilder mensaje = new StringBuilder();
        for (Cartelera c: carteleras) {

            mensaje.append(c.getHorario().getDia() + "\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());

    }

    public Pelicula obtenerPelicula(int indice){
        return peliculas.get(indice);
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
