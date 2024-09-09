package org.example;

public class Cliente {
    private String nome;
    private double cpf;
    private Conta conta;

    public Cliente(String nome, double cpf, Conta conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public double getCpf() {
        return cpf;
    }

    public Conta getConta() {
        return conta;
    }
}
