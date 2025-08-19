import java.util.Scanner;
public class SistemaBancario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Cliente cliente = new Cliente("12345678", "Juan Perez", 1001);

        System.out.println("===== BIENVENIDO AL SISTEMA BANCARIO =====");
        System.out.print("Ingrese su DNI: ");
        String dni = sc.nextLine();

        if (!dni.equals(cliente.getDni())) {
            System.out.println("DNI incorrecto. Acceso denegado.");
            return;
        }

        System.out.println("Bienvenido, " + cliente.getNombre());

        int opcion;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Depositar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Consultar saldo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese monto a depositar: ");
                    double deposito = sc.nextDouble();
                    cliente.getCuenta().depositar(deposito);
                    break;
                case 2:
                    System.out.print("Ingrese monto a retirar: ");
                    double retiro = sc.nextDouble();
                    cliente.getCuenta().retirar(retiro);
                    break;
                case 3:
                    cliente.getCuenta().consultarSaldo();
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}