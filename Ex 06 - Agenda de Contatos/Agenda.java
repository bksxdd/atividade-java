import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;  

    public Agenda() {
        this.contatos = new ArrayList<>();
    } 

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        System.out.println("Contato adicionado: " + contato.getNome());
    }

    public void removerContato(String nome) {
        Contato contatoParaRemover = null;
        
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatoParaRemover = contato;
                break;
            }
        }
        
        if (contatoParaRemover != null) {
            contatos.remove(contatoParaRemover);
            System.out.println("Contato removido: " + nome);
        } else {
            System.out.println("Contato não encontrado: " + nome);
        }
    }

    public Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;  
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado na agenda.");
        } else {
            System.out.println("\n--- LISTA DE CONTATOS ---");
            for (Contato contato : contatos) {
                System.out.println("Nome: " + contato.getNome() + 
                                 " | Telefone: " + contato.getTelefone());
            }
        }
    }
}