
/**
 *
 * @author Sebastian Espinosa
 */
import Entity.*;
import Logic.Cine;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {
    
    /*
    Icono: falta poner initComponents y setIconImage(getIconImage())
    public Image getIconImage () {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/CinemaLogo.png"));

        return retValue;
    }
    */


    public static void main(String[] args) {
        Cine cine = new Cine();

        boolean control = true;

        while (control) {
            String[] opciones = {"Agregar Sala", "Agregar Pelicula", "Agregar Película a Sala", "Mostrar Salas", "Vender Boleto", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción",
                    "CinemaStar Menú principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (seleccion) {
                case 0: // Agregar Sala
                    String numeroSala = JOptionPane.showInputDialog("Ingrese el numero de la sala (1, 2 o 3): ");
                    if (numeroSala == null) {
                        break;
                    }
                    int tipo = 0;
                    while (tipo < 1 || tipo > 2) {

                        String stTipo = JOptionPane.showInputDialog("Ingrese el tipo de sala: \n 1: 3D | 2: 35mm");
                        if (stTipo != null) {
                            tipo = Integer.parseInt(stTipo);
                        } else {
                            break;
                        }
                    }

                    Sala s1 = new Sala(new Tipo(tipo), numeroSala, new Silla[8][12]);
                    cine.getSalas().add(s1);
                    JOptionPane.showMessageDialog(null, "Sala agregada exitosamente!");
                    break;

                case 1: // Agregar Película
                    String titulo = JOptionPane.showInputDialog("Ingrese el título de la película:");
                    if (titulo == null) {
                        break;
                    }
                    
                    String idioma = JOptionPane.showInputDialog("Ingrese idioma de la película:");
                    if (idioma == null) {
                        break;
                    }
                    
                    int tipoPeli = 0;
                    while (tipoPeli < 1 || tipoPeli > 2) {
                        String stTipoPeli = JOptionPane.showInputDialog("Ingrese el tipo de pelicula: \n 1: 3D | 2: 35mm");
                        if (stTipoPeli != null) {
                            tipoPeli = Integer.parseInt(stTipoPeli);
                        } else {
                            break;
                        }
                    }
                    
                    int duracion = 0;
                    String stDuracion = JOptionPane.showInputDialog("Ingrese la duración de la película (en minutos):");
                    if (stDuracion == null) {
                        break;
                    }
                    duracion = Integer.parseInt(stDuracion);
                    
                    Pelicula p1 = new Pelicula(titulo, idioma, new Tipo(tipoPeli), duracion);
                    cine.getPeliculas().add(p1);
                    JOptionPane.showMessageDialog(null, "Pelicula agregada exitosamente!");
                    break;

                case 2: // Agregar Película a Sala
                    String numSala = JOptionPane.showInputDialog("Ingrese el número de la sala que desea seleccionar:");
                    Sala sala = null;
                    for (Sala s : cine.getSalas()) {
                        if (s.getNumero().equals(numSala)) {
                            sala = s;
                            break;
                        }
                    }

                    if (sala != null) {
                        String numPelicula = JOptionPane.showInputDialog(cine.mostrarListapeliculas() + "\n Ingrese el número de la pelicula a la que desea agregar a la sala:");
                        Pelicula p = cine.obtenerPelicula(Integer.parseInt(numPelicula));

                        StringBuilder mensajeHora = new StringBuilder();
                        mensajeHora.append("Horario 1: 14:00 hasta las 16:30\n");
                        mensajeHora.append("Horario 2: 16:30 hasta las 19:00\n");
                        mensajeHora.append("Horario 3: 19:00 hasta las 21:00\n");

                        String hora = JOptionPane.showInputDialog("Ingrese el numero del horario de la película:\n" + mensajeHora.toString());
                        int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero del dia de la semana :"));
                        Horario h = new Horario(hora, dia);
                        Cartelera c = new Cartelera(h, sala, p);

                        cine.addCartelera(c);

                        JOptionPane.showMessageDialog(null, "Pelicula agregada exitosamente a la sala!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Número de sala no encontrado.");
                    }
                    break;

                case 3: // Mostrar Salas
                    cine.mostrarCartelera();
//                    StringBuilder infoSalas = new StringBuilder("Salas en " + cine.getNombre() + ":\n\n");
//                    for (Sala s : salas) {
//                        infoSalas.append(s.toString()).append("\n");
//                    }
//                    JOptionPane.showMessageDialog(null, infoSalas.toString());
                    break;

                case 4: // Vender Boleto
//                    int salaParaBoleto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nÃºmero de la sala para vender un boleto:"));
//                    Sala salaSeleccionada = null;
//                    for (Sala s : salas) {
//                        if (s.getNumeroSala() == salaParaBoleto) {
//                            salaSeleccionada = s;
//                            break;
//                        }
//                    }
//                    if (salaSeleccionada != null) {
//                        int asientoElegido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nÃºmero de asiento que desea:"));
//                        if (salaSeleccionada.verificarAsientoDisponible(asientoElegido)) {
//                            salaSeleccionada.ocuparAsiento(asientoElegido);
//                            Boleto boleto = new Boleto(salaSeleccionada.getPelicula(), salaSeleccionada, asientoElegido);
//                            JOptionPane.showMessageDialog(null, "Boleto vendido exitosamente!\n" + boleto.toString());
//                        } else {
//                            JOptionPane.showMessageDialog(null, "El asiento elegido ya estÃ¡ ocupado o no es vÃ¡lido.");
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "NÃºmero de sala no encontrado.");
//                    }
                    break;

                case 5: // Salir
                    control = false;
                    return;
            }
        }
    }
}
