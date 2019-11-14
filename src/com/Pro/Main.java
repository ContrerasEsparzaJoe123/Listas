package com.Pro;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main extends JFrame implements ActionListener {

    private JMenuBar jmb_emp;
    private JMenu jm_listaS, jm_listaD, jm_listaC;
    private JMenuItem jmi_insertar, jmi_borrar, jmi_salir,jmi_buscar, jmi_imprimir, jmi_ins, jmi_Bor, jmi_bus, jmi_insF, jmi_borF, jmi_imp, jmi_borrarP, jmi_Inser, jmi_busca, jmi_impr, jmi_Eli;
    private ListaEmpleado lista =new ListaEmpleado();
    private ListaC lista2 = new ListaC();
    private EmployeeDoublyLinkedList list =new EmployeeDoublyLinkedList();
    public Main() {
        setTitle("Listas");
        setSize(500, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        jmb_emp = new JMenuBar();
        jm_listaS = new JMenu("Lista Simple");
        jm_listaD = new JMenu("Lista Doble");
        jm_listaC = new JMenu("Lista Circular");
        jmi_salir = new JMenuItem("Salir");
        jmi_salir.addActionListener(this);

        jmi_impr = new JMenuItem("Imprimir");
        jmi_impr.addActionListener(this);
        jmi_Eli = new JMenuItem("Elimminar Lista");
        jmi_Eli.addActionListener(this);
        jmi_busca = new JMenuItem("Buscar");
        jmi_busca.addActionListener(this);
        jmi_borrarP = new JMenuItem("Borrar por Posicion");
        jmi_borrarP.addActionListener(this);
        jmi_Inser = new JMenuItem("Insertar");
        jmi_Inser.addActionListener(this);

        jmi_insertar = new JMenuItem("Insertar");
        jmi_insertar.addActionListener(this);
        jmi_borrar = new JMenuItem("Borrar");
        jmi_borrar.addActionListener(this);
        jmi_buscar = new JMenuItem("Buscar");
        jmi_buscar.addActionListener(this);
        jmi_imprimir = new JMenuItem("Imprimir");
        jmi_imprimir.addActionListener(this);


        jmi_ins = new JMenuItem("Insertar al Principio");
        jmi_ins.addActionListener(this);
        jmi_Bor = new JMenuItem("Borrar del Principio");
        jmi_Bor.addActionListener(this);
        jmi_insF = new JMenuItem("Insertar al Final");
        jmi_insF.addActionListener(this);
        jmi_borF = new JMenuItem("Borrar al Final");
        jmi_borF.addActionListener(this);
        jmi_imp = new JMenuItem("Imprimir");
        jmi_imp.addActionListener(this);
        jmi_bus = new JMenuItem("Buscar");
        jmi_bus.addActionListener(this);



        jm_listaS.add(jmi_insertar);
        jm_listaS.add(jmi_borrar);
        jm_listaS.add(jmi_buscar);
        jm_listaS.add(jmi_imprimir);


        jm_listaC.add(jmi_Inser);
        jm_listaC.add(jmi_borrarP);
        jm_listaC.add(jmi_busca);
        jm_listaC.add(jmi_impr);
        jm_listaC.add(jmi_Eli);


        jm_listaD.add(jmi_ins);
        jm_listaD.add(jmi_Bor);
        jm_listaD.add(jmi_bus);
        jm_listaD.add(jmi_insF);
        jm_listaD.add(jmi_borF);
        jm_listaD.add(jmi_imp);
        jmb_emp.add(jm_listaS);
        jmb_emp.add(jm_listaD);
        jmb_emp.add(jm_listaC);
        jmb_emp.add(jmi_salir);
        setJMenuBar(jmb_emp);

        setVisible(true);

    }







    public static void main(String[] args) {
        Main ventanaPrincipal = new Main();


    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== jmi_Inser) {
            String nombre = JOptionPane.showInputDialog("Nombre");
            String apellido = JOptionPane.showInputDialog("Apellido");
            Integer id = Integer.valueOf(JOptionPane.showInputDialog("ID"));
            Empleado emp = new Empleado(nombre, apellido, id);

            lista2.agregarAlInicio(emp);
            System.out.println("Empleado Agregado");

        }


        if(e.getSource()== jmi_impr) {
            lista2.listar();

        }

        if(e.getSource()== jmi_Eli) {
            lista2.eliminar();
            System.out.println("Lista Borrada");
        }

        if(e.getSource()== jmi_borrarP) {
            String nombre = JOptionPane.showInputDialog("Nombre");
            String apellido = JOptionPane.showInputDialog("Apellido");
            Integer id = Integer.valueOf(JOptionPane.showInputDialog("ID"));
            Empleado emp = new Empleado(nombre, apellido, id);
            lista2.borrarNodo(emp);
        }

        if(e.getSource()== jmi_bus) {
            Integer id = Integer.valueOf(JOptionPane.showInputDialog("ID"));
            if(list.buscarN(id)) {
                System.out.println("encontrado");
            }else {
                System.out.println("no se encontro");
            }
        }

        if(e.getSource()== jmi_insertar) {
            String nombre = JOptionPane.showInputDialog("Nombre");
            String apellido = JOptionPane.showInputDialog("Apellido");
            Integer id = Integer.valueOf(JOptionPane.showInputDialog("ID"));
            Empleado emp = new Empleado(nombre, apellido, id);

            lista.InsertarAlFrente(emp);
            System.out.println("Empleado Agregado");

        }
        if(e.getSource()== jmi_imprimir) {

            System.out.println("Numero de Empleados:" + lista.getSize());
            lista.imprimirLista();

        }
        if(e.getSource()== jmi_borrar) {
            lista.borrarNodo();
            System.out.println("Numero de Empleados:" + lista.getSize());
            lista.imprimirLista();

        }

        if(e.getSource()== jmi_buscar) {

            Integer id = Integer.valueOf(JOptionPane.showInputDialog("ID"));



            if(lista.buscar(id)) {
                System.out.println("encontrado");
            }else {
                System.out.println("no se encontro");
            }

        }
        if(e.getSource()== jmi_ins) {

            String nombre = JOptionPane.showInputDialog("Nombre");
            String apellido = JOptionPane.showInputDialog("Apellido");
            Integer id = Integer.valueOf(JOptionPane.showInputDialog("ID"));
            Employee emp1 = new Employee(nombre, apellido, id);

            list.addToFront(emp1);
            System.out.println("Empleado Agregado");

        }

        if(e.getSource()== jmi_insF) {

            String nombre = JOptionPane.showInputDialog("Nombre");
            String apellido = JOptionPane.showInputDialog("Apellido");
            Integer id = Integer.valueOf(JOptionPane.showInputDialog("ID"));
            Employee emp1 = new Employee(nombre, apellido, id);

            list.addToEnd(emp1);
            System.out.println("Empleado Agregado al final");

        }

        if(e.getSource()== jmi_Bor) {

            list.removeFromFront();
            System.out.println("Empleado Borrado");
            System.out.println("Numero de Empleados:" + list.getSize());
            list.printList();

        }

        if(e.getSource()== jmi_borF) {

            list.removeFromEnd();
            System.out.println("Empleado Borrado del final");
            System.out.println("Numero de Empleados:" + list.getSize());
            list.printList();

        }

        if(e.getSource()== jmi_imp) {
            System.out.println("Numero de Empleados:" + list.getSize());
            list.printList();
        }

    }
}
