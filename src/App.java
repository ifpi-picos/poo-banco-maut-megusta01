import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente1 = new Cliente("Gustavo", "040887913-04", LocalDate.of(2003, 2, 11), 
            new Endereco("Rua 1", 0, "Bairro 1", "Cidade 1", "Estado 1", "CEP 1"));
        CLiente cliente2 = new Cliente("João", "040887913-04", LocalDate.of(2003, 2, 11), null);

        while(true){
            System.out.println("1 - Criar conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){
                case 1 {
                    System.out.println("Digite o número da conta");
                    String numConta = scanner.nextLine();
                    System.out.println("Digite o número da agência");
                    String numAgencia = scanner.nextLine();
                    System.out.println("Digite o valor de abertura");
                    double abertura = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Digite o nome do cliente");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF do cliente");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite a data de nascimento do cliente");
                    String dataNascimento = scanner.nextLine();
                    Cliente cliente = new Cliente(nome, cpf, LocalDate.parse(dataNascimento), null);
                    System.out.println("Digite o tipo de notificação");
                    String tipoNotificacao = scanner.nextLine();
                    Notificacao notificacao = new Notificacao(tipoNotificacao);
                    Conta conta = new Conta(numConta, numAgencia, abertura, cliente, notificacao);
                    System.out.println("Conta criada com sucesso");
                    break;
                }
                case 2 {
                    System.out.println("Digite o número da conta");
                    String numConta = scanner.nextLine();
                    System.out.println("Digite o número da agência");
                    String numAgencia = scanner.nextLine();
                    System.out.println("Digite o valor do depósito");
                    double deposito = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Digite o tipo de notificação");
                    String tipoNotificacao = scanner.nextLine();
                    Notificacao notificacao = new Notificacao(tipoNotificacao);
                    Conta conta = new Conta(numConta, numAgencia, 0, null, notificacao);
                    conta.depositar(deposito);
                    System.out.println("Depósito realizado com sucesso");
                    break;
                }
                case 3 {
                    System.out.println("Digite o número da conta");
                    String numConta = scanner.nextLine();
                    System.out.println("Digite o número da agência");
                    String numAgencia = scanner.nextLine();
                    System.out.println("Digite o valor do saque");
                    double saque = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Digite o tipo de notificação");
                    String tipoNotificacao = scanner.nextLine();
                    Notificacao notificacao = new Notificacao(tipoNotificacao);
                    Conta conta = new Conta(numConta, numAgencia, 0, null, notificacao);
                    conta.sacar(saque);
                    System.out.println("Saque realizado com sucesso");
                    break;
                }
                case 4 {
                    System.out.println("Digite o número da conta de origem");
                    String numContaOrigem = scanner.nextLine();
                    System.out.println("Digite o número da agência de origem");
                    String numAgenciaOrigem = scanner.nextLine();
                    System.out.println("Digite o número da conta de destino");
                    String numContaDestino = scanner.nextLine();
                    System.out.println("Digite o número da agência de destino");
                    String numAgenciaDestino = scanner.nextLine();
                    System.out.println("Digite o valor da transferência");
                    double transferencia = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Digite o tipo de notificação");
                    String tipoNotificacao = scanner.nextLine();
                    Notificacao notificacao = new Notificacao(tipoNotificacao);
                    Conta contaOrigem = new Conta(numContaOrigem, numAgenciaOrigem, 0, null, notificacao);
                    Conta contaDestino = new Conta(numContaDestino, numAgenciaDestino, 0, null, notificacao);
                    contaOrigem.transferir(contaDestino, transferencia);
                    System.out.println("Transferência realizada com sucesso");
                    break;
                }
                case 5 {
                    System.exit(0);
                }
                default {
                    System.out.println("Opção inválida");
                }

            }
        }

    }    
}
