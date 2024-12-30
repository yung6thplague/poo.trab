import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
// 1 2 3 testando ha ha
public class Fatura implements Serializable {
    private int numeroFatura;
    private LocalDate data;
    private Cliente cliente;
    private List<Integer> quantidades;
    private double valorTotal;

    public Fatura(LocalDate data, Cliente cliente,  List<Integer> quantidades, double valorTotal) {
        this.numeroFatura = this.numeroFatura ++;
        this.data = data;
        this.cliente = cliente;
        this.quantidades = quantidades;
        this.valorTotal = valorTotal;
    }


    public static void imprimirFatura(int numeroFatura, LocalDate data, Cliente cliente, ArrayList<Item> listaCompra) {
        double valorTotal = 0;
        System.out.println("--------- Fatura Fiscal ---------");
        System.out.println("Número da Fatura: " + numeroFatura);
        System.out.println("Data: " + data);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Produtos:");


        for (int i = 0; i < listaCompra.size(); i++) {
            Item produto = listaCompra.get(i);
            double precoUnitario = produto.getCusto();
            double subtotal = precoUnitario;

            System.out.printf("  - %s | Qtd: %d | Preço Unitário: %.2f | Subtotal: %.2f\n",
                    produto.getNome(), precoUnitario, subtotal);

            valorTotal += subtotal;
        }

        System.out.printf("Valor Total: \n" +valorTotal);
        System.out.println("---------------------------------");
    }
}

