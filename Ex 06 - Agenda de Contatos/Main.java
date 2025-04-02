import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        
        System.out.println("Bem-vindo ao Sistema de Agenda de Contatos!");

        try {
            while (true) {
                exibirMenu();
                int opcao = lerOpcao(scanner);
                
                switch (opcao) {
                    case 1:
                        adicionarContato(scanner, agenda);
                        break;
                    case 2:
                        removerContato(scanner, agenda);
                        break;
                    case 3:
                        buscarContato(scanner, agenda);  // Nome do método corrigido
                        break;
                    case 4:
                        listarContatos(agenda);
                        break;
                    case 0:
                        System.out.println("Obrigado por usar o sistema. Até logo!");
                        return;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            }
        } finally {
            scanner.close();
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Adicionar Contato");
        System.out.println("2. Remover Contato");
        System.out.println("3. Buscar Contato");
        System.out.println("4. Listar Todos os Contatos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número válido!");
                scanner.nextLine(); // Limpa o buffer
            } finally {
                scanner.nextLine(); // Sempre limpa o buffer
            }
        }
    }

    private static void adicionarContato(Scanner scanner, Agenda agenda) {
        System.out.println("\n--- ADICIONAR CONTATO ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        agenda.adicionarContato(new Contato(nome, telefone));
    }

    private static void removerContato(Scanner scanner, Agenda agenda) {
        System.out.println("\n--- REMOVER CONTATO ---");
        System.out.print("Digite o nome do contato a remover: ");
        String nome = scanner.nextLine();
        agenda.removerContato(nome);
    }

    private static void buscarContato(Scanner scanner, Agenda agenda) {
        System.out.println("\n--- BUSCAR CONTATO ---");
        System.out.print("Digite o nome do contato a buscar: ");
        String nome = scanner.nextLine();
        Contato contato = agenda.buscarContato(nome);
        
        if (contato != null) {
            System.out.println("\nContato encontrado:");
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Telefone: " + contato.getTelefone());
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private static void listarContatos(Agenda agenda) {
        agenda.listarContatos();
    }
}