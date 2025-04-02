public class Jogador {
    private String nome;
    private int pontuacao;
    private int nivel;
    
    public Jogador(String nome, int pontuacaoInicial, int nivelInicial) {
        this.nome = nome;
        this.pontuacao = Math.max(pontuacaoInicial, 0);
        this.nivel = Math.max(nivelInicial, 1);
    }
    
    public void aumentarPontuacao(int pontos) {
        if (pontos > 0) {
            this.pontuacao += pontos;
            verificarSubidaNivel();
        }
    }
    
    public void subirNivel(int quantidade) {
        if (quantidade > 0) {
            this.nivel += quantidade;
        }
    }
    
    private void verificarSubidaNivel() {
        int niveisGanhos = this.pontuacao / 1000 - (this.nivel - 1);
        if (niveisGanhos > 0) {
            subirNivel(niveisGanhos);
            System.out.println(nome + " subiu para o nível " + nivel + "!");
        }
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getPontuacao() {
        return pontuacao;
    }
    
    public int getNivel() {
        return nivel;
    }
    
    public void exibirInformacoes() {
        System.out.println("\n--- Perfil do Jogador ---");
        System.out.println("Nome: " + nome);
        System.out.println("Pontuação: " + pontuacao);
        System.out.println("Nível: " + nivel);
        System.out.println("------------------------");
    }
    
    @Override
    public String toString() {
        return nome + " (Nível " + nivel + ", " + pontuacao + " pontos)";
    }
}