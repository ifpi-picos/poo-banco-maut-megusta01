import br.edu.ifpi.poo.entidades.Cliente;
import br.edu.ifpi.poo.entidades.Conta;
import br.edu.ifpi.poo.entidades.ContaCorrente;
import br.edu.ifpi.poo.entidades.ContaPoupanca;
import br.edu.ifpi.poo.entidades.Endereco;
import br.edu.ifpi.poo.notificacoes.NotificacaoEmail;
import br.edu.ifpi.poo.notificacoes.NotificacaoSMS;
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cliente cliente1 = new Cliente("Gustavo", "04088791304", LocalDate.of(2003, 2, 11), new Endereco("Rua Jasmim", 43, "Bairro Louzinho Monteiro", "64601-615", "Picos", "PI"));
        Cliente cliente2 = new Cliente("Katelyn", "04076256310", LocalDate.of(2005, 11, 13), new Endereco("Rua da Cruz", 220, "Aerolândia", "64600-000", "Picos", "PI"));

        Conta conta1 = new ContaCorrente("001", "0254-2", cliente1, new NotificacaoEmail(), 1000);
        Conta conta2 = new ContaPoupanca("002", "0254-2", cliente2, 0.05, new NotificacaoSMS());
        
        System.out.println("================================");
        System.out.println("===== Bem-vindo ao Banco! ======");
        System.out.println("================================");
        System.out.println("=== Dados da conta corrente ====");
        System.out.println("Nome: " + conta1.getCliente().getNome());
        System.out.println("Numero da conta: " + conta1.getNumConta());
        System.out.println("Numero da agencia: " + conta1.getNumAgencia());
        System.out.println("CPF: " + conta1.getCliente().getCpf());
        System.out.println("Data de nascimento: " + conta1.getCliente().getDataNasc());
        System.out.println("================================");
        System.out.println("===== Endereco do Cliente ======");
        System.out.println("Rua: " + conta1.getCliente().getEndereco().getRua());
        System.out.println("Número: " + conta1.getCliente().getEndereco().getNumero());
        System.out.println("Bairro: " + conta1.getCliente().getEndereco().getBairro());
        System.out.println("CEP: " + conta1.getCliente().getEndereco().getCep());
        System.out.println("Cidade: " + conta1.getCliente().getEndereco().getCidade());
        System.out.println("Estado: " + conta1.getCliente().getEndereco().getEstado());
        System.out.println("================================");
        System.out.println("=== Dados da conta poupança ====");
        System.out.println("Nome: " + conta2.getCliente().getNome());
        System.out.println("Numero da conta: " + conta2.getNumConta());
        System.out.println("Numero da agencia: " + conta2.getNumAgencia());
        System.out.println("CPF: " + conta2.getCliente().getCpf());
        System.out.println("Data de nascimento: " + conta2.getCliente().getDataNasc());
        System.out.println("================================");
        System.out.println("===== Endereco do Cliente ======");
        System.out.println("Rua: " + conta2.getCliente().getEndereco().getRua());
        System.out.println("Número: " + conta2.getCliente().getEndereco().getNumero());
        System.out.println("Bairro: " + conta2.getCliente().getEndereco().getBairro());
        System.out.println("CEP: " + conta2.getCliente().getEndereco().getCep());
        System.out.println("Cidade: " + conta2.getCliente().getEndereco().getCidade());
        System.out.println("Estado: " + conta2.getCliente().getEndereco().getEstado());
        System.out.println("================================");

        boolean sair = false;
        
        while (!sair) {
            System.out.println("================================");
            System.out.println("====== Escolha uma conta: ======");
            System.out.println("======= 1. Conta Corrente ======");
            System.out.println("======= 2. Conta Poupança ======");
            System.out.println("====== 3. Sair do Programa =====");
            System.out.println("================================");

            int escolhaConta = scanner.nextInt();

            if (escolhaConta == 1) {
                realizarOperacoes(conta1, conta2, scanner);
            } else if (escolhaConta == 2) {
                realizarOperacoes(conta2, conta1, scanner);
            } else if (escolhaConta == 3) {
                sair = true;
            } else {
                System.out.println("Opção inválida!");
            }
        }
        System.out.println("Programa encerrado.");
    }
    public static void realizarOperacoes(Conta contaOrigem, Conta contaDestino, Scanner scanner) {
        boolean sair = false;
    
        while (!sair) {
            System.out.println("================================");
            System.out.println("===== Escolha uma operação: ====");
            System.out.println("========= 1. Depósito ==========");
            System.out.println("========== 2. Saque ============");
            System.out.println("======= 3. Transferência =======");
            System.out.println("===== 4. Imprimir Extrato ======");
            System.out.println("===== 5. Voltar ao Menu ========");
            System.out.println("================================");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o valor do depósito:");
                    double valorDeposito = scanner.nextDouble();
                    if (contaOrigem.depositar(valorDeposito)) {
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Não foi possível realizar o depósito!");
                    }
                    break;
                    
                case 2:
                    System.out.println("Digite o valor do saque:");
                    double valorSaque = scanner.nextDouble();
                    if (contaOrigem.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Não foi possível realizar o saque!");
                    }
                    break;
                    
                case 3:
                    System.out.println("Digite o valor da transferência:");
                    double valorTransferencia = scanner.nextDouble();
                    if (contaOrigem.transferir(contaDestino, valorTransferencia)) {
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Não foi possível realizar a transferência!");
                    }
                    break;
                case 4:
                    System.out.println("Extrato da conta:");
                    contaOrigem.exibirExtrato();

                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}