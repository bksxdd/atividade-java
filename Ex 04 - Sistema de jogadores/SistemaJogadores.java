import java.util.ArrayList;
import java.util.Scanner;

public class SistemaJogadores {
    private ArrayList<Jogador> jogadores;
    private Scanner scanner;
    
    public SistemaJogadores() {
        jogadores = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void iniciar() {
        System.out.println("=== Sistema de Gerenciamento de Jogadores ===");
        
        boolean executando = true;
        while (executando) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    cadastrarNovoJogador();
                    break;
                case 2:
                    listarJogadores();
                    break;
                case 3:
                    atualizarPontuacao();
                    break;
                case 4:
                    exibirDetalhesJogador();
                    break;
                case 5:
                    executando = false;
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
    
    private void exibirMenu() {
        System.out.println("\nMenu Principal:");
        System.out.println("1. Cadastrar novo jogador");
        System.out.println("2. Listar todos os jogadores");
        System.out.println("3. Atualizar pontuação de um jogador");
        System.out.println("4. Exibir detalhes de um jogador");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private void cadastrarNovoJogador() {
        System.out.println("\n--- Cadastro de Novo Jogador ---");
        System.out.print("Nome do jogador: ");
        String nome = scanner.nextLine();
        
        System.out.print("Pontuação inicial: ");
        int pontuacao = scanner.nextInt();
        
        System.out.print("Nível inicial: ");
        int nivel = scanner.nextInt();
        
        Jogador novoJogador = new Jogador(nome, pontuacao, nivel);
        jogadores.add(novoJogador);
        
        System.out.println("Jogador cadastrado com sucesso!");
    }
    
    private void listarJogadores() {
        System.out.println("\n--- Lista de Jogadores ---");
        if (jogadores.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado ainda.");
        } else {
            for (int i = 0; i < jogadores.size(); i++) {
                System.out.println((i + 1) + ". " + jogadores.get(i));
            }
        }
    }
    
    private void atualizarPontuacao() {
        if (jogadores.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado para atualizar.");
            return;
        }
        
        listarJogadores();
        System.out.print("Escolha o número do jogador: ");
        int indice = scanner.nextInt() - 1;
        
        if (indice >= 0 && indice < jogadores.size()) {
            System.out.print("Quantos pontos adicionar? ");
            int pontos = scanner.nextInt();
            
            Jogador jogador = jogadores.get(indice);
            jogador.aumentarPontuacao(pontos);
            
            System.out.println("Pontuação atualizada com sucesso!");
            jogador.exibirInformacoes();
        } else {
            System.out.println("Índice inválido.");
        }
    }
    
    private void exibirDetalhesJogador() {
        if (jogadores.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado para exibir.");
            return;
        }
        
        listarJogadores();
        System.out.print("Escolha o número do jogador: ");
        int indice = scanner.nextInt() - 1;
        
        if (indice >= 0 && indice < jogadores.size()) {
            jogadores.get(indice).exibirInformacoes();
        } else {
            System.out.println("Índice inválido.");
        }
    }
}