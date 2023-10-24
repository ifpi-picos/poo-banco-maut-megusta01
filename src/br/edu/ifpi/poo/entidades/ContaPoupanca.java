package br.edu.ifpi.poo.entidades;
import br.edu.ifpi.poo.notificacoes.Notificacao;

public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(String numConta, String numAgencia, double saldo, Cliente cliente, double taxaRendimento, Notificacao notificacao) {
        super(numConta, numAgencia, saldo, cliente, notificacao);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void calcularRendimento() {
        double rendimento = getSaldo() * (taxaRendimento / 100.0);
        depositar(rendimento);
    }
}