package org.example;

public class Conta {
    private String tipoConta;
    private double saldo;

    public Conta(String tipoConta, double saldo) {
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void transferir(double valor) {
        if (valor > saldo) {
            System.out.println("Não possui saldo suficiente para realizar a transferência.");
        } else {
            saldo -= valor;
            System.out.println("Transferência realizada com sucesso.");
        }
    }

    public void receber(double valor) {
        saldo += valor;
        System.out.println("Recebimento realizado com sucesso.");
    }
}
