package com.Pro;

public class Empleado {
    private String Nombre;
    private String Apellido;
    private int id;

    public Empleado(String Nombre, String Apellido, int id) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String firstName) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
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

        Empleado empleado = (Empleado) o;

        if (id != empleado.id) return false;
        if (!Nombre.equals(empleado.Nombre)) return false;
        return Apellido.equals(empleado.Apellido);
    }

    @Override
    public int hashCode() {
        int result = Nombre.hashCode();
        result = 31 * result + Apellido.hashCode();
        result = Integer.parseInt(String.valueOf(31 * result + id));
        return result;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", id=" + id +
                '}';
    }
}
