package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Desafio {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cliente cliente = criarCliente();
        mostrarMenu(cliente);
    }

    private static Cliente criarCliente() {
        System.out.println("\n===== BANCO DEVS =====");
        System.out.println("\n**** Digite seus Dados ****");

        String nome = lerString("Entre com seu Nome: ");
        double cpf = lerCpf();
        double saldo = lerDouble("Digite o Saldo da conta: ");

        Conta conta = new Conta("CORRENTE", saldo);
        return new Cliente(nome, cpf, conta);
    }

    private static double lerCpf() {
        while (true) {
            try {
                return lerDouble("Digite seu CPF: ");
            } catch (InputMismatchException e) {
                System.out.println("CPF inválido. Digite um valor numérico.");
                scanner.next(); // Limpa o buffer
            }
        }
    }

    private static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um valor numérico.");
                scanner.next(); // Limpa o buffer
            }
        }
    }

    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static void mostrarMenu(Cliente cliente) {
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

        int opcaoDesejada = 0;

        while (opcaoDesejada != 4) {
            System.out.println("\n    ******* BANCO DEVS *******");
            System.out.println(menu);
            opcaoDesejada = lerInt("Digite sua opção: ");

            switch (opcaoDesejada) {
                case 1:
                    consultarSaldo(cliente);
                    break;
                case 2:
                    transferirValor(cliente);
                    break;
                case 3:
                    receberValor(cliente);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static int lerInt(String mensagem) {
        System.out.print(mensagem);
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um valor numérico.");
                scanner.next(); // Limpa o buffer
            }
        }
    }

    private static void consultarSaldo(Cliente cliente) {
        double saldo = cliente.getConta().getSaldo();
        System.out.println("Saldo do cliente: R$:" + saldo);
    }

    private static void transferirValor(Cliente cliente) {
        double valor = lerDouble("Qual valor deseja transferir: ");
        cliente.getConta().transferir(valor);
        consultarSaldo(cliente); // Exibe saldo atualizado após a transferência
    }

    private static void receberValor(Cliente cliente) {
        double valor = lerDouble("Qual valor deseja receber: ");
        cliente.getConta().receber(valor);
        consultarSaldo(cliente); // Exibe saldo atualizado após o recebimento
    }
}
