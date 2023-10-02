public class BancoMaut {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João da Silva", "123.456.789-00", "01/01/1990", "Rua A, 123");
        Cliente cliente2 = new Cliente("Maria dos Santos", "987.654.321-00", "05/05/1985", "Av. B, 456");

        Conta conta1 = new Conta(1, cliente1);
        Conta conta2 = new Conta(2, cliente1);
        Conta conta3 = new Conta(1, cliente2);

        conta1.depositar(1000.0);
        conta1.sacar(200.0);

        conta2.depositar(500.0);
        conta2.transferir(conta3, 300.0);

        System.out.println("Saldo da conta 1: R$" + conta1.getSaldo());
        System.out.println("Saldo da conta 2: R$" + conta2.getSaldo());
        System.out.println("Saldo da conta 3: R$" + conta3.getSaldo());
    }
}