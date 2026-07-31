package com.borracharia.api;

import java.util.ArrayList;
import java.util.List;

public class Caixa {
    private double saldo;
    private int totalOperacoes;
    private List<String> historico;

    public Caixa() {
        this.saldo = 0.0;
        this.totalOperacoes = 0;
        this.historico = new ArrayList<>();
    }

    public void registrarEntrada(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            this.totalOperacoes++;
            this.historico.add(String.format("Entrada: +R$ %.2f", valor));
        }
    }

    public boolean registrarSaida(double valor) {
        if (valor > this.saldo) {
            return false;
        } else {
            this.saldo -= valor;
            this.totalOperacoes++;
            this.historico.add(String.format("Saída: -R$ %.2f", valor));
            return true;
        }
    }

    public double getSaldo() { return this.saldo; }
    public int getTotalOperacoes() { return this.totalOperacoes; }
    public List<String> getHistorico() { return this.historico; }
}