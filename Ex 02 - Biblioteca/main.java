import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ArrayList<livros> biblioteca = new ArrayList<>();

        while (true) {
            System.out.println("\n ------ MENU -----");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Pesquisar Livros");
            System.out.println("3 - Listar Livros");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o Titulo do Livro: ");
                    String titulo = ler.nextLine();
                    System.out.println("Digite o Autor do Livro: ");
                    String autor = ler.nextLine();
                    System.out.println("Digite o Ano do Livro: ");
                    int ano = ler.nextInt();
                    ler.nextLine();
                    
                    livros novoLivro = new livros (titulo, autor, ano);
                    biblioteca.add(novoLivro);
                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite o Titulo do Livro a ser pesquisado: ");
                    String tituloPesquisar = ler.nextLine();

                    for (livros livro : biblioteca) {
                        if (livro.getTitulo().equalsIgnoreCase(tituloPesquisar)) {
                            livro.exibirinfo();
                            return; 
                        }
                    }
                    System.out.println("Livro não encontrado na biblioteca.");
                    break;

                case 3:
                    ListarLivros(biblioteca);
                    break;  

                case 4:
                System.out.println("Saindo...");
                ler.close();
                return;

                default:
                System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
        public static void ListarLivros(ArrayList<livros> biblioteca) {
            if (biblioteca.isEmpty()) {
                System.out.println("Nenhum livro cadastrado na biblioteca.");
            } else {
                System.out.println("Livros cadastrados na biblioteca:");
                for (livros livro : biblioteca) {
                    livro.exibirinfo();
                }
            }
        }
    }
