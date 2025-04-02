public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private double velocidadeAtual;

    public Carro(String marca, String modelo, int ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.velocidadeAtual = 0;
    }

    public void acelerar(double quantidade) {
        if(quantidade > 0) {
            velocidadeAtual += quantidade;
            System.out.println(modelo + " acelerou para " + velocidadeAtual + " km/h");
        }
    }

    public void frear(double quantidade) {
        if(quantidade > 0) {
            if(quantidade > velocidadeAtual) {
                velocidadeAtual = 0;
            } else {
                velocidadeAtual -= quantidade;
            }
            System.out.println(modelo + " reduziu para " + velocidadeAtual + " km/h");
        }
    }

    public void mostrarInfo() {
        System.out.println("\n---DADOS DO CARRO---");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Placa: " + placa);
        System.out.println("Velocidade: " + velocidadeAtual + " km/h\n");
    }

    // Getters
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }
    public String getPlaca() { return placa; }
    public double getVelocidade() { return velocidadeAtual; }
}