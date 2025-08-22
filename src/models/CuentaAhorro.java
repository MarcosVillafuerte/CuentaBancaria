package models;

public class CuentaAhorro extends CuentaBancaria {

    public CuentaAhorro(int numeroCuenta) {
        super(numeroCuenta);
    }

    @Override
    public boolean puedeRetirar(double monto) {
        return monto <= saldo;
    }

    @Override
    public void mostrarEstadoCuenta() {
    }

    @Override
    public String toString() {
        return "Cuenta Ahorro - " + super.toString();
    }
}