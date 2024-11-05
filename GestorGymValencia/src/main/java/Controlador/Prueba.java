package Controlador;

import Modelo.Empleado;
import Modelo.ListaEmpleados;

public class Prueba {
    public static void main(String[] args) {
        ListaEmpleados lista = new ListaEmpleados();

        // Crear algunos empleados
        Empleado emp1 = new Empleado("sebastian", "Chicata", "75280457", "sebastianhoal", "Entrenador", 1);
        Empleado emp2 = new Empleado("Ana", "López", "87654321", "ana.lopez@example.com", "Contador", 2);
        Empleado emp3 = new Empleado("Carlos", "Martínez", "56789012", "carlos.martinez@example.com", "Desarrollador", 3);

        // Agregar empleados a la lista
        lista.agregarEmpleado(emp1);
        lista.agregarEmpleado(emp2);
        lista.agregarEmpleado(emp3);

        // Prueba de agregarEmpleado
        System.out.println("Empleados agregados a la lista.");
        mostrarListaEmpleados(lista);

        // Prueba de buscarEmpleado
        System.out.println("\nBuscando empleado en la posición 1:");
        Empleado encontrado = lista.buscarEmpleado(1);
        if (encontrado != null) {
            System.out.println("Empleado encontrado: " + encontrado.getNombres() + " " + encontrado.getApellidos());
        } else {
            System.out.println("No se encontró el empleado en la posición indicada.");
        }

        // Prueba de eliminarEmpleado
        System.out.println("\nEliminando el primer empleado...");
        lista.eliminarEmpleado();
        mostrarListaEmpleados(lista);
    }
    
    public static void mostrarListaEmpleados(ListaEmpleados lista) {
        for (int i = 0; i < 10; i++) { // Recorre un número limitado de elementos como ejemplo
            Empleado empleado = lista.buscarEmpleado(i);
            if (empleado != null) {
                System.out.println("Empleado " + i + ": " + empleado.getNombres() + " " + empleado.getApellidos() + " - " + empleado.getCorreoElectronico());
            } else {
                break; // Termina si no hay más empleados
            }
        }
    }
}