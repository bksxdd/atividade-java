import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CADASTRO DE CONTA BANCÁRIA ===");
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();
        
        System.out.print("Digite o nome do titular: ");
        String titular = scanner.nextLine();
        
        System.out.print("Digite o saldo inicial: R$");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        contabancaria conta = new contabancaria (numeroConta, titular, saldoInicial);
        
        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Exibir Informações da Conta");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            
            switch(opcao) {
                case 1:
                    System.out.print("Digite o valor para depósito: R$");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor para saque: R$");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    System.out.println("Saldo atual: R$" + conta.consultarSaldo());
                    break;
                case 4:
                    conta.exibirInformacoes();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
        
        scanner.close();
    }
}