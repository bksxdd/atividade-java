import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("---CADASTRO DE CARRO CLASSICO---");

        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        

        Carro meuCarro = new Carro(marca, modelo, ano, placa);
        
        System.out.println("\ncarro cadastrado com sucesso");
        meuCarro.mostrarInfo();
 
        System.out.println("---CONTROLE DE VELOCIDADE---");
        System.out.print("Quanto acelerar? (km/h): ");
        double aceleracao = scanner.nextDouble();
        meuCarro.acelerar(aceleracao);
        
        System.out.print("Quanto frear? (km/h): ");
        double frenagem = scanner.nextDouble();
        meuCarro.frear(frenagem);
        

        System.out.println("\n---STATUS FINAL---");
        meuCarro.mostrarInfo();
        
        scanner.close();
    }
}