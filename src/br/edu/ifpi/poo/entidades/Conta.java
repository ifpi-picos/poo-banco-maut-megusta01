package br.edu.ifpi.poo.entidades;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifpi.poo.notificacoes.Notificacao;

public abstract class Conta {
    private final String numConta;
    private final String numAgencia;
    protected double saldo;
    private Cliente cliente;
    private List<Transacao> transacao;
    private Notificacao notificacao;

    public Conta(String numConta, String numAgencia, double abertura, Cliente cliente, Notificacao notificacao) {
        this.numConta = numConta;
        this.numAgencia = numAgencia;
        this.saldo = abertura;
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

    public void setSaldo(double saldo){
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

    public void depositar(double deposito) {
        if (deposito > 0) {
            setSaldo(getSaldo() + deposito);
        } else {
            System.out.println("Depósito inválido");
        }
    }

    public void sacar(double saque) {
        if (saque > 0) {
            if (saque <= getSaldo()) {
                setSaldo(getSaldo() - saque);
                getTransacao().add(new Transacao("Saque", saque));
                notificacao.enviarNotificacao("Saque", saque);
            } else {
                System.out.println("Saldo insuficiente");
            }
        } else {
            System.out.println("Saque inválido");
        }
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public void transferir(Conta destino, double valor) {
        if (valor > 0) {
            if (valor <= getSaldo()) {
                setSaldo(getSaldo() - valor);
                destino.setSaldo(destino.getSaldo() + valor);
                getTransacao().add(new Transacao("Transferência", valor));
                notificacao.enviarNotificacao("Transferência", valor);
            } else {
                System.out.println("Saldo insuficiente");
            }
        } else {
            System.out.println("Valor inválido");
        }
    }
}