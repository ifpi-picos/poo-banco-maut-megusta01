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
    protected Notificacao notificacao;

    public Conta(String numConta, String numAgencia, Cliente cliente, Notificacao notificacao) {
        this.numConta = numConta;
        this.numAgencia = numAgencia;
        this.saldo = saldo;
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

    public abstract boolean transferir(Conta destino, double valor);  

    public void exibirExtrato() {
        System.out.println("\n***** Extrato de Transacoes da conta " + getNumConta() + " *****");
        for (Transacao conta : transacao) {
            System.out.println(
                    "Tipo ->" + conta.getDescricao() +
                            "\nValor -> R$" + conta.getValor() +
                            "\nData ->" + conta.getData());
            System.out.println("\n************");
        }
    }
}