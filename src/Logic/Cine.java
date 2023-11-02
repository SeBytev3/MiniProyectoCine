
package Logic;

import Entity.Pelicula;
import Entity.Sala;
import Entity.Silla;
import Entity.Tipo;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Espinosa
 */
public class Cine {
    
    private ArrayList<Sala> salas;
    private ArrayList<Pelicula> peliculas;

    public Cine() {
        
        crearPeliculas();
        crearSalas();
        
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
    
    

}
