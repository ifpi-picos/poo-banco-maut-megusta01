package br.edu.ifpi.poo.entidades;
import br.edu.ifpi.poo.notificacoes.NotificacaoEmail;

public class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int numSaques;

    public ContaCorrente(String numConta, String numAgencia, Cliente cliente, NotificacaoEmail notificacao, double chequeEspecial) {
        super(numConta, numAgencia, cliente, notificacao);
        this.chequeEspecial = chequeEspecial;
        this.numSaques = 0;
    }

    public double getChequeEspecial() {
        return super.getSaldo() + this.chequeEspecial;
    }

    public static double getSaldoCorrente() {
        return saldo;
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
            if (valor <= super.getSaldo() + chequeEspecial) {
                super.setSaldo(super.getSaldo() - valor);
                getTransacao().add(new Transacao("Saque", valor));
                return true;
            } else {
                notificacao.enviarNotificacao("Saldo insuficiente", 0);
                return false;
            }
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque!");
            System.out.println("Não foi possível realizar o saque!");
            return false;
        }
    }

    public void exibirExtrato() {
        for (Transacao conta : transacao) {
            System.out.println("- Tipo: " + conta.getDescricao());
            System.out.println("- Valor: R$" + conta.getValor());
            System.out.println("- Data: " + conta.getData());
            System.out.println("================================");
            System.out.println("Saldo atual: R$" + saldo);
        }
    }
}