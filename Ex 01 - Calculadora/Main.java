import java.util.Scanner;

public class Main{
    public static void
    main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o Primeiro numero: ");
            double n1 = scanner.nextDouble();
        System.out.print("Digite o Segundo numero: ");
            double n2 = scanner.nextDouble();

        System.out.println("\nEscolha a operacao: ");
        System.out.println("1-Soma");
        System.out.println("2-Subtracao");
        System.out.println("3-Multiplicacao");
        System.out.println("4-Divisao");
        System.out.print("Opcao: ");

        int opcao = scanner.nextInt();
        double resultado = 0;
        switch(opcao){
            case 1:
                resultado = Calculadora.Somar(n1,n2);
                System.out.println("O resultado da Soma e:" + resultado);
                break;
            case 2:
                resultado = Calculadora.subtrair(n1,n2);
                System.out.println("O resultado da Subtracao e: +"+ resultado);
                break;
            case 3:
                resultado = Calculadora.multiplicar(n1,n2);
                System.out.println("O Resultado da multiplicacao e: " + resultado);
                break;
            case 4:
                resultado = Calculadora.dividir(n1,n2);
                System.out.println("O Resultado da Divisao e: " + resultado);
                break;
            default:
                System.out.println("Opcao Invalida!");
        }
    scanner.close();

}
}