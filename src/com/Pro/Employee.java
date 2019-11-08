package com.Pro;

public class Employee {

    private String Nombre;
    private String Apellido;
    private int id;

    public Employee(String Nombre, String Apellido, int id) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.id = id;
    }

    public String getFirstName() {
        return Nombre;
    }

    public void setFirstName(String firstName) {
        this.Nombre = Nombre;
    }

    public String getLastName() {
        return Apellido;
    }

    public void setLastName(String lastName) {
        this.Apellido = Apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (!Nombre.equals(employee.Nombre)) return false;
        return Apellido.equals(employee.Apellido);
    }

    @Override
    public int hashCode() {
        int result = Nombre.hashCode();
        result = 31 * result + Apellido.hashCode();
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", id=" + id +
                '}';
    }

}
