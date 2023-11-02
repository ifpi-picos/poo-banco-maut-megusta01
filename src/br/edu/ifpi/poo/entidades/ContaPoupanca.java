package br.edu.ifpi.poo.entidades;

import br.edu.ifpi.poo.notificacoes.NotificacaoSMS;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numConta, String numAgencia, Cliente cliente, double taxaRendimento,
            NotificacaoSMS notificacao) {
        super(numConta, numAgencia, cliente, notificacao);
    }

    public static double getSaldoPoupanca() {
        return saldo;
    }

    @Override
    public boolean depositar(double valor) {
        if (valor > 0) {
            double taxaDeposito = valor * 0.1; // Correção da fórmula
            super.saldo += (valor + taxaDeposito); // Adicionar a taxa ao saldo
            getTransacao().add(new Transacao("Deposito", valor));
            return true;
        } else {
            System.err.println("Valor inválido para depósito!");
            return false;
        }
    }

    @Override
    public boolean sacar(double valor) {
        // formula incorreta, dessa forma ta descontado so o valor da taxa, pra somar o valor + taxa
        // deve refazer o calculo conforme abaixo
        double valorTaxado = valor + (valor * 0.05); // Correção da fórmula
        if (valorTaxado > 0 && valorTaxado <= super.saldo) {
            super.saldo -= valorTaxado;
            getNotificacao().enviarNotificacao("Saque", valor);
            getTransacao().add(new Transacao("Saque", valor));
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque!");
            System.out.println("Não foi possível realizar o saque!");
            return false;
        }
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        double valorTaxado = valor * 0.1; // Correção da fórmula
        if (valorTaxado <= super.saldo) {
            super.saldo -= valorTaxado;
            destino.saldo += valor;
            getNotificacao().enviarNotificacao("Transferência", valor);
            getTransacao().add(new Transacao("Transferência", valorTaxado));
            destino.getTransacao().add(new Transacao("Recibo transferência ", valor));
            return true;
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência!");
            System.out.println("Não foi possível realizar a transferência!");
            return false;
        }
    }

    /*
     * public void exibirExtrato() { for (Transacao conta : transacao) {
     * System.out.println("- Tipo: " + conta.getDescricao()); System.out.println("- Valor: R$" +
     * conta.getValor()); System.out.println("- Data: " + conta.getData());
     * System.out.println("================================"); System.out.println("Saldo atual: R$"
     * + saldo); } }
     */
}

