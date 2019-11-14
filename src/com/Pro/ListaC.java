package com.Pro;

public class ListaC {
    private NodoEmpleado inicio;
    private NodoEmpleado ultimo;
    private int size;

    public void Lista(){
        inicio = null;
        ultimo = null;
        size = 0;
    }
    public boolean esVacia(){
        return inicio == null;
    }
    public int getSize(){
        return size;
    }

    public void agregarAlInicio(Empleado empleado){
        NodoEmpleado nuevo = new NodoEmpleado(empleado);
        nuevo.setEmpleado(empleado );
        if (esVacia()) {
            inicio = nuevo;
            ultimo = nuevo;
            ultimo.setSiguiente(inicio);
        } else{
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            ultimo.setSiguiente(inicio);
        }
        size++;
    }
    public boolean buscar(Empleado empleado){
        // Crea una copia de la lista.
        NodoEmpleado aux = inicio;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta
        // llegar al primer nodo nuevamente.
        do{
            // Consulta si el valor del nodo es igual al de referencia.
            if (empleado == aux.getEmpleado()){
                // Canbia el valor de la bandera.
                encontrado = true;
            }
            else{
                // Avansa al siguiente. nodo.
                aux = aux.getSiguiente();
            }
        }while(aux != inicio && encontrado != true);
        // Retorna el resultado de la bandera.
        return encontrado;
    }


    public boolean buscar(int dato) {
        boolean respuesta=false;
        NodoEmpleado temporal = this.inicio;

        while(temporal!=null && temporal.getEmpleado().getId()!=dato) {
            temporal = temporal.getSiguiente();
        }
        if(temporal!=null) {
            respuesta=true;
        }
        return respuesta;
    }

    /*public void removerPorReferencia(Empleado empleado){
        if (buscar(empleado)) {
            if (inicio.getEmpleado() == empleado) {
                inicio = inicio.getSiguiente();
                ultimo.setSiguiente(inicio);
            } else{
                NodoEmpleado aux = inicio;
                while(aux.getSiguiente().getEmpleado() != empleado){
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() == ultimo) {
                    aux.setSiguiente(inicio);
                    ultimo = aux;
                } else {
                    NodoEmpleado siguiente = aux.getSiguiente();
                    aux.setSiguiente(siguiente.getSiguiente());
                }
            }
            size--;
        }
    }*/

    public NodoEmpleado borrarNodo(){

        NodoEmpleado empleadoBorrado= inicio;
        inicio=inicio.getSiguiente();
        size--;
        empleadoBorrado.setSiguiente(null);
        return empleadoBorrado;

    }
    public void eliminar(){
        inicio = null;
        ultimo = null;
        size = 0;
    }
    public void listar(){
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            // Crea una copia de la lista.
            NodoEmpleado aux = inicio;
            // Posicion de los elementos de la lista.
            int i = 0;
            System.out.print("-> ");
            // Recorre la lista hasta llegar nuevamente al incio de la lista.
            do{
                // Imprime en pantalla el valor del nodo.
                System.out.print(i + ".[ " + aux.getEmpleado() + " ]" + " ->  ");
                // Avanza al siguiente nodo.
                aux = aux.getSiguiente();
                // Incrementa el contador de la posi�n.
                i++;
            }while(aux != inicio);
        }
    }





}
