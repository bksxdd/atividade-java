import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Produto> estoque = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===MERCADO===");
            System.out.println("1 - cadastrar produto");
            System.out.println("2 - listar produtos");
            System.out.println("3 - atualizar produto");
            System.out.println("4 - remover produto");
            System.out.println("5 - sair");
            System.out.print("opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    removerProduto();
                    break;
                case 5:
                    System.out.println("saindo..");
                    return;
                default:
                    System.out.println("ppção invalida");
            }
        }
    }

    static void cadastrarProduto() {
        System.out.println("\n--- CADASTRO ---");
        
        System.out.print("nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("oódigo: ");
        String codigo = scanner.nextLine();

        for (Produto p : estoque) {
            if (p.codigo.equals(codigo)) {
                System.out.println("erro: código já existe");
                return;
            }
        }
        
        System.out.print("preço: ");
        double preco = scanner.nextDouble();
        
        System.out.print("quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); 
        
        Produto novo = new Produto(nome, codigo, preco, quantidade);
        estoque.add(novo);
        
        System.out.println("produto cadastrado");
    }

    static void listarProdutos() {
        System.out.println("\n--- ESTOQUE ---");
        
        if (estoque.isEmpty()) {
            System.out.println("nenhum produto cadastrado");
            return;
        }
        
        for (Produto p : estoque) {
            System.out.println(p);
        }
        
        double total = 0;
        for (Produto p : estoque) {
            total += p.preco * p.quantidade;
        }
        System.out.printf("\nvalor total em estoque: R$ %.2f\n", total);
    }

    static void atualizarProduto() {
        System.out.println("\n--- ATUALIZAR ---");
        
        System.out.print("digite o código: ");
        String codigo = scanner.nextLine();
        
        for (Produto p : estoque) {
            if (p.codigo.equals(codigo)) {
                System.out.println("produto encontrado:");
                System.out.println(p);
                
                System.out.print("novo nome: ");
                p.nome = scanner.nextLine();
                
                System.out.print("novo preço: ");
                p.preco = scanner.nextDouble();
                
                System.out.print("nova quantidade: ");
                p.quantidade = scanner.nextInt();
                scanner.nextLine();
                
                System.out.println("produto atualizado");
                return;
            }
        }
        
        System.out.println("produto não encontrado");
    }

    static void removerProduto() {
        System.out.println("\n---REMOVER---");
        
        System.out.print("digite o codigo: ");
        String codigo = scanner.nextLine();
        
        for (int i = 0; i < estoque.size(); i++) {
            if (estoque.get(i).codigo.equals(codigo)) {
                estoque.remove(i);
                System.out.println("produto removido");
                return;
            }
        }
        
        System.out.println("produto não encontrado");
    }
}