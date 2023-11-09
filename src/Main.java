
/**
 *
 * @author Sebastian Espinosa
 */
import Entity.*;
import Logic.Cine;
import util.Utilidades;

import javax.swing.JOptionPane;

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
            String[] opciones = {"Agregar Sala", "Agregar Pelicula", "Agregar Película a Sala", "Mostrar Cartelera", "Vender Boleto", "Salir"};
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
                case -1: // Salir con la x de cerrar
                    control = false;
                    break;

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
                    String strdDia = JOptionPane.showInputDialog("Ingrese el numero del dia de la semana :\n" + Utilidades.obtenerDiasSemana());
                    if (strdDia != null) {
                        int dia = Integer.parseInt(strdDia);
                        String numSala = JOptionPane.showInputDialog("Ingrese el número de la sala que desea seleccionar:\n" + cine.listaDeSalas());

                        if (numSala != null) {

                            Sala sala = null;
                            for (Sala s : cine.getSalas()) {
                                if (s.getNumero().equals(numSala)) {
                                    sala = s;
                                    break;
                                }
                            }

                            if (sala != null) {
                                String numPelicula = JOptionPane.showInputDialog("Ingrese el número de la pelicula a la que desea agregar a la sala:\n" + cine.mostrarListaPeliculasPorSala(sala));

                                if (numPelicula != null) {
                                    Pelicula p = cine.obtenerPelicula(Integer.parseInt(numPelicula));

                                    boolean horaSi = true;
                                    int hora = 0;
                                    while (horaSi) {
                                        String strdHora = JOptionPane.showInputDialog("Ingrese el numero del horario de la película:\n" + Utilidades.obtenerHorariosDisponibles(cine, sala, dia));
                                        if (strdHora != null) {
                                            hora = Integer.parseInt(strdHora);
                                            horaSi = cine.validarDisponibilidad(hora, sala, dia);
                                        } else {
                                            break;
                                        }
                                    }

                                    if (hora != 0) {
                                        Horario h = new Horario(hora, dia);
                                        Cartelera c = new Cartelera(h, sala, p);
                                        cine.addCartelera(c);
                                        JOptionPane.showMessageDialog(null, "Pelicula agregada exitosamente a la sala!");
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Número de sala no encontrado.");
                            }
                        }
                    }

                    break;

                case 3: // Mostrar Salas
                    cine.mostrarCartelera();
                    break;

                case 4: // Vender Boleto
                    String codDia = JOptionPane.showInputDialog("Seleccione el dia de la funcion :\n" + Utilidades.obtenerDiasSemana());
                    if (codDia != null) {

                        int dia = Integer.parseInt(codDia);
                        Cartelera cartelera = cine.mostrarPeliculasDisponibles(dia);
                        
                    }

                    break;

                case 5: // Salir
                    control = false;
                    return;
            }
        }
    }
}
