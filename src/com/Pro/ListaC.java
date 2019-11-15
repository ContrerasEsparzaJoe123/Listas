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
    public boolean buscarC(int dato) {
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


    public boolean buscar(int referencia){
        NodoEmpleado aux = inicio;
        boolean encontrado = false;
        do{
            if (referencia == aux.getEmpleado().getId()){
                encontrado = true;
            }
            else{
                aux = aux.getSiguiente();
            }
        }while(aux != inicio && encontrado != true);
        return encontrado;
    }

    public void removerPorReferencia(int referencia){
        // Consulta si el valor de referencia existe en la lista.
        if (buscar(referencia)) {
            // Consulta si el nodo a eliminar es el pirmero
            if (inicio.getEmpleado().getId() == referencia) {
                // El primer nodo apunta al siguiente.
                inicio = inicio.getSiguiente();
                // Apuntamos con el ultimo nodo de la lista al inicio.
                ultimo.setSiguiente(inicio);
            } else{
                // Crea ua copia de la lista.
                NodoEmpleado aux = inicio;
                // Recorre la lista hasta llegar al nodo anterior
                // al de referencia.
                while(aux.getSiguiente().getEmpleado().getId() != referencia){
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() == ultimo) {
                    aux.setSiguiente(inicio);
                    ultimo = aux;
                } else {
                    // Guarda el nodo siguiente del nodo a eliminar.
                    NodoEmpleado siguiente = aux.getSiguiente();
                    // Enlaza el nodo anterior al de eliminar con el
                    // sguiente despues de el.
                    aux.setSiguiente(siguiente.getSiguiente());
                    // Actualizamos el puntero del ultimo nodo
                }
            }
            // Disminuye el contador de tama�o de la lista.
            size--;
        }
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
