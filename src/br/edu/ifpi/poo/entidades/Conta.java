package br.edu.ifpi.poo.entidades;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifpi.poo.notificacoes.Notificacao;

public abstract class Conta {
    private final String numConta;
    private final String numAgencia;
    protected double saldo; // NÃO pode ser estático
    private Cliente cliente;
    // atributos estáticos são atribudos de classe e não do objeto, NÃO USE!
    protected static List<Transacao> transacao; // não deveria ser estático
    protected Notificacao notificacao;

    public Conta(String numConta, String numAgencia, Cliente cliente, Notificacao notificacao) {
        this.numConta = numConta;
        this.numAgencia = numAgencia;
        this.cliente = cliente;
        this.transacao = new ArrayList<>();
        this.notificacao = notificacao;
    }

    public String getNumAgencia() {
        return numAgencia;
    }

    public String getNumConta() {
        return numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Transacao> getTransacao() {
        return transacao;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            transacao.add(new Transacao("Deposito", valor));
            notificacao.enviarNotificacao("Deposito", valor);
            System.out.println("Deposito realizado com sucesso !!");
            return true;
        }
        System.out.println("Não foi possivel realizar o deposito.");
        return false;
    }

    public abstract boolean sacar(double valor);

    public boolean transferir(Conta destino, double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            destino.saldo += valor;
            transacao.add(new Transacao("Transferencia", valor));
            notificacao.enviarNotificacao("Transferencia", valor);
            destino.getTransacao().add(new Transacao("Recibo transferencia", valor));
            return true;
        } else {
            System.err.println("Valor insuficiente para a transferência!");
            return false;
        }
    }

    public void exibirExtrato() {
        for (Transacao conta : transacao) {
            System.out.println("- Tipo: " + conta.getDescricao());
            System.out.println("- Valor: R$" + conta.getValor());
            System.out.println("- Data: " + conta.getData());
            System.out.println("================================");
        }
        System.out.println("Saldo atual: R$" + saldo);
    }


    // public void exibirExtrato() {
    // System.out.println("Extrato da Conta Corrente:");
    // for (Transacao conta : ContaCorrente.transacao) {
    // System.out.println("- Tipo: " + conta.getDescricao());
    // System.out.println("- Valor: R$" + conta.getValor());
    // System.out.println("- Data: " + conta.getData());
    // System.out.println("================================");
    // }

    // System.out.println("Extrato da Conta Poupança:");
    // for (Transacao conta : ContaPoupanca.transacao) {
    // System.out.println("- Tipo: " + conta.getDescricao());
    // System.out.println("- Valor: R$" + conta.getValor());
    // System.out.println("- Data: " + conta.getData());
    // System.out.println("================================");
    // }

    // System.out.println("Saldo atual da Conta Corrente: R$" + ContaCorrente.getSaldoCorrente());
    // System.out.println("Saldo atual da Conta Poupança: R$" + ContaPoupanca.getSaldoPoupanca());
    // }
}
