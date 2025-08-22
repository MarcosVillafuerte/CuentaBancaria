package models;

public class Cliente {
    private String dni;
    private String nombre;
    private CuentaBancaria cuenta;

    public Cliente(String dni, String nombre, CuentaBancaria cuenta) {
        this.dni = dni;
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " (DNI: " + dni + ") - " + cuenta.toString();
    }
}