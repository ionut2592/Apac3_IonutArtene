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
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.LogManager;
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
        disableLogging();
        añadir_etapas();
        opciones();
    }

    public static void opciones() {
        String opcion = "";

        do {
            opcion = Leer.leerTexto(ConsoleColors.PURPLE + "DDBB Management> " + ConsoleColors.RESET);
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
                                show_ciclista("");
                                break;
                            case "etapa":
                                show_etapa("");
                                break;
                            case "mallot":
                                show_mallot();
                                break;
                            default:
                                System.out.println(ConsoleColors.RED + "La tabla introducida no es corecta" + ConsoleColors.RESET);
                                break;

                        }
                    } else {//en caso de que exista un "-c" entra por aqui
                        switch (orden[2]) {
                            case "ciclista":
                                show_ciclista("-c");

                                break;
                            case "etapa":
                                show_etapa("-c");

                                break;
                            case "mallot":
                                System.out.println(ConsoleColors.RED + "Esta tabla no tiene la opcion \"-c\" ." + ConsoleColors.RESET);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED + "La tabla introducida no es corecta" + ConsoleColors.RESET);
                                break;

                        }

                    }
                    break;
                //añadimos datos nuevos a un tabla
                case "add":
                    switch (orden[1]) {
                        case "ciclista":
                            add_ciclista("");

                            break;
                        case "etapa":
                            add_etapa("");
                            break;
                        case "mallot":
                            add_mallot();
                            break;
                        default:
                            System.out.println(ConsoleColors.RED + "La tabla introducida no es corecta" + ConsoleColors.RESET);
                            break;

                    }
                    break;
                //actualizamos los datos de la tabla
                case "update":
                    switch (orden[1]) {
                        case "ciclista":
                            actualizar_ciclista();

                            break;
                        case "etapa":
                            actualizar_etapa();

                            break;
                        case "mallot":
                            actualizar_mallot();

                            break;
                        default:
                            System.out.println(ConsoleColors.RED + "La tabla introducida no es corecta" + ConsoleColors.RESET);

                    }
                    break;
                //borramamos unos datos de una tabla
                case "delete":
                    switch (orden[1]) {
                        case "ciclista":
                            delete_ciclista();

                            break;
                        case "etapa":
                            delete_etapa();

                            break;
                        case "mallot":
                            delete_mallot();

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
                    break;

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
        laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();
        laSessio.save(o);

        laSessio.getTransaction().commit();
    }

    public static void actualizarElement(Object o) {
        laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();
        laSessio.update(o);

        laSessio.getTransaction().commit();
    }

    public static void borrarElement(Object o) {
        laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();
        laSessio.delete(o);

        laSessio.getTransaction().commit();
    }

    public static void show_ciclista(String n) {
        laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();

        Query c = laSessio.createQuery("from ciclistes");
        c.setMaxResults(20);
        c.setFirstResult(0);
        //Recuperamos todos los ciclistas
        List<Ciclista> elsciclistes = c.list();
        System.out.println(String.format("%-15s %-30s %-15s",
                "Dorsal",
                "Nombre",
                "Edad"
        ));

        for (Ciclista ciclista : elsciclistes) {
            System.out.println(String.format("%-15s %-30s %-15s ",
                    ciclista.getDorsal(),
                    ciclista.getNom(),
                    ciclista.getEdat()
            ));
            if (n.equals("-c")) {
                Set<Portar> losMallots = ciclista.getElsmallots();
                int i = 0;

                for (Portar m : losMallots) {
                    if (i == 0 && !m.getMallot().getCodi().isEmpty()) {
                        System.out.println(String.format("%-15s %-15s ",
                                "\tMallot",
                                "\tEtapa"
                        ));
                    }

                    System.out.println(String.format("%-15s %-15s ",
                            "\t" + m.getMallot().getCodi(),
                            "\t" + m.getEtapa().getNumero()
                    ));
                    i++;

                }
            }

        }
        laSessio.getTransaction().commit();

    }

    public static void show_etapa(String n) {
        laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();

        Query e = laSessio.createQuery("from etapes");
        e.setMaxResults(20);
        e.setFirstResult(0);
        //Recuperamos todas las estapas
        List<Etapa> etapes = e.list();
        System.out.println(String.format("%-15s %-15s %-30s %-15s",
                "Numero",
                "Kms",
                "Salida",
                "Llegada"
        ));

        for (Etapa etapa : etapes) {
            System.out.println(String.format("%-15s %-15s %-30s %-15s ",
                    etapa.getNumero(),
                    etapa.getKms(),
                    etapa.getEixida(),
                    etapa.getArribada()
            ));
            if (n.equals("-c")) {
                System.out.println(String.format("%-15s %-30s %-15s",
                        "\tDorsal",
                        "Nombre",
                        "Edad"
                ));
                Ciclista c = etapa.getElciclista_ganador();
                System.out.println(String.format("%-15s %-30s %-15s ",
                        "\t" + c.getDorsal(),
                        c.getNom(),
                        c.getEdat()
                ));

            }
        }
        laSessio.getTransaction().commit();

    }

    public static void show_mallot() {
        laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();

        Query m = laSessio.createQuery("from mallots");
        m.setMaxResults(20);
        m.setFirstResult(0);
        //Recuperamos todos los mallots
        List<Mallot> elsmallos = m.list();
        System.out.println(String.format("%-15s %-20s %-20s %-15s",
                "Codigo",
                "Tipo",
                "Color",
                "Premi"
        ));

        for (Mallot mallot : elsmallos) {
            System.out.println(String.format("%-15s %-20s %-20s %-15s",
                    mallot.getCodi(),
                    mallot.getTipus(),
                    mallot.getColor(),
                    mallot.getPremi()
            ));
        }
        laSessio.getTransaction().commit();

    }

    public static void actualizar_ciclista() {
        show_ciclista("");
        int n_ciclcista = Leer.leerEntero(ConsoleColors.BLUE + "Elige uno de los anteriores ciclista para actualizar : " + ConsoleColors.RESET);
        Ciclista c = get_ciclista(Long.valueOf(n_ciclcista));

        System.out.println(ConsoleColors.BLUE + "Actualizando ciclista: Vamos a actualizar sus datos . Intro para no modificar y escribir nuevos datos en caso de que sean incorrectos " + ConsoleColors.RESET);
        String nom = Leer.leerTexto(ConsoleColors.BLUE + "Actualizando ciclista :Quieres cambiar el nombre del ciclista : \" nombre <-> " + c.getNom() + "\" :" + ConsoleColors.RESET);
        c.setNom(nom.isBlank() ? c.getNom() : nom);
        int edat = Leer.leerEntero(ConsoleColors.BLUE + "Actualizando ciclista :Quieres cambiar la edad del ciclista :\" edad <-> " + c.getEdat() + "\" :" + ConsoleColors.RESET);
        c.setEdat(edat == 0 ? c.getEdat() : edat);

        actualizarElement(c);

    }

    public static void actualizar_etapa() {
        show_etapa("");

        int n_etapa = Leer.leerEntero(ConsoleColors.BLUE + "Elige una de los anteriores etapas para actualizar : ");
        Etapa e = get_etapa(Long.valueOf(n_etapa));
        System.out.println(ConsoleColors.BLUE + "Actualizando etapa: Vamos a actualizar sus datos . Intro para no modificar y escribir nuevos datos en caso de que querer modificarlos " + ConsoleColors.RESET);

        int kms = Leer.leerEntero(ConsoleColors.BLUE + "Actualizando etapa : Quieres cambiar los kms de la etapa : \"kms<->" + e.getKms() + "\" :" + ConsoleColors.RESET);
        e.setKms(kms == 0 ? e.getKms() : kms);
        String salida = Leer.leerTexto(ConsoleColors.BLUE + "Actualizando etapa : Quieres cambiar la salida de la etapa : \" salida <-> " + e.getEixida() + "\" :" + ConsoleColors.RESET);
        e.setEixida(salida.isBlank() ? e.getEixida() : salida);
        String llegada = Leer.leerTexto(ConsoleColors.BLUE + "Actualizando etapa : Quieres cambiar la llegada de la etapa : \" llegada <-> " + e.getArribada() + "\" :" + ConsoleColors.RESET);
        e.setArribada(llegada.isBlank() ? e.getArribada() : llegada);
        String elec = Leer.leerTexto(ConsoleColors.BLUE + "Actualizando etapa : Quieres cambiar el ganador de la etapa(s/n) : \" ganador <-> " + e.getElciclista_ganador().getDorsal() + " " + e.getElciclista_ganador().getNom() + "\" :" + ConsoleColors.RESET);
        int id = 0;
        Ciclista c = null;
        if (elec.equals("s")) {
            show_ciclista("");
            id = Leer.leerEntero(ConsoleColors.BLUE + "Actualizando etapa : Elige un ganador de la etapa  :" + ConsoleColors.RESET);
            c = get_ciclista(Long.valueOf(id));
            e.setElciclista_ganador(c);

        }

        actualizarElement(e);

    }

    public static void actualizar_mallot() {
        show_mallot();
        String n_mallot = Leer.leerTexto(ConsoleColors.BLUE + "Elige uno de los anteriores mallots para actualizar : " + ConsoleColors.RESET);
        Mallot m = get_mallot(n_mallot);
        System.out.println(ConsoleColors.BLUE + "Actualizando mallot: Vamos a actualizar sus datos . Intro para no modificar y escribir nuevos datos en caso de que sean incorrectos " + ConsoleColors.RESET);

        String tipo = Leer.leerTexto(ConsoleColors.BLUE + "Actualizando mallot : Quiere cambiar el tipo del mallot : \"tipo <-> " + m.getTipus() + "\" :" + ConsoleColors.RESET);
        m.setTipus(tipo.isBlank() ? m.getTipus() : tipo);

        String color = Leer.leerTexto(ConsoleColors.BLUE + "Actualizando mallot : Quiere cambiar el color del mallot : \"color <-> " + m.getColor() + "\" :" + ConsoleColors.RESET);
        m.setColor(tipo.isBlank() ? m.getColor() : color);
        int premi = Leer.leerEntero(ConsoleColors.BLUE + "Actualizando mallot : Quiere cambiar el premio del mallot : \"prmeio <-> " + m.getPremi() + "\" :" + ConsoleColors.RESET);
        m.setPremi(premi == 0 ? m.getPremi() : premi);

        actualizarElement(m);

    }

    public static Ciclista add_ciclista(String var) {
        Ciclista c = null;
        Etapa e = null;

        String nom = Leer.leerTexto(ConsoleColors.BLUE + "Add ciclista :Introduce el nombre del ciclista " + ConsoleColors.RESET);
        int edat = Leer.leerEntero2(ConsoleColors.BLUE + "Add ciclista : Introduce la edad del ciclista :" + ConsoleColors.RESET);
        if (!var.equals("-1")) {
            String elec = Leer.leerTexto(ConsoleColors.BLUE + "Add ciclista : Quieres añadir las etapas que ha ganado(s/n)  :" + ConsoleColors.RESET);
            String numero = "";

            if (elec.equals("s")) {
                show_etapa("");
                numero = Leer.leerTexto(ConsoleColors.BLUE + "Add ciclista : Elige 1 o varias etapas (Si no existe inserte -1 para añadir una nueva) :" + ConsoleColors.RESET);
                if (numero != "-1") {
                    if (numero.contains(",")) {
                        String[] numero_split = numero.split(",");
                        for (String n : numero_split) {
                            e = get_etapa(Long.valueOf(n));
                            c = new Ciclista(nom, edat);
                            c.addEtapaGanada(e);
                        }
                    }

                } else {

                    e = add_etapa("-1");

                }

            }
        }
        c = new Ciclista(nom, edat);
        c.addEtapaGanada(e);

        return c;
    }

    public static Etapa add_etapa(String n) {
        Etapa e;
        int id = 0;
        Ciclista c = null;

        int kms = Leer.leerEntero2(ConsoleColors.BLUE + "Add etapa : Introduce los kms de la etapa  :" + ConsoleColors.RESET);
        String salida = Leer.leerTexto(ConsoleColors.BLUE + "Add etapa : Introduce la salida de la etapa :" + ConsoleColors.RESET);
        String llegada = Leer.leerTexto(ConsoleColors.BLUE + "Add etapa : Introduce la llegada de la etapa :" + ConsoleColors.RESET);
        if (!n.equals("-1")) {

            String elec = Leer.leerTexto(ConsoleColors.BLUE + "Add etapa : Quieres añadir un ganador a la etapa(s/n)  :" + ConsoleColors.RESET);

            if (elec.equals("s")) {
                show_ciclista("");
                id = Leer.leerEntero("Add etapa : Elige un ganador de la etapa (Si no existe inserte -1 para añadir uno nuevo) :" + ConsoleColors.RESET);
                if (id != -1) {
                    c = get_ciclista(Long.valueOf(id));
                } else {
                    c = add_ciclista("-1");
                }
            }
        }
        e = new Etapa(kms, salida, llegada);
        e.setElciclista_ganador(c);
        guardarElement(e);
        return e;
    }

    public static void add_mallot() {
        Mallot m;
        String codi = "";
        String tipo = "";
        String color = "";
        int premi = 0;
        while (codi.length() > 3 || codi.isBlank()) {
            codi = Leer.leerTexto(ConsoleColors.BLUE + "Add mallot : Indique el codigo del mallot(Maximo 3 caracteres):" + ConsoleColors.RESET);
        }
        while (tipo.isBlank()) {
            tipo = Leer.leerTexto(ConsoleColors.BLUE + "Add mallot : Indique el tipo del mallot (Ej:montanya,sprint,general) :" + ConsoleColors.RESET);
        }
        while (color.isBlank()) {
            color = Leer.leerTexto(ConsoleColors.BLUE + "Add mallot : Indique el color del mallot:" + ConsoleColors.RESET);
        }
        while (premi == 0) {
            premi = Leer.leerEntero(ConsoleColors.BLUE + "Add mallot : Indique el premio del mallot  :" + ConsoleColors.RESET);
        }
        m = new Mallot(codi, tipo, color, premi);
        guardarElement(m);

    }

    public static void delete_ciclista() {
        show_ciclista("");
        String n = Leer.leerTexto(ConsoleColors.RED + "Delete ciclista : Elige 1 o varios ciclistas (separados por coma)  :" + ConsoleColors.RESET);
        Ciclista c;
        if (n.contains(",")) {
            String[] n_split = n.split(",");
            for (String p : n_split) {

                c = get_ciclista(Long.valueOf(p));
                borrarElement(c);
            }

        } else {

            c = get_ciclista(Long.valueOf(n));
            borrarElement(c);

        }
    }

    public static void delete_etapa() {
        show_etapa("");
        String n = Leer.leerTexto(ConsoleColors.RED + "Delete etapa : Elige 1 o varias etapas (separadas por coma)  :" + ConsoleColors.RESET);
        Etapa e;
        if (n.contains(",")) {
            String[] n_split = n.split(",");
            for (String p : n_split) {

                e = get_etapa(Long.valueOf(p));
                borrarElement(e);
            }

        } else {

            e = get_etapa(Long.valueOf(n));
            borrarElement(e);

        }
    }

    public static void delete_mallot() {
        show_mallot();
        String n = Leer.leerTexto(ConsoleColors.RED + "Delete mallot : Elige 1 o varios mallots (separados por coma)   :" + ConsoleColors.RESET);
        Mallot m;
        if (n.contains(",")) {
            String[] n_split = n.split(",");
            for (String p : n_split) {

                m = get_mallot(p);
                borrarElement(m);
            }

        } else {

            m = get_mallot(n);
            borrarElement(m);

        }
    }

    private static void disableLogging() {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.SEVERE);
    }

    private static Ciclista get_ciclista(Long dorsal) {
        laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();
        Ciclista c = laSessio.get(Ciclista.class, dorsal);

        laSessio.getTransaction().commit();
        return c;
    }

    private static Etapa get_etapa(Long numero) {
        laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();
        Etapa e = laSessio.get(Etapa.class, numero);

        laSessio.getTransaction().commit();
        return e;

    }

    private static Mallot get_mallot(String codi) {
        laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();
        Mallot m = laSessio.get(Mallot.class, codi);

        laSessio.getTransaction().commit();
        return m;

    }

    private static void añadir_etapas() {
        laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();

        Query e = laSessio.createQuery("from etapes");
        //Recuperamos todas las estapas
        List<Etapa> etapes = e.list();
        for (Etapa etapa : etapes) {
            if (etapa.getElciclista_ganador() != null) {
                Ciclista a = etapa.getElciclista_ganador();
                a.addEtapaGanada(etapa);
            }

        }
        laSessio.getTransaction().commit();
    }
}
