import java.sql.SQLOutput;
import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nome = "Henrique";
        String tipoConta = "Corrente";
        double saldo = 2500.00;
        int opcaoDesejada = 0;


        System.out.print("***********************");
        System.out.print("\nNome do Cliente: " + nome);
        System.out.print("\nTipo de Conta: " + tipoConta);
        System.out.println("\nSaldo do Cliente: " + "R$"+ saldo);

        String menu = """
                 *********************************
                 ┌──────────────────────────────┐
                 │    ** Digite sua opção **    │
                 ├──────────────────────────────┤
                 │  1 - Consultar saldo         │
                 │  2 - Transferir valor        │
                 │  3 - Receber valor           │
                 │  4 - Sair                    │
                 └──────────────────────────────┘
                *********************************
                """;

        while (opcaoDesejada != 4) {
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
