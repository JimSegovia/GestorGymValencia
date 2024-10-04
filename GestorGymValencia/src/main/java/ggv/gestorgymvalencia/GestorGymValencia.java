package ggv.gestorgymvalencia;

import java.util.InputMismatchException;
import java.util.Scanner;
public class GestorGymValencia {

    public static void main(String[] args) {
        
        Scanner consola = new Scanner(System.in);
        boolean salir = false;

        // Instacia para poder acceder a las funciones
        FuncionesCliente funcionesCliente = new FuncionesCliente();

        while (!salir) {
            System.out.println("---------------------------------------");
            System.out.println(" || GESTOR DE CLIENTES GYM VALENCIA || ");
            System.out.println("---------------------------------------");
            System.out.print("""
                    1. Clientes
                    2. Empleados
                    3. Inventario
                    4. Finanzas
                    5. Salir del programa
                    Eliga una opcion:\s""");

            try {
                int opcion = consola.nextInt();
                limpiarPantalla(); // Simula limpiar la pantalla

                switch (opcion) {
                    case 1 -> {
                        boolean salirCliente = false;

                        while(!salirCliente){
                            System.out.println("----------------");
                            System.out.println(" || CLIENTES || ");
                            System.out.println("----------------");
                            System.out.print("""
                                    1. Agregar cliente
                                    2. Buscar cliente
                                    3. Eliminar cliente
                                    4. Mostrar lista de clientes
                                    5. Volver a menu principal
                                    Eliga una opcion:\s""");

                            try{
                                int opcionCliente = consola.nextInt();
                                limpiarPantalla();

                                switch (opcionCliente){
                                    case 1 -> funcionesCliente.agregarCliente();
                                    case 2 -> funcionesCliente.buscarCliente();
                                    case 3 -> funcionesCliente.eliminarCliente();
                                    case 4 -> funcionesCliente.mostrarClientes();
                                    case 5 ->{
                                        System.out.println("Volviendo al menu principal...");
                                        salirCliente = true;
                                    }
                                    default -> System.out.println("Opcion invalida...");
                                }
                            }catch (InputMismatchException e){
                                limpiarPantalla();
                                consola.nextLine();
                                System.out.println("Entrada invalida, debe ingresar un numero");
                            }
                        }
                    }
                    case 2 -> {
                        boolean salirEmpleado = false;

                        while (!salirEmpleado){
                            System.out.println("-----------------");
                            System.out.println(" || EMPLEADOS || ");
                            System.out.println("-----------------");
                            System.out.print("""
                                    1. Agregar empleado
                                    2. Consultar empleado
                                    3. Eliminar empleado
                                    4. Volver al menu principal
                                    Eliga una opcion:\s""");

                            try{
                                int opcionEmpleado = consola.nextInt();
                                limpiarPantalla();

                                switch (opcionEmpleado){
                                    case 1 ->{
                                        // agregarEmpleado();
                                    }
                                    case 2 ->{
                                        // consultarEmpleado();
                                    }
                                    case 3 ->{
                                        // eliminarEmpleado();
                                    }
                                    case 4 ->{
                                        System.out.println("Volviendo al menu principal...");
                                        salirEmpleado = true;
                                    }
                                    default -> System.out.println("Opcion invalida...");
                                }

                            }catch (InputMismatchException e){
                                limpiarPantalla();
                                consola.nextLine();
                                System.out.println("Entrada invalida, debe ingresar un numero");
                            }
                        }
                    }
                    case 3 -> {
                        boolean salirInventario = false;

                        while (!salirInventario){
                            System.out.println("------------------");
                            System.out.println(" || INVENTARIO || ");
                            System.out.println("------------------");
                            System.out.print("""
                                    1. Agregar objeto
                                    2. Gestionar Inventario
                                    3. Eliminar objeto
                                    4. volver al menu principal
                                    Eliga una opcion:\s""");

                            try{
                                int opcionInventario = consola.nextInt();
                                limpiarPantalla();

                                switch (opcionInventario){
                                    case 1 ->{
                                        // agregarObjeto();
                                    }
                                    case 2 ->{
                                        // gestionarInventario();
                                    }
                                    case 3 ->{
                                        // eliminarObjeto();
                                    }
                                    case 4 ->{
                                        System.out.println("Volviendo al menu principal...");
                                        salirInventario = true;
                                    }
                                    default -> System.out.println("Opcion invalida...");
                                }
                            }catch (InputMismatchException e){
                                limpiarPantalla();
                                consola.nextLine();
                                System.out.println("Entrada invalida, debe ingresar un numero");
                            }
                        }
                    }
                    case 4 -> {
                        boolean salirFinanzas = false;

                        while(!salirFinanzas){
                            System.out.println("----------------");
                            System.out.println(" || FINANZAS || ");
                            System.out.println("----------------");
                            System.out.print("""
                                    1. Control de pagos pendientes
                                    2. Reportes financieros
                                    3. Gestion de sueldos
                                    4. Volver al menu principal
                                    Eliga una opcion:\s""");

                            try{
                                int opcionFinanzas = consola.nextInt();
                                limpiarPantalla();

                                switch (opcionFinanzas){
                                    case 1 ->{
                                        // verificarPagos();
                                    }
                                    case 2 ->{
                                        // generarReporteFinanciero();
                                    }
                                    case 3 ->{
                                        // gestionarSueldos();
                                    }
                                    case 4 ->{
                                        System.out.println("Volviendo al menu principal...");
                                        salirFinanzas = true;
                                    }
                                    default -> System.out.println("Opcion invalida...");
                                }

                            }catch (InputMismatchException e){
                                limpiarPantalla();
                                consola.nextLine();
                                System.out.println("Entrada invalida, debe ingresar un numero");
                            }
                        }
                    }
                    case 5 -> {
                        System.out.println("Saliendo del programa...");
                        salir = true;
                    }
                    default -> System.out.println("Opción invalida...");
                }
            } catch (InputMismatchException e) {
                limpiarPantalla(); // Simula limpiar la pantalla
                consola.nextLine(); // Esto es para limpiar el buffer del Scanner y evitar un bucle infinito
                System.out.println("Entrada invalida, debe ingresar un numero");
            }
        }
    }

    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
