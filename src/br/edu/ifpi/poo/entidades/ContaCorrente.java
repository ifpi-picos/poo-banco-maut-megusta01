package br.edu.ifpi.poo.entidades;
import br.edu.ifpi.poo.notificacoes.Notificacao;

public class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int numSaques;

    public ContaCorrente(String numConta, String numAgencia, Cliente cliente, Notificacao notificacao) {
        super(numConta, numAgencia, cliente, notificacao);
        this.chequeEspecial = 1000;
        this.numSaques = 1;
    }

    public double getChequeEspecial() {
        return super.saldo + this.chequeEspecial;
    }

    public double getSaldoCorrente() {
        return super.saldo;
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        if (valor > 0 && valor <= getChequeEspecial()) {
            if (numSaques > 2) {
                double taxaTrans = (valor * 0.1);
                super.saldo -= (valor + taxaTrans);
                destino.saldo += valor;
                getNotificacao().enviarNotificacao("Transferencia", valor);
                System.out.println("Transferencia realizada com sucesso !!\n");
                getTransacao().add(new Transacao("Transferencia", valor));
                destino.getTransacao().add(new Transacao("Recibo transferencia", valor));
                ++numSaques;
                return true;
            } else {
                super.saldo -= valor;
                destino.saldo += valor;
                getNotificacao().enviarNotificacao("Transferencia", valor);
                numSaques++;
                System.out.println("Transferencia realizada com sucesso !!\n");
                getTransacao().add(new Transacao("Transferencia", valor));
                destino.getTransacao().add(new Transacao("Recibo transferencia", valor));
                return true;
            }
        } else {
            System.err.println("Valor insuficiente para a transferência!");
            return false;
        }

    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0) {
            if (valor <= getSaldo() + chequeEspecial) {
                setSaldo(getSaldo() - valor);
                getTransacao().add(new Transacao("Saque", valor));
                return true;
            } else {
                notificacao.enviarNotificacao("Saldo insuficiente", 0);
                return false;
            }
        } else {
            notificacao.enviarNotificacao("Valor inválido", 0);
            return false;
        }
    }
}