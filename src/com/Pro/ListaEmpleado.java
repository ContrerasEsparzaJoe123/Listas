package com.Pro;

import javax.swing.*;

public class ListaEmpleado {
    private NodoEmpleado head;
    private int size;

    public void InsertarAlFrente(Empleado empleado){
        NodoEmpleado nodo = new NodoEmpleado(empleado);
        nodo.setSiguiente(head);
        head = nodo;
        size++;
    }

    public NodoEmpleado borrarNodo(){
        if (listaVacia()){
            return null;
        }
        NodoEmpleado empleadoBorrado= head;
        head=head.getSiguiente();
        size--;
        empleadoBorrado.setSiguiente(null);
        return empleadoBorrado;

    }

    public int getSize(){
        return size;
    }

    public boolean buscar(int dato) {
        boolean respuesta=false;
        NodoEmpleado temporal = this.head;

        while(temporal!=null && temporal.getEmpleado().getId()!=dato) {
            temporal = temporal.getSiguiente();
        }
        if(temporal!=null) {
            respuesta=true;
        }
        return respuesta;
    }


    public boolean listaVacia(){
        return head == null;
    }
    public void imprimirLista(){
        NodoEmpleado actual = head;
        System.out.println("Head-> ");
        while (actual!=null){
            System.out.println(actual);
            //JOptionPane.showMessageDialog(null,  actual);
            System.out.println("-> ");
            actual=actual.getSiguiente();

        }

        System.out.println("null");
    }


}
