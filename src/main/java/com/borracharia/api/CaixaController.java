package com.borracharia.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CaixaController {

    private Caixa meuCaixa = new Caixa();

    @GetMapping("/caixa/saldo")
    public String verSaldo() {
        return String.format("Saldo Atual: R$ %.2f | Total de Operações: %d",
                meuCaixa.getSaldo(), meuCaixa.getTotalOperacoes());
    }

    @GetMapping("/caixa/entrada")
    public String entrada(@RequestParam double valor) {
        if (valor <= 0) {
            return "Erro: O valor deve ser maior que zero.";
        }
        meuCaixa.registrarEntrada(valor);
        return String.format("Sucesso! Entrada de R$ %.2f registrada.", valor);
    }

    @GetMapping("/caixa/saida")
    public String saida(@RequestParam double valor) {
        if (valor <= 0) {
            return "Erro: O valor do saque deve ser maior que zero.";
        }

        boolean sucesso = meuCaixa.registrarSaida(valor);

        if (sucesso) {
            return String.format("Sucesso! Saída de R$ %.2f realizada.", valor);
        } else {
            return String.format("Erro: Saldo insuficiente para realizar a saída de R$ %.2f. Saldo atual: R$ %.2f",
                    valor, meuCaixa.getSaldo());
        }
    }

    @GetMapping("/caixa/extrato")
    public List<String> verExtrato() {
        return meuCaixa.getHistorico();
    }
}