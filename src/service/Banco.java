package service;

import models.*;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes;
    private int numeroSiguiente;

    public Banco() {
        clientes = new ArrayList<>();
        numeroSiguiente = 1000;
    }

    public void registrarCliente(String dni, String nombre, int tipoCuenta) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                System.out.println("Cliente ya existe");
                return;
            }
        }

        CuentaBancaria cuenta;
        if (tipoCuenta == 1) {
            cuenta = new CuentaAhorro(numeroSiguiente);
        } else {
            cuenta = new CuentaCorriente(numeroSiguiente);
        }
        numeroSiguiente++;

        Cliente nuevoCliente = new Cliente(dni, nombre, cuenta);
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado: " + nuevoCliente);
    }

    public Cliente buscarCliente(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    public void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes");
            return;
        }

        System.out.println("Lista de clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
    //Verifica si el cliente existe para realizar la accion
    public void realizarDeposito(String dni, double monto) {
        Cliente cliente = buscarCliente(dni);
        if (cliente != null) {
            cliente.getCuenta().depositar(monto);
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    public void realizarRetiro(String dni, double monto) {
        Cliente cliente = buscarCliente(dni);
        if (cliente != null) {
            cliente.getCuenta().retirar(monto);
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    public void consultarSaldo(String dni) {
        Cliente cliente = buscarCliente(dni);
        if (cliente != null) {
            cliente.getCuenta().consultarSaldo();
        } else {
            System.out.println("Cliente no encontrado");
        }
    }


    //Muestra lo mismo que el ver clientes (mejorar)
    public List<String> generarReporte() {
        List<String> reporte = new ArrayList<>();
        for (Cliente cliente : clientes) {
            reporte.add(cliente.toString());
        }
        return reporte;
    }
}