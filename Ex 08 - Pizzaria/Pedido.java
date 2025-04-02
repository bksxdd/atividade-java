import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int totalPedidos = 0;
    private static double valorTotalPedidos = 0;
    private static List<Pedido> todosPedidos = new ArrayList<>();

    private int id;
    private Pizza pizza;
    private String tamanho;
    private String enderecoEntrega;
    private boolean cancelado;

    public Pedido(Pizza pizza, String tamanho, String enderecoEntrega) {
        this.id = ++totalPedidos;
        this.pizza = pizza;
        this.tamanho = tamanho;
        this.enderecoEntrega = enderecoEntrega;
        this.cancelado = false;
        valorTotalPedidos += pizza.getValor();
        todosPedidos.add(this);
    }

    public void cancelar() {
        if (!cancelado) {
            cancelado = true;
            valorTotalPedidos -= pizza.getValor();
        }
    }

    public static void gerarRelatorio() {
        System.out.println("\n=== RELATÓRIO DE PEDIDOS ===");
        System.out.println("Total de pedidos: " + totalPedidos);
        System.out.println("Média de valor dos pedidos: R$" + 
                         (totalPedidos > 0 ? valorTotalPedidos / totalPedidos : 0));
        System.out.println("Pedidos ativos: " + 
                         (totalPedidos - todosPedidos.stream().filter(p -> p.cancelado).count()));
        System.out.println("Valor total em pedidos ativos: R$" + valorTotalPedidos);
    }

    public static List<Pedido> getTodosPedidos() {
        return todosPedidos;
    }

    @Override
    public String toString() {
        return "Pedido #" + id + 
               "\nPizza: " + pizza.getNome() + 
               "\nTamanho: " + tamanho + 
               "\nValor: R$" + pizza.getValor() + 
               "\nEndereço de entrega: " + enderecoEntrega + 
               "\nStatus: " + (cancelado ? "CANCELADO" : "ATIVO") + "\n";
    }
}