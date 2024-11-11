package Modelo;

public class ListaEmpleados {
    private Nodo cabeza = null;
    private int longitud = 0;
    
    public class Nodo{
        public Empleado empleado;
        public Nodo siguiente = null;

        public Nodo(Empleado empleado){
            this.empleado = empleado;
        }
    }
    
    public void agregarEmpleado(Empleado empleado){
        Nodo nodo = new Nodo(empleado);
        nodo.siguiente = cabeza;
        cabeza = nodo;
        longitud++;
    }
    
    public Empleado buscarEmpleado(int n){
        if (cabeza == null){
            return null;
        }
        else{
            Nodo puntero = cabeza;
            int contador = 0;
            while(contador < n && puntero.siguiente != null){
                puntero = puntero.siguiente;
                contador++;
            }
            if (contador != n){
                return null;
            }
            else{
                return puntero.empleado;
            }
        }
    }
    
    public void eliminarEmpleado(){
        Nodo primer = cabeza;
        cabeza = cabeza.siguiente;
        primer.siguiente = null;
        longitud--;
    }
}
