import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class  Main { 
    private static List<Pizza> cardapio = new ArrayList<>();

    public static void main(String[] args) {
        inicializarCardapio();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch (opcao) {
                case 1: exibirCardapio(); break;
                case 2: fazerNovoPedido(scanner); break;
                case 3: exibirTodosPedidos(); break;
                case 4: cancelarPedido(scanner); break;
                case 5: Pedido.gerarRelatorio(); break;
                case 0: System.out.println("Saindo do sistema..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        
        scanner.close();
    }
    
    private static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE PEDIDOS - PIZZARIA ===");
        System.out.println("1. Ver cardápio");
        System.out.println("2. Fazer novo pedido");
        System.out.println("3. Ver todos os pedidos");
        System.out.println("4. Cancelar pedido");
        System.out.println("5. Gerar relatório");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private static void inicializarCardapio() {
    cardapio.add(new Pizza("Margherita", 35.00, 
        new ArrayList<String>(Arrays.asList("Molho de tomate", "Mussarela", "Manjericão"))));
    cardapio.add(new Pizza("Calabresa", 40.00, 
        new ArrayList<String>(Arrays.asList("Molho de tomate", "Mussarela", "Calabresa", "Cebola"))));
    cardapio.add(new Pizza("Quatro Queijos", 45.00, 
        new ArrayList<String>(Arrays.asList("Molho de tomate", "Mussarela", "Provolone", "Gorgonzola", "Parmesão"))));
    cardapio.add(new Pizza("Portuguesa", 42.00, 
        new ArrayList<String>(Arrays.asList("Molho de tomate", "Mussarela", "Presunto", "Ovo", "Cebola", "Azeitona"))));
    cardapio.add(new Pizza("Frango com Catupiry", 43.00, 
        new ArrayList<String>(Arrays.asList("Molho de tomate", "Mussarela", "Frango desfiado", "Catupiry"))));
}
    
    private static void exibirCardapio() {
        System.out.println("\n=== CARDÁPIO ===");
        for (int i = 0; i < cardapio.size(); i++) {
            System.out.println((i + 1) + ". " + cardapio.get(i));
        }
    }
    
    private static void fazerNovoPedido(Scanner scanner) {
        exibirCardapio();
        System.out.print("\nEscolha o número da pizza: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        if (escolha < 1 || escolha > cardapio.size()) {
            System.out.println("Opção inválida!");
            return;
        }
        
        Pizza pizzaEscolhida = cardapio.get(escolha - 1);
        
        System.out.print("Tamanho (P/M/G): ");
        String tamanho = scanner.nextLine();
        
        System.out.print("Endereço de entrega: ");
        String endereco = scanner.nextLine();
        
        new Pedido(pizzaEscolhida, tamanho, endereco);
        System.out.println("Pedido realizado com sucesso!");
    }
    
    private static void exibirTodosPedidos() {
        System.out.println("\n=== TODOS OS PEDIDOS ===");
        List<Pedido> pedidos = Pedido.getTodosPedidos();
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado ainda.");
        } else {
            pedidos.forEach(System.out::println);
        }
    }
    
    private static void cancelarPedido(Scanner scanner) {
        exibirTodosPedidos();
        List<Pedido> pedidos = Pedido.getTodosPedidos();
        
        if (pedidos.isEmpty()) {
            return;
        }
        
        System.out.print("Digite o ID do pedido a ser cancelado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        for (Pedido pedido : pedidos) {
            if (pedido.toString().contains("Pedido #" + id)) {
                pedido.cancelar();
                System.out.println("Pedido #" + id + " cancelado com sucesso!");
                return;
            }
        }
        
        System.out.println("Pedido não encontrado!");
    }
}