package Modelo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class ListaClientes {
    private Nodo cabeza = null;
    private static final String FILE_PATH = "src/main/resources/Files/Clientes.txt";
    private SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.forLanguageTag("es-ES"));

    public class Nodo {
        public Cliente cliente;
        public Nodo siguiente = null;

        public Nodo(Cliente cliente) {
            this.cliente = cliente;
        }
    }

     public ListaClientes() {
        cargarClientesDesdeArchivo(); // Cargar los clientes desde el archivo al inicializar la lista
    }

    // Método modificado para agregar al final de la lista en lugar de al inicio
    public void agregarCliente(Cliente cliente) {
        Nodo nodo = new Nodo(cliente);
        if (cabeza == null) {
            cabeza = nodo;
        } else {
            Nodo puntero = cabeza;
            while (puntero.siguiente != null) {
                puntero = puntero.siguiente;
            }
            puntero.siguiente = nodo;
        }
        guardarClientesEnArchivo(); // Guardar en archivo cada vez que se agrega un cliente
    }

    public Cliente buscarPorDNI(String dni) {
        Nodo puntero = cabeza;
        while (puntero != null) {
            Cliente cliente = puntero.cliente;
            if (cliente.getDNI().equals(dni)) {
                return cliente; // Devuelve el cliente si encuentra el DNI
            }
            puntero = puntero.siguiente;
        }
        return null; // Devuelve null si no encuentra el DNI
    }

    public boolean actualizarCliente(String dni, Date nuevaFechaInicio, Date nuevaFechaFin, String nuevoTipoMembresia) {
        Nodo puntero = cabeza;
        while (puntero != null) {
            Cliente cliente = puntero.cliente;
            if (cliente.getDNI().equals(dni)) {
                // Actualizar los datos del cliente
                cliente.setInicioMembresia(nuevaFechaInicio);
                cliente.setFinMembresia(nuevaFechaFin);
                cliente.setTipoMembresia(nuevoTipoMembresia);
                guardarClientesEnArchivo(); // Guardar los cambios en el archivo
                return true;
            }
            puntero = puntero.siguiente;
        }
        return false; // Devuelve false si no encontró el cliente
    }
    
    
    public void imprimirClientes() {
        Nodo puntero = cabeza;
        while (puntero != null) {
            Cliente cliente = puntero.cliente;
            System.out.println("DNI: " + cliente.getDNI() +
                               ", Nombres: " + cliente.getNombres() +
                               ", Apellidos: " + cliente.getApellidos() +
                               ", Inicio Membresia: " + sdf.format(cliente.getInicioMembresia()) +
                               ", Fin Membresía: " + sdf.format(cliente.getFinMembresia()) +
                               ", Tipo de Membresia: " + cliente.getTipoMembresia());
            puntero = puntero.siguiente;
        }
    }

    private void guardarClientesEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            Nodo puntero = cabeza;
            while (puntero != null) {
                Cliente cliente = puntero.cliente;
                String linea = cliente.getDNI() + "," +
                               cliente.getNombres() + "," +
                               cliente.getApellidos() + "," +
                               sdf.format(cliente.getInicioMembresia()) + "," +
                               sdf.format(cliente.getFinMembresia()) + "," +
                               cliente.getTipoMembresia();
                writer.write(linea);
                writer.newLine();
                puntero = puntero.siguiente;
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los clientes en el archivo: " + e.getMessage());
        }
    }

    private void cargarClientesDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            Nodo ultimoNodo = null;  // Para mantener el último nodo mientras se construye la lista
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 6) {
                    String dni = datos[0];
                    String nombres = datos[1];
                    String apellidos = datos[2];
                    Date inicioMembresia = sdf.parse(datos[3]);
                    Date finMembresia = sdf.parse(datos[4]);
                    String tipoMembresia = datos[5];

                    Cliente cliente = new Cliente(dni, nombres, apellidos, inicioMembresia, finMembresia, tipoMembresia);
                    Nodo nodo = new Nodo(cliente);

                    if (cabeza == null) {
                        cabeza = nodo;
                    } else {
                        ultimoNodo.siguiente = nodo;
                    }
                    ultimoNodo = nodo;  // Actualizar el último nodo
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error al cargar los clientes desde el archivo: " + e.getMessage());
        }
    }
}
