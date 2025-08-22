package models;

public abstract class CuentaBancaria {
    protected int numeroCuenta;
    protected double saldo;

    public CuentaBancaria(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0.0;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Deposito exitoso. Su saldo: " + saldo);
        } else {
            System.out.println("Monto invalido");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo actual: " + saldo);
    }
    //Metodo abstracto
    public abstract boolean puedeRetirar(double monto);

    public void retirar(double monto) {
        if (monto > 0 && puedeRetirar(monto)) {
            saldo -= monto;
            System.out.println("Retiro exitoso. Saldo: " + saldo);
            mostrarEstadoCuenta();
        } else {
            System.out.println("No se puede realizar el retiro, saldo insuficiente");
        }
    }
    //Metodo abstracto
    public abstract void mostrarEstadoCuenta();

    @Override
    public String toString() {
        return "Numero: " + numeroCuenta + ", Saldo: " + saldo;
    }
}