package models;

public class CuentaCorriente extends CuentaBancaria {

    public CuentaCorriente(int numeroCuenta) {
        super(numeroCuenta);
    }

    @Override
    public boolean puedeRetirar(double monto) {
        return (saldo - monto) >= -100.0;
    }

    @Override
    public void mostrarEstadoCuenta() {
        if (saldo < 0) {
            System.out.println("Cuenta en sobregiro");
        }
    }

    @Override
    public String toString() {
        return "Cuenta Corriente - " + super.toString();
    }
}