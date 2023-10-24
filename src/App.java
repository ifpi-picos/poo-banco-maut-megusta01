import br.edu.ifpi.poo.entidades.Cliente;
import br.edu.ifpi.poo.entidades.Conta;
import br.edu.ifpi.poo.entidades.ContaCorrente;
import br.edu.ifpi.poo.entidades.ContaPoupanca;
import br.edu.ifpi.poo.entidades.Endereco;
import br.edu.ifpi.poo.entidades.Transacao;
import br.edu.ifpi.poo.notificacoes.NotificacaoEmail;
import br.edu.ifpi.poo.notificacoes.NotificacaoSMS;
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cliente cliente1 = new Cliente("Gustavo", "04088791304", LocalDate.of(2003, 2, 11), new Endereco("Rua Jasmim", 43, "Bairro Louzinho Monteiro", "64601-615", "Picos", "PI"));
        Cliente cliente2 = new Cliente("Katelyn", "04076256310", LocalDate.of(2005, 11, 13), new Endereco("Rua da Cruz", 220, "Aerolândia", "64600-000", "Picos", "PI"));

        Conta conta1 = new ContaCorrente("001", "0254-2", 1000.0, cliente1, 500.0, new NotificacaoEmail());
        Conta conta2 = new ContaPoupanca("002", "0254-2", 2000.0, cliente2, 2.0, new NotificacaoSMS());

        boolean sair = false;

        while (!sair) {
            System.out.println("========================");
            System.out.println("\nEscolha a operação:");
            System.out.println("1. Saque");
            System.out.println("2. Depósito");
            System.out.println("3. Transferência");
            System.out.println("4. Imprimir Extrato");
            System.out.println("5. Sair do Programa");
            System.out.println("========================");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    realizarSaque(scanner, conta1);
                    break;
                case 2:
                    realizarDeposito(scanner, conta1);
                    break;
                case 3:
                    realizarTransferencia(scanner, conta1, conta2);
                    break;
                case 4:
                    imprimirExtrato(conta1);
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }

        System.out.println("Programa encerrado.");
    }

    private static void realizarSaque(Scanner scanner, Conta conta) {
        System.out.println("Digite o valor do saque: ");
        double valor = scanner.nextDouble();
        conta.sacar(valor);
    }

    private static void realizarDeposito(Scanner scanner, Conta conta) {
        System.out.println("Digite o valor do depósito: ");
        double valor = scanner.nextDouble();
        conta.depositar(valor);
    }

    private static void realizarTransferencia(Scanner scanner, Conta origem, Conta destino) {
        System.out.println("Digite o valor da transferência: ");
        double valor = scanner.nextDouble();
        origem.transferir(destino, valor);
    }

    private static void imprimirExtrato(Conta conta) {
        System.out.println("Extrato da Conta:");
        System.out.println("=================================================");
        System.out.println("Nome do Cliente: " + conta.getCliente().getNome());
        System.out.println("Número da Conta: " + conta.getNumConta());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Transações:");
        for (Transacao transacao : conta.getTransacao()) {
            System.out.println(transacao);
        }
    }
}
