package com.Pro;

public class MainD {

    public static void main(String[] args) {
        Employee JuanaRodriguez = new Employee("Juana", "Rodriguez", 123);
        Employee JuanLopez = new Employee("Juan", "Lopez", 4567);
        Employee MariaSmith = new Employee("Maria", "Smith", 22);
        Employee MiguelJordan = new Employee("Miguel", "Jordan", 3245);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        list.addToFront(JuanaRodriguez);
        list.addToFront(JuanLopez);
        list.addToFront(MariaSmith);
        list.addToFront(MiguelJordan);

        list.printList();
        System.out.println(list.getSize());

        Employee billEnd = new Employee("Bill", "End", 78);
        list.addToEnd(billEnd);
        list.printList();
        System.out.println(list.getSize());
        list.removeFromFront();
        list.printList();
        System.out.println(list.getSize());
        list.removeFromEnd();
        list.printList();
        System.out.println(list.getSize());

    }
}
