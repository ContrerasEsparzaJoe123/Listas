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
    private JMenu jm_listaS, jm_listaD;
    private JMenuItem jmi_insertar, jmi_borrar, jmi_salir,jmi_buscar, jmi_imprimir, jmi_ins, jmi_Bor, jmi_bus, jmi_insF, jmi_borF, jmi_imp;
    private ListaEmpleado lista =new ListaEmpleado();
    private EmployeeDoublyLinkedList list =new EmployeeDoublyLinkedList();
    public Main() {
        setTitle("Listas");
        setSize(500, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        jmb_emp = new JMenuBar();
        jm_listaS = new JMenu("Lista Simple");
        jm_listaD = new JMenu("Lista Doble");
        jmi_salir = new JMenuItem("Salir");
        jmi_salir.addActionListener(this);

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

        jm_listaD.add(jmi_ins);
        jm_listaD.add(jmi_Bor);
        jm_listaD.add(jmi_bus);
        jm_listaD.add(jmi_insF);
        jm_listaD.add(jmi_borF);
        jm_listaD.add(jmi_imp);
        jmb_emp.add(jm_listaS);
        jmb_emp.add(jm_listaD);
        jmb_emp.add(jmi_salir);
        setJMenuBar(jmb_emp);

        setVisible(true);

    }

    public static <T> List<T> convertALtoLL(
            List<T> aL)
    {

        // Return the converted LinkedList
        return aL

                // Convert the ArrayList into Stream
                .stream()

                // Collect the LinkedList
                .collect(Collectors

                        // Convert the Stream into LinkedList
                        // Collection type
                        .toCollection(LinkedList::new));
    }




    public static void main(String[] args) {
        Main ventanaPrincipal = new Main();

        MongoClient mongoClient = MongoClients.create("mongodb+srv://joec:that1guy2@cluster0-tlgse.mongodb.net/test?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("parcial2");
        MongoCollection<Document> collection = database
                .getCollection("posts");

        List<Document> posts = (List<Document>) collection.find().into(
                new ArrayList<Document>());

        for(Document document : posts){
            Document lL = convertALtoLL(document);
            System.out.println(document);


            // Print the LinkedList
            System.out.println("LinkedList: " + lL);

            /*
            if (convertALtoLL() != null) {
                convertALtoLL().remove(posts);
                System.out.println("LinkedList: " + lL);
            }*/
        }


    }

    private static <E> List<E> convertALtoLL() {
        return null;
    }

    private static Document convertALtoLL(Document document) {

        return document;
    }


    @Override
    public void actionPerformed(ActionEvent e) {




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

            /*
            for(Empleado item : e) {

                if(item.getNombre().equals(Empleado ) {
                    //perform calculations or display to screen here
                }

            }

            if(lista.buscar(emp)) {
                System.out.println("encontrado");
            }else {
                System.out.println("no se encontro");
            }
*/
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
