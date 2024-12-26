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

    public Fatura(int numeroFatura, LocalDate data, Cliente cliente,  List<Integer> quantidades, double valorTotal) {
        this.numeroFatura = numeroFatura;
        this.data = data;
        this.cliente = cliente;
        this.quantidades = quantidades;
        this.valorTotal = valorTotal;
    }


    public void imprimirFatura() {
        System.out.println("--------- Fatura Fiscal ---------");
        System.out.println("Número da Fatura: " + numeroFatura);
        System.out.println("Data: " + data);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Produtos:");
        for (int i = 0; i < getLista_compra().size(); i++) {
            Item produto = getLista_compra().get(i);
            int quantidade = quantidades.get(i);
            System.out.printf("  - %s | Qtd: %d | Preço Unitário: %.2f | Subtotal: %.2f\n",
                    produto.getNome(), quantidade, produto.getLista_compra(), getLista_compra() * quantidade);
        }
        System.out.printf("Valor Total: %.2f\n", valorTotal);
        System.out.println("---------------------------------");
    }
}
