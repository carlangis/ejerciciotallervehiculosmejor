package tallermecanicoclases;

import java.util.ArrayList;
import java.util.Scanner;

public class Tallermecanicoclases {

    private static int id = -1;
    static ArrayList<trabajos> mistrabajos = new ArrayList<>();

    //menu de opciones
    private static int menuopciones() {
        System.out.println("eliege una opcion: ");
        System.out.println("opcion 1 registrar nuevo trabajo");
        System.out.println("opcion 2 consultar un trabajo");
        System.out.println("opcion 3 actualizar trabajo");
        System.out.println("opcion 4 calcular precio del trabajo");
        System.out.println("opcion 5 salir");
        Scanner entrada = new Scanner(System.in);
        int opciones = entrada.nextInt();
        switch (opciones) {
            case 1:
                nuevotrabajo();
                return opciones;
            case 2:
                consultartrabajos();
                return opciones;
            case 3:
                actualizartrabajos();
                return opciones;
            case 4:
                calcularprecio();
                return opciones;
            case 5:
                System.out.println("salir del programa");
                return opciones;
            default:
                System.out.println("opcion no valida");
        }
        return opciones;
    }

// opcion de registrar un nuevo trabajo
    private static int nuevotrabajo() {
        System.out.println("NUEVO TRABAJO");
        System.out.println("elige un numero de horas");
        Scanner entrada = new Scanner(System.in);
        int numerohoras = entrada.nextInt();
        System.out.println("elige el precio del material");
        int material = entrada.nextInt();
        boolean fintrabajo = false;
        trabajos nuevotrabajo = new trabajos(id, numerohoras, material, fintrabajo);
        id++;
        mistrabajos.add(nuevotrabajo);
        return id;
    }

//opcion de consultar los trabajos    
    private static void consultartrabajos() {
        System.out.println("Elige un ID de trabajo para consultar");
        Scanner entrada = new Scanner(System.in);
        int identificacion = entrada.nextInt();
        if (identificacion < id || identificacion > id && identificacion < 0) {
            System.out.println("el trabajo no existe");
        } else {
            int correcionid = mistrabajos.get(identificacion).getId() + 1;
            System.out.println("identificacion del trabajo " + correcionid);
            System.out.println("numero de horas: " + mistrabajos.get(identificacion).getNumero_horas());
            System.out.println("precio del material: " + mistrabajos.get(identificacion).getPrecio_material());

        }

    }

//opcion de actualizar los trabajos
    private static void actualizartrabajos() {
        System.out.println("Elige la id del trabajo a actualizar");
        Scanner entrada = new Scanner(System.in);
        int eligeid = entrada.nextInt();
        if (id < eligeid || id > eligeid && eligeid < 0) {
            System.out.println("Eltrabajo no existe");
        } else {
            int correcionid = mistrabajos.get(eligeid).getId() + 1;
            if (mistrabajos.get(correcionid).getfinalizaciondeltrabajo() == true) {
                System.out.println("el trabajo ha finalizado y no se puede modificar");
            } else {
                System.out.println("identificacion del trabajo " + correcionid);

                System.out.println("elige una opcion para actualizar");
                System.out.println("1 para actualizar horas");
                System.out.println("2 para actualizar material");
                System.out.println("3 para finalizar trabajo");
                int opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("cuantas horas de mas has realizado?");
                        int horasnuevas = entrada.nextInt();
                        int horastotales = (mistrabajos.get(correcionid).getNumero_horas() + horasnuevas);
                        mistrabajos.get(correcionid).setNumero_horas(horastotales);
                        break;
                    case 2:
                        System.out.println("cuanto material de mas has gastado?");
                        int materialnuevo = entrada.nextInt();
                        int materialtotal = (mistrabajos.get(correcionid).getPrecio_material() + materialnuevo);
                        mistrabajos.get(correcionid).setPrecio_material(materialtotal);
                        break;

                    case 3:
                        mistrabajos.get(correcionid).setFinalizaciondeltrabajo(true);
                        System.out.println("trabajo finalizado");
                        break;

                    default:
                        System.out.println("elige algo correcto");
                        break;
                }
            }

        }
    }

//funcion de calcular el precio a cobrar    
    private static void calcularprecio() {
        System.out.println("elige una identificacion de trabajo");
        Scanner entrada = new Scanner(System.in);
        int opcionesreparacion = entrada.nextInt();
        System.out.println("Elige una opcion de reparacion");
        System.out.println("1 mecanica");
        System.out.println("2 chapa y pintura");
        System.out.println("3 revision");
        int opcionesmenu = entrada.nextInt();
        int correcionid = mistrabajos.get(opcionesreparacion).getId() + 1;
        if (correcionid < id || correcionid > id && correcionid < 0) {
            System.out.println("Eltrabajo no existe");
        } else {
            System.out.println("Elige una opcion de reparacion");

            switch (opcionesmenu) {
                case 1:

                    double calculoprecio = (mistrabajos.get(correcionid).getPrecio_material() * 1.1) + (mistrabajos.get(correcionid).getNumero_horas() * 30);
                    System.out.println("El precio final es de:");
                    System.out.println(calculoprecio);
                    break;
                case 2:

                    double calculoprecio2 = (mistrabajos.get(correcionid).getPrecio_material() * 1.3) + (mistrabajos.get(correcionid).getNumero_horas() * 30);
                    System.out.println("El precio final es");
                    System.out.println(calculoprecio2);
                    break;
                case 3:

                    double calculopreciorevision = (mistrabajos.get(correcionid).getPrecio_material() * 1.3) + (mistrabajos.get(correcionid).getNumero_horas() * 30);
                    System.out.println("El precio final de la revision es");
                    System.out.println(calculopreciorevision);
                    break;
                default:
                    System.out.println("identificacion no valida");
                    break;
            }

        }

    }

    public static void main(String[] args) {

        int opciones;
        do {
            opciones = menuopciones();
        } while (opciones != 5);

    }
}
