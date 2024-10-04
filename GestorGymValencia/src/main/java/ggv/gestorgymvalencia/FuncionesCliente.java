package ggv.gestorgymvalencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FuncionesCliente {
    private final List<Cliente> clientes = new ArrayList<>();
    private final Scanner consola = new Scanner(System.in);

    // Constructor para el metodo main
    public FuncionesCliente(){}

    public void agregarCliente() {
        Cliente cliente = new Cliente();
        limpiarPantallaCliente();

        System.out.println("--------------------");
        System.out.println(" || NUEVO CLIENTE ||");
        System.out.println("--------------------");
        System.out.println("Coloque los nombres del cliente: ");
        cliente.setNombres(consola.nextLine());
        System.out.println("Coloque los apellidos del cliente: ");
        cliente.setApellidos(consola.nextLine());

        boolean dniValido = false;
        while(!dniValido){
            try {
                System.out.println("Coloque el documento del cliente (DNI): ");
                cliente.setDNI(Integer.parseInt(consola.nextLine()));
                dniValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida, Ingrese un numero");
            }
        }

        clientes.add(cliente);
        System.out.println("Cliente agregado exitosamente");
        System.out.println("presione Enter para continuar...");
        consola.nextLine();
    }

    public void buscarCliente() {
        limpiarPantallaCliente();

        System.out.println("-----------------------");
        System.out.println(" || BUSCANDO CLIENTE ||");
        System.out.println("-----------------------");
        System.out.print("Ingrese el DNI del cliente: ");
        int validacion = Integer.parseInt(consola.nextLine());

        boolean encontrado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getDNI() == validacion) {
                System.out.println("Cliente encontrado!");
                System.out.println("Nombres: " + cliente.getNombres());
                System.out.println("Apellidos: " +  cliente.getApellidos());
                System.out.println("Documento: " + cliente.getDNI());
                encontrado = true;
                System.out.println("Presione Enter para continuar...");
                consola.nextLine();
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado...");
            System.out.println("Presione Enter para continuar...");
            consola.nextLine();
        }
    }

    public void eliminarCliente(){
        limpiarPantallaCliente();

        System.out.println("--------------------------");
        System.out.println(" || ELIMINANDO CLIENTE || ");
        System.out.println("--------------------------");
        System.out.print("Ingrese el DNI del cliente a eliminar: ");
        int eliminar = Integer.parseInt(consola.nextLine());

        Cliente clienteEliminar = null;

        for (Cliente cliente : clientes) {
            if (cliente.getDNI() == eliminar) {
                clienteEliminar = cliente;
                break;
            }
        }

        // Eliminar el cliente si se encuentra
        if (clienteEliminar != null) {
            clientes.remove(clienteEliminar);
            System.out.println("Cliente eliminado exitosamente");
            System.out.println("Presione Enter para continuar...");
            consola.nextLine();
        }
        else {
            System.out.println("Cliente no encontrado");
            System.out.println("Presione Enter para continuar...");
            consola.nextLine();
        }
    }

    public void mostrarClientes(){
        limpiarPantallaCliente();

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
            System.out.println("Presione Enter para continuar...");
            consola.nextLine();
        } else {
            System.out.println("------------------------------------");
            System.out.println(" || LISTA DE CLIENTES REGISTRADOS ||");
            System.out.println("------------------------------------");

            int i = 1;
            for (Cliente cliente : clientes) {
                System.out.println("Cliente número " + i + ": ");
                System.out.println("Nombre completo: " + cliente.getNombres() + " " + cliente.getApellidos());
                System.out.println("Documento de identidad: " + cliente.getDNI());
                System.out.println("-------------------------");
                i++;
            }
            System.out.println("Presione Enter para continuar...");
            consola.nextLine();
        }
    }

    // Simula limpiar la pantalla
    private void limpiarPantallaCliente() {
        for(int i = 0; i < 50; i++){
            System.out.println();
        }
    }
}