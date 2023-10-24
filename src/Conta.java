import java.util.ArrayList;
import java.util.List;

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

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }
}
