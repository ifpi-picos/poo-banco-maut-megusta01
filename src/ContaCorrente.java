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

    @Override
    public void sacar(double saque) {
        if (saque > 0) {
            if (saque <= getSaldo()) {
                setSaldo(getSaldo() - saque);
                getTransacao().add(new Transacao("Saque", saque));
                notificacao.enviarNotificacao("Saque", saque);
            } else if (saque <= (getSaldo() + chequeEspecial)) {
                double saldo = getSaldo();
                setSaldo(0);
                chequeEspecial -= (saque - saldo);
                getTransacao().add(new Transacao("Saque", saque));
                notificacao.enviarNotificacao("Saque", saque);
            } else {
                System.out.println("Saldo insuficiente");
            }
        } else {
            System.out.println("Saque inválido");
        }
    }
}