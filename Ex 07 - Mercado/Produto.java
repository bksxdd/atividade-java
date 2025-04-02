public class Produto {
    public String nome;
    public String codigo;
    public double preco;
    public int quantidade;

    public Produto(String nome, String codigo, double preco, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String toString() {
        return "produto: " + nome + " | cód: " + codigo + 
               " | R$ " + preco + " | Qtd: " + quantidade;
    }
}