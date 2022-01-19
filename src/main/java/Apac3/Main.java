package Apac3;

import Model.*;
import Utilitats.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author ionut
 */
public class Main {

    public static Session laSessio;

    public static void main(String[] args) {
        opciones();
    }

    public static void opciones() {
        String opcion = "";

        do {
            opcion = Leer.leerTexto("DDBB Management> ");
            if (opcion.equals("quit") || opcion.equals("salir")) {
                System.out.println("Usted ha elegido la opcion de salir");
                break;
            }

            String[] orden = opcion.split(" ");
            switch (orden[0]) {
                case "show":
                    //comprobamos si hay "-c" en el comando introducido

                    if (!orden[1].equals("-c")) {//en caso de que no haya "-c" entra
                        switch (orden[1]) {
                            case "ciclista":
                                laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
                                laSessio.beginTransaction();

                                Query c = laSessio.createQuery("from ciclistes");
                                //Recuperamos todos los ciclistas
                                List<Ciclista> elsciclistes = c.list();

                                for (Ciclista ciclista : elsciclistes) {
                                    System.out.println(ciclista);
                                }
                                laSessio.getTransaction().commit();
                                break;
                            case "etapa":
                                laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
                                laSessio.beginTransaction();

                                Query e = laSessio.createQuery("from etapes");
                                //Recuperamos todas las estapas
                                List<Etapa> etapes = e.list();

                                for (Etapa etapa : etapes) {
                                    System.out.println(e);
                                }
                                laSessio.getTransaction().commit();

                                break;
                            case "mallot":
                                laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
                                laSessio.beginTransaction();

                                Query m = laSessio.createQuery("from mallots");
                                //Recuperamos todos los mallots
                                List<Mallot> elsmallos = m.list();

                                for (Mallot mallot : elsmallos) {
                                    System.out.println(mallot);
                                }
                                laSessio.getTransaction().commit();

                                break;
                            default:
                                System.out.println("La tabla introducida no es corecta");

                        }
                    } else {//en caso de que exista un "-c" entra por aqui
                        switch (orden[2]) {
                            case "ciclista":

                                break;
                            case "etapa":

                                break;
                            case "mallot":

                                break;
                            default:
                                System.out.println("La tabla introducida no es corecta");

                        }

                    }
                    break;
                //añadimos datos nuevos a un tabla
                case "add":
                    switch (orden[1]) {
                        case "ciclista":

                            break;
                        case "etapa":

                            break;
                        case "mallot":

                            break;
                        default:
                            System.out.println("La tabla introducida no es corecta");

                    }
                    break;
                //actualizamos los datos de la tabla
                case "update":
                    switch (orden[1]) {
                        case "ciclista":

                            break;
                        case "etapa":

                            break;
                        case "mallot":

                            break;
                        default:
                            System.out.println("La tabla introducida no es corecta");

                    }
                    break;
                //borramamos unos datos de una tabla
                case "delete":
                    switch (orden[1]) {
                        case "ciclista":

                            break;
                        case "etapa":

                            break;
                        case "mallot":

                            break;
                        default:
                            System.out.println("La tabla introducida no es corecta");

                    }
                    break;
                //limpiamos la terminal segun el sistema que estamos,
                //en caso de que estemos en la Terminal de NetBeans tambien la limpiara
                case "clear":
                    ClearConsole();
                    break;
                //imprimimos por pantalla la ayuda actual CYAN_BACKROUND = "\033[43m" GREEN_BOLD = "\033[1;32m"; 
                case "help":
                    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "-------------------------------------------------------------------------"
                            + ConsoleColors.GREEN_BOLD_BRIGHT);
                    System.out.println("-----                         APAC 3. Ayuda basica                  -----\n");
                    System.out.println("En este programa estamos haciendo el mantenimiento de una base de datos.\n");
                    System.out.println("Las opciones que tiene para elegir son las siguientes : \n");
                    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + String.format(" %-20s %-15s",
                            "Orden",
                            "Descripción"
                    ) + ConsoleColors.GREEN_BOLD_BRIGHT);
                    System.out.println(String.format(" %-20s %-15s",
                            "-----",
                            "---------------------------------------------"
                    ));
                    ordenes("src/main/java/Utilitats/ordenes.txt");
                    System.out.println("\nLas tablas sobre las cuales se puede hacer mantenimiento son : ");
                    System.out.println("\tCiclista\n\tEtapa\n\tMallot");
                    System.out.println("-------------------------------------------------------------------------" + ConsoleColors.RESET);
                    break;
                default:
                    System.out.println("Opcion desconocida.Teclee <help> para mas ayuda");

            }
        } while (opcion != null);

    }

    //Funcion que lee ordenes existentes y su informacion desde un fichero txt
    public static void ordenes(String file) {
        File f = new File(file);
        String[] ordenes = null;

        if (f.exists()) {
            FileReader fr = null;
            BufferedReader bfr = null;
            try {

                fr = new FileReader(f);
                bfr = new BufferedReader(fr);

                while (bfr.ready()) {
                    String linea = bfr.readLine();
                    ordenes = linea.split("=");
                    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + String.format(" %-20s %-20s",
                            ordenes[0],
                            ordenes[1]
                    ) + ConsoleColors.GREEN_BOLD_BRIGHT);

                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fr.close();
                    bfr.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    //Funcion que se encarga de Limpiar la Consola segun el sistema que estamos Windows,Mac,Linux
    public static void ClearConsole() {
        //comprobamos que sistema operativo tenemos instalado
        String OP = System.getProperty("os.name");

        try {
            if (OP.contains("Windows")) {
                new ProcessBuilder("cmd", "/C", "cls").inheritIO().start().waitFor();

            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();

            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        LimpiarAnt();

    }

    //Funcion que se encarga de presionar las teclas Ctrl y L para borrar la terminal de Netbeans
    public static void LimpiarAnt() {
        try {
            Robot pb = new Robot();
            pb.keyPress(KeyEvent.VK_CONTROL);
            pb.keyPress(KeyEvent.VK_L);
            pb.keyRelease(KeyEvent.VK_CONTROL);
            pb.keyRelease(KeyEvent.VK_L);

        } catch (AWTException ex) {

        }

    }

    public static void guardarElement(Object o) {
        Session laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();
        laSessio.save(o);

        laSessio.getTransaction().commit();
    }

    public static void actualizarElement(Object o) {
        Session laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();
        laSessio.update(o);

        laSessio.getTransaction().commit();
    }

    public static void borrarElement(Object o) {
        Session laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();
        laSessio.delete(o);

        laSessio.getTransaction().commit();
    }
}
