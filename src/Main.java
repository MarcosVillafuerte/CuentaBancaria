import service.Banco;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();
        boolean salir = false;

        System.out.println("Bienvenido al Sistema Bancario");

        while (!salir) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Mostrar clientes");
            System.out.println("6. Reporte completo");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("Tipo cuenta: 1=Ahorro, 2=Corriente");
                    int tipo = sc.nextInt();
                    sc.nextLine();
                    banco.registrarCliente(dni, nombre, tipo);
                    break;

                case 2:
                    System.out.print("DNI: ");
                    String dniDep = sc.nextLine();
                    System.out.print("Monto a depositar: ");
                    double montoDep = sc.nextDouble();
                    sc.nextLine();
                    banco.realizarDeposito(dniDep, montoDep);
                    break;

                case 3:
                    System.out.print("DNI: ");
                    String dniRet = sc.nextLine();
                    System.out.print("Monto a retirar: ");
                    double montoRet = sc.nextDouble();
                    sc.nextLine();
                    banco.realizarRetiro(dniRet, montoRet);
                    break;

                case 4:
                    System.out.print("DNI: ");
                    String dniCon = sc.nextLine();
                    banco.consultarSaldo(dniCon);
                    break;

                case 5:
                    banco.mostrarClientes();
                    break;

                case 6:
                    System.out.println("Reporte completo:");
                    List<String> reporte = banco.generarReporte();
                    for (String linea : reporte) {
                        System.out.println(linea);
                    }
                    break;

                case 7:
                    salir = true;
                    System.out.println("Gracias por usar el sistema");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }

        sc.close();
    }
}