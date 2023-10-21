import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", "123456789-00", LocalDate.of(2000, 1, 1), new Endereco("Rua 1", "123", "Bairro 1", "Cidade 1", "UF 1", "12345-678"));
        ContaCorrente contaCorrente = new ContaCorrente("123456-7", "1234-5", 1000.0, cliente, 500.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca("123456-7", "1234-5", 1000.0, cliente, 0.5);
        contaCorrente.depositar(100.0);
        contaCorrente.sacar(200.0);
        contaCorrente.transferir(contaPoupanca, 100.0);
        contaPoupanca.calcularRendimento();
        System.out.println("Saldo da conta corrente: " + contaCorrente.getSaldo());
        System.out.println("Saldo da conta poupança: " + contaPoupanca.getSaldo());
    }    
}
