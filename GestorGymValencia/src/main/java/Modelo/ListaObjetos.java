package Modelo;

import java.io.*;

public class ListaObjetos {
    private Nodo cabeza = null;
    private static final String FILE_PATH = "src/main/resources/Files/Objetos.txt";

    public class Nodo {
        public Objeto objeto;
        public Nodo siguiente = null;

        public Nodo(Objeto objeto) {
            this.objeto = objeto;
        }
    }

    public ListaObjetos() {
        cargarObjetosDesdeArchivo();
    }

    public void agregarObjeto(Objeto objeto) {
        Nodo nodo = new Nodo(objeto);
        if (cabeza == null) {
            cabeza = nodo;
        } else {
            Nodo puntero = cabeza;
            while (puntero.siguiente != null) {
                puntero = puntero.siguiente;
            }
            puntero.siguiente = nodo;
        }
        guardarObjetosEnArchivo();
    }

    public Objeto buscarPorId(String id) {
        Nodo puntero = cabeza;
        while (puntero != null) {
            Objeto objeto = puntero.objeto;
            if (objeto.getId().equals(id)) {
                return objeto;
            }
            puntero = puntero.siguiente;
        }
        return null;
    }

    public void guardarObjetosEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            Nodo puntero = cabeza;
            while (puntero != null) {
                Objeto objeto = puntero.objeto;
                String linea = objeto.getId() + "," +
                               objeto.getNombre() + "," +
                               objeto.getTipo() + "," +
                               objeto.getEstado();
                writer.write(linea);
                writer.newLine();
                puntero = puntero.siguiente;
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los objetos en el archivo: " + e.getMessage());
        }
    }

    public boolean eliminarPorId(String id) {
        if (cabeza == null) return false;

        if (cabeza.objeto.getId().equals(id)) {
            cabeza = cabeza.siguiente;
            guardarObjetosEnArchivo();
            return true;
        }

        Nodo puntero = cabeza;
        while (puntero.siguiente != null) {
            if (puntero.siguiente.objeto.getId().equals(id)) {
                puntero.siguiente = puntero.siguiente.siguiente;
                guardarObjetosEnArchivo();
                return true;
            }
            puntero = puntero.siguiente;
        }
        return false;
    }
    public void cargarObjetosDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            Nodo ultimoNodo = null;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    String id = datos[0];
                    String nombre = datos[1];
                    String tipo = datos[2];
                    String estado = datos[3];

                    Objeto objeto = new Objeto(id, nombre, tipo, estado);
                    Nodo nodo = new Nodo(objeto);

                    if (cabeza == null) {
                        cabeza = nodo;
                    } else {
                        ultimoNodo.siguiente = nodo;
                    }
                    ultimoNodo = nodo;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los objetos desde el archivo: " + e.getMessage());
        }
    }
}
