package tallermecanicoclases;

import java.util.ArrayList;
import java.util.Scanner;

public class Tallermecanicoclases {

    private static int id = -1;
    static ArrayList<trabajos> mistrabajos = new ArrayList<>();

    //menu de opciones
    private static int menuopciones() {
        Scanner entrada = new Scanner(System.in);
        int elegiropcion = entrada.nextInt();
        System.out.println(" opcion 1 registra un nuevo trabajo");
        System.out.println("opcion 2 actualiza un trabajo ya existente");
        System.out.println("opcion 3 consulta un trabajo");
        System.out.println("opcion 4 calcula el precio a cobrar de un trabajo");
        System.out.println("opcion 5  salir");
        System.out.println("Elige una opcion:");
        switch (elegiropcion) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("opcion no valida");
        }
        return elegiropcion;
    }
// opcion de registrar un nuevo trabajo

    private static int nuevotrabajo() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("elige un numero de horas");
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
        if (identificacion < id || identificacion > id) {
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
        Scanner entrada = new Scanner(System.in);
        System.out.println("Elije la ID del trabajo para actualizar");
        int numerotrabajo = entrada.nextInt();

        if (numerotrabajo < id || numerotrabajo > id) {
            System.out.println("El trabajo no existe");
        } else if (mistrabajos.get(numerotrabajo).getfinalizaciondeltrabajo() == true) {
            System.out.println("trabajo finalizado");
        } else {
            System.out.println("pulsa 1 para actualizar horas");
            System.out.println("pulsa 2 para actualizar material");
            System.out.println("pulsa 3 para finalizar trabajo");

            int opciones = entrada.nextInt();
            do {
                switch (opciones) {
                    case 1:
                        int horasactuales = mistrabajos.get(numerotrabajo).getNumero_horas();
                        System.out.println("¿cuantas horas mas has realizado?");
                        int horasmas = entrada.nextInt();
                        mistrabajos.get(numerotrabajo).setNumero_horas(horasmas + horasactuales);
                        break;
                    case 2:
                        int materialactual = mistrabajos.get(numerotrabajo).getPrecio_material();
                        System.out.println("¿cuanto material mas has gastado?");
                        int materialmas = entrada.nextInt();
                        mistrabajos.get(numerotrabajo).setNumero_horas(materialmas + materialactual);
                        break;
                    case 3:
                        System.out.println("trabajo finalizado");
                        mistrabajos.get(numerotrabajo).setFinalizaciondeltrabajo(true);

                }

            } while (opciones < 3 && opciones > 1);
        }
    }

    public static void main(String[] args) {
        nuevotrabajo();
        consultartrabajos();
        nuevotrabajo();
        consultartrabajos();
        actualizartrabajos();
        consultartrabajos();
        actualizartrabajos();
    }
}
