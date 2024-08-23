import java.util.InputMismatchException;
import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nome;
        double cpf = 0;
        boolean cpfValido = false;
        String tipoConta = "CORRENTE";
        double saldo;
        int opcaoDesejada = 0;

        System.out.println("\n===== BANCO DEVS =====");
        System.out.println("\n**** Digite seus Dados ****");
        System.out.print("\nEntre com seu Nome: ");
        nome = scanner.nextLine();


        while (!cpfValido) {
            System.out.print("Digite seu CPF: ");
            try {
                cpf = scanner.nextDouble();
                cpfValido = true;
            } catch (InputMismatchException e) {
                System.out.println("CPF inválido. Digite um valor numérico.");
                scanner.next();
            }
        }

        System.out.println("Tipo de Conta: " + tipoConta);
        System.out.print("Digite o Saldo da conta: ");
        saldo = scanner.nextDouble();
        System.out.println("\nSaldo do Cliente: " + "R$:" + saldo);

        String menu = """
                *********************************
                ┌──────────────────────────────┐
                │   *** Digite sua opção ***   │
                ├──────────────────────────────┤
                │  1 - Consultar saldo         │
                │  2 - Transferir valor        │
                │  3 - Receber valor           │
                │  4 - Sair                    │
                └──────────────────────────────┘
                *********************************
                """;

        while (opcaoDesejada != 4) {
            System.out.println("\n    ******* BANCO DEVS *******");
            System.out.println(menu);
            opcaoDesejada = scanner.nextInt();


            if (opcaoDesejada == 1) {
            System.out.println("Saldo do cliente: " + "R$:"+ saldo);
            } else if (opcaoDesejada == 2) {
                System.out.println("Qual valor deseja transferir: ");
                double valorTransferencia = scanner.nextDouble();
                if(valorTransferencia > saldo){
                    System.out.println("Não possui saldo para realizar a transferencia.");
                } else {
                    saldo -= valorTransferencia;
                    System.out.println("\nSaldo atual: " + "R$:"+ saldo);
                }
            } else if (opcaoDesejada == 3) {
                System.out.println("Qual valor deseja receber:  ");
                double valorReceber = scanner.nextDouble();
                saldo += valorReceber;
                System.out.println("\nSaldo atual: " + "R$:"+ saldo);
            } else if (opcaoDesejada != 4) {
                System.out.println("Opção inválida!");
            }
        }
    }
}
