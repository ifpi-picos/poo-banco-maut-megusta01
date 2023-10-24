package br.edu.ifpi.poo.entidades;
import br.edu.ifpi.poo.notificacoes.Notificacao;

public class ContaCorrente extends Conta {
    private double chequeEspecial;

    public ContaCorrente(String numConta, String numAgencia, double saldo, Cliente cliente, double chequeEspecial, Notificacao notificacao) {
        super(numConta, numAgencia, saldo, cliente, notificacao);
        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
}