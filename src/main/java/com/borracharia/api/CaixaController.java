package com.borracharia.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CaixaController {

    @Autowired
    private MovimentacaoRepository repository;

    @GetMapping("/caixa/saldo")
    public String verSaldo() {
        List<Movimentacao> movimentacoes = repository.findAll();

        double saldo = 0.0;
        for (Movimentacao m : movimentacoes) {
            if (m.getTipo().equals("ENTRADA")) {
                saldo += m.getValor();
            } else if (m.getTipo().equals("SAIDA")) {
                saldo -= m.getValor();
            }
        }

        return String.format("Saldo Atual no Banco de Dados: R$ %.2f | Total de Operações: %d",
                saldo, movimentacoes.size());
    }

    @GetMapping("/caixa/entrada")
    public String entrada(@RequestParam double valor) {
        if (valor <= 0) {
            return "Erro: O valor deve ser maior que zero.";
        }

        Movimentacao novaEntrada = new Movimentacao("ENTRADA", valor);
        repository.save(novaEntrada);

        return String.format("Sucesso! Entrada de R$ %.2f registrada no Banco de Dados.", valor);
    }

    @GetMapping("/caixa/saida")
    public String saida(@RequestParam double valor) {
        if (valor <= 0) {
            return "Erro: O valor do saque deve ser maior que zero.";
        }

        List<Movimentacao> movimentacoes = repository.findAll();
        double saldoAtual = 0.0;
        for (Movimentacao m : movimentacoes) {
            if (m.getTipo().equals("ENTRADA")) {
                saldoAtual += m.getValor();
            } else if (m.getTipo().equals("SAIDA")) {
                saldoAtual -= m.getValor();
            }
        }

        if (valor > saldoAtual) {
            return String.format("Erro: Saldo insuficiente. Saldo atual no banco: R$ %.2f", saldoAtual);
        }

        Movimentacao novaSaida = new Movimentacao("SAIDA", valor);
        repository.save(novaSaida);

        return String.format("Sucesso! Saída de R$ %.2f registrada no Banco de Dados.", valor);
    }

    @GetMapping("/caixa/extrato")
    public List<Movimentacao> verExtrato() {
        return repository.findAll();
    }
}