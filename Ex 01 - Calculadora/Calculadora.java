
public class Calculadora {
    public static double Somar(double n1 ,double n2 ){
        return n1 + n2;
    }
    public static double subtrair(double n1, double n2){
        return n1 - n2;
    }
    public static double multiplicar(double n1, double n2){
        return n1 * n2;
    }
    public static double dividir(double n1, double n2){
        if (n1 == 0){
            System.out.println("Erro, Divisao por 0");
            return 0;
        }
        return n1 / n2;
    }
}
