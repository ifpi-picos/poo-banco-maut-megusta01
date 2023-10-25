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

        Conta conta1 = new ContaCorrente("001", "0254-2", cliente1, new NotificacaoEmail());
        Conta conta2 = new ContaPoupanca("002", "0254-2", cliente2, 0.05, new NotificacaoSMS());

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
                    System.out.println("Digite o valor do saque:");
                    double valorSaque = scanner.nextDouble();
                    if (conta1.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Não foi possível realizar o saque!");
                    }
                    break;
                case 2:
                    System.out.println("Digite o valor do depósito:");
                    double valorDeposito = scanner.nextDouble();
                    if (conta1.depositar(valorDeposito)) {
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Não foi possível realizar o depósito!");
                    }
                    break;
                case 3:
                    System.out.println("Digite o valor da transferência:");
                    double valorTransferencia = scanner.nextDouble();
                    if (conta1.transferir(conta2, valorTransferencia)) {
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Não foi possível realizar a transferência!");
                    }
                    break;
                case 4:
                    conta1.exibirExtrato();
                    conta2.exibirExtrato();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        System.out.println("Programa encerrado.");
    }
}