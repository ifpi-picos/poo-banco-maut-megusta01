import java.util.ArrayList;
import java.util.List;

class Conta {
    private static int proximoNumeroConta = 1;
    private final int numeroAgencia;
    private final int numeroConta;
    private double saldo;
    private final Cliente cliente;
    private List<String> extrato;

    public Conta(int numeroAgencia, Cliente cliente) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = proximoNumeroConta++;
        this.saldo = 0.0;
        this.cliente = cliente;
        this.cliente.adicionarConta(this);
        this.extrato = new ArrayList<>();
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<String> getExtrato() {
        return extrato;
    }

    public void depositar(double valor) {
        saldo += valor;
        extrato.add("Depósito de R$" + valor);
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            extrato.add("Saque de R$" + valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void transferir(Conta contaDestino, double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            contaDestino.depositar(valor);
            extrato.add("Transferência de R$" + valor + " para conta " + contaDestino.getNumeroConta());
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }
}