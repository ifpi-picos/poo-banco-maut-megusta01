public class ContaCorrente extends Conta {
    private double chequeEspecial;

    public ContaCorrente(String numConta, String numAgencia, double saldo, Cliente cliente, double chequeEspecial) {
        super(numConta, numAgencia, saldo, cliente);
        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public void sacar(double saque) {
        if (saque > 0 && getSaldo() >= saque) {
            setSaldo(getSaldo() - saque);
        } else {
            System.out.println("Saque inválido");
        }
    }

    public void transferir(ContaCorrente destino, double transferencia) {
        if (transferencia > 0 && getSaldo() >= transferencia) {
            setSaldo(getSaldo() - transferencia);
            destino.depositar(transferencia);
        } else {
            System.out.println("Transferência inválida");
        }
    }
}