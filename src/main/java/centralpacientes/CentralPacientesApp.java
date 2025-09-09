package centralpacientes;

import java.util.Scanner;

public class CentralPacientesApp {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, "UTF-8");
        ListaPacientes lista = new ListaPacientes();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n==== Central de Pacientes ====");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Buscar paciente por ID");
            System.out.println("3. Eliminar paciente por ID");
            System.out.println("4. Mostrar lista de pacientes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = entrada.nextLine().trim();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre: ");
                    String nombre = entrada.nextLine().trim();

                    int edad = -1;
                    while (edad < 0) {
                        System.out.print("Edad (número entero): ");
                        String sEdad = entrada.nextLine().trim();
                        try {
                            edad = Integer.parseInt(sEdad);
                            if (edad < 0) {
                                System.out.println("La edad no puede ser negativa.");
                            }
                        } catch (Exception e) {
                            System.out.println("Entrada inválida. Intente de nuevo.");
                        }
                    }

                    System.out.print("Clínica: ");
                    String clinica = entrada.nextLine().trim();

                    Paciente registrado = lista.agregarPaciente(nombre, edad, clinica);
                    System.out.println("Paciente registrado con ID: " + registrado.getId());
                    break;

                case "2":
                    System.out.print("Ingrese ID a buscar: ");
                    int idBuscar = leerEntero(entrada);
                    Paciente encontrado = lista.buscarPacientePorId(idBuscar);
                    if (encontrado != null) {
                        System.out.println("Paciente encontrado:\n" + encontrado);
                    } else {
                        System.out.println("No se encontró paciente con ID " + idBuscar);
                    }
                    break;

                case "3":
                    System.out.print("Ingrese ID a eliminar: ");
                    int idEliminar = leerEntero(entrada);
                    boolean eliminado = lista.eliminarPacientePorId(idEliminar);
                    if (eliminado) {
                        System.out.println("Paciente con ID " + idEliminar + " eliminado.");
                    } else {
                        System.out.println("No se encontró paciente con ID " + idEliminar);
                    }
                    break;

                case "4":
                    lista.mostrarTodosPacientes();
                    break;

                case "5":
                    salir = true;
                    System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        entrada.close();
    }

    private static int leerEntero(Scanner entrada) {
        while (true) {
            String s = entrada.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un número entero: ");
            }
        }
    }
}
