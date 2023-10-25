package br.edu.ifpi.poo.entidades;
import br.edu.ifpi.poo.notificacoes.Notificacao;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numConta, String numAgencia, Cliente cliente, double taxaRendimento, Notificacao notificacao) {
        super(numConta, numAgencia, cliente, notificacao);
    }

    @Override
    public boolean depositar(double valor) {
        if (valor > 0) {
            double taxaDeposito = valor +(valor * 0.1);
            super.saldo += taxaDeposito;
            getTransacao().add(new Transacao("Deposito", valor));
            return true;
        } else {
            System.err.println("Valor inválido para depósito!");
            return false;
        }
    }

    @Override
    public boolean sacar(double valor) {
        double valorTaxado = valor + (valor * 0.05);
        if (valorTaxado > 0 && valorTaxado <= super.saldo) {
            super.saldo -= valorTaxado;
            getNotificacao().enviarNotificacao("Saque", valor);
            getTransacao().add(new Transacao("Saque", valor));
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor invalido para saque !!");
            System.out.println("Nao foi possivel realizar o saque !!");
            return false;
        }
    }

    @Override
    public boolean transferir(Conta destino, double valor){
        double valorTaxado = valor + (valor * 0.1);
        if (valorTaxado < super.saldo) {
            super.saldo -= valorTaxado;
            destino.saldo += valor;
            getNotificacao().enviarNotificacao("Transferencia", valor);
            getTransacao().add(new Transacao("Transferencia", valorTaxado));
            destino.saldo += valor;
            destino.getTransacao().add(new Transacao("Recibo transferencia ", valor));
            return true;
        } else if (valor < saldo) {
            System.out.println("Saldo insuficiente para realizar a transferencia !!");
        }
        System.out.println("Nao foi possivel realizar a transferencia !! ");
        return false;
    }
}
