
/**
 *
 * @author Sebastian Espinosa
 */
import Entity.Pelicula;
import Entity.Sala;
import Entity.Silla;
import Entity.Tipo;
import Logic.Cine;
import javax.swing.JOptionPane;
import java.util.ArrayList;

 

public class Main {


    public static void main(String[] args) {
        Cine cine = new Cine();
 
        boolean control = true;
        
        while (control) {
            String[] opciones = {"Agregar Sala", "Agregar Pelicula", "Agregar Pelí­cula a Sala", "Mostrar Salas", "Vender Boleto", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción",
                    "Menú principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

 

            switch (seleccion) {
                case 0: // Agregar Sala
                    String numeroSala = JOptionPane.showInputDialog("Ingrese el número de la sala: ");
                    int tipo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la sala: "));
                    Sala s1 = new Sala(new Tipo(tipo), numeroSala, new Silla[8][12]);
                    cine.getSalas().add(s1);
                    JOptionPane.showMessageDialog(null, "Sala agregada exitosamente!");
                    break;

 

                case 1: // Agregar Pelí­cula
                    String titulo = JOptionPane.showInputDialog("Ingrese el tí­tulo de la pelí­cula:");
                    String idioma = JOptionPane.showInputDialog("Ingrese idioma de la pelí­cula:");
                    int tipoPelicula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de película:"));
                    int duracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duración de la pelí­cula (en minutos):"));
                    Pelicula p1 = new Pelicula(titulo, idioma, new Tipo(tipoPelicula), duracion);
                    cine.getPeliculas().add(p1);
                    break;
                    
                    
                case 2: // Agregar Pelí­cula a Sala
                    String numSala = JOptionPane.showInputDialog("Ingrese el número de la sala a la que desea agregar la pelí­cula:");
                    boolean salaEncontrada = false;
                    for (Sala s : cine.getSalas()) {
                        if (s.getNumero().equals(numSala)) {
                            s.setPelicula(peliculas);
                            salaEncontrada = true;
                            JOptionPane.showMessageDialog(null, "Pelicula agregada exitosamente a la sala!");
                            break;
                        }
                    }
                    if (!salaEncontrada) {
                        JOptionPane.showMessageDialog(null, "NÃºmero de sala no encontrado.");
                    }
                    break;

 

                case 3: // Mostrar Salas
                    StringBuilder infoSalas = new StringBuilder("Salas en " + cine.getNombre() + ":\n\n");
                    for (Sala s : salas) {
                        infoSalas.append(s.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, infoSalas.toString());
                    break;

 

                case 4: // Vender Boleto
                    int salaParaBoleto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nÃºmero de la sala para vender un boleto:"));
                    Sala salaSeleccionada = null;
                    for (Sala s : salas) {
                        if (s.getNumeroSala() == salaParaBoleto) {
                            salaSeleccionada = s;
                            break;
                        }
                    }
                    if (salaSeleccionada != null) {
                        int asientoElegido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nÃºmero de asiento que desea:"));
                        if (salaSeleccionada.verificarAsientoDisponible(asientoElegido)) {
                            salaSeleccionada.ocuparAsiento(asientoElegido);
                            Boleto boleto = new Boleto(salaSeleccionada.getPelicula(), salaSeleccionada, asientoElegido);
                            JOptionPane.showMessageDialog(null, "Boleto vendido exitosamente!\n" + boleto.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "El asiento elegido ya estÃ¡ ocupado o no es vÃ¡lido.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "NÃºmero de sala no encontrado.");
                    }
                    break;

 

                case 5: // Salir
                    return;
            }
        }
    }
}
