import java.time.LocalDate;
import java.util.*;

public class Stats {
    private static List<Cliente> clientes;

    // Construtor
    public Stats(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    // Produtos Mais/Menos Vendidos
    public static void produtosVendidos(ArrayList<Cliente> clientes) {
        Item maisVendido = null;
        Item menosVendido = null;
        int maxVendas = 0;
        int minVendas = Integer.MAX_VALUE;

        for (Cliente cliente : clientes) {
            List<Item> listaCompra = cliente.getLista_compra();
            for (Item item : listaCompra) {
                int quantidadeVendida = 0;
                for (Cliente c : clientes) {
                    for (Item i : c.getLista_compra()) {
                        if (i.equals(item)) {
                            quantidadeVendida++;
                        }
                    }
                }
                if (quantidadeVendida > maxVendas) {
                    maxVendas = quantidadeVendida;
                    maisVendido = item;
                }
                if (quantidadeVendida < minVendas) {
                    minVendas = quantidadeVendida;
                    menosVendido = item;
                }
            }
        }

        System.out.println("Produto Mais Vendido: " + (maisVendido != null ? maisVendido.getNome() : "Nenhum"));
        System.out.println("Produto Menos Vendido: " + (menosVendido != null ? menosVendido.getNome() : "Nenhum"));
    }

    // Melhor Cliente
    public static void melhoresClientes(ArrayList<Cliente> clientes) {
        Cliente melhorCliente = null;
        double maiorGasto = 0;

        for (Cliente cliente : clientes) {
            double totalGasto = 0;
            for (Item item : cliente.getLista_compra()) {
                totalGasto += item.getCusto();
            }

            if (totalGasto > maiorGasto) {
                maiorGasto = totalGasto;
                melhorCliente = cliente;
            }
        }

        System.out.println("Melhor Cliente: " + (melhorCliente != null ? melhorCliente.getNome() : "Nenhum"));
    }

    // Calcular Faturamento em um Período
    public static double calcularFaturamento(LocalDate inicio, LocalDate fim, ArrayList<Cliente> clientes) {
        double total = 0;

        for (Cliente cliente : clientes) {
            for (Item item : cliente.getLista_compra()) {
                LocalDate dataCompra = item.getDataCompra();
                if ((dataCompra.isEqual(inicio) || dataCompra.isAfter(inicio)) &&
                        (dataCompra.isEqual(fim) || dataCompra.isBefore(fim))) {
                    total += item.getCusto();
                }
            }
        }

        return total;
    }

    /*// Faturamento Diário
    public static void faturamentoDiario() {
        LocalDate hoje = LocalDate.now();
        double total = calcularFaturamento(hoje, hoje);
        System.out.printf("Faturamento Diário (%s): %.2f\n", hoje, total);
    }

    // Faturamento Semanal
    public static void faturamentoSemanal() {
        LocalDate hoje = LocalDate.now();
        LocalDate inicioSemana = hoje.minusDays(6); // Últimos 7 dias
        double total = calcularFaturamento(inicioSemana, hoje);
        System.out.printf("Faturamento Semanal (%s a %s): %.2f\n", inicioSemana, hoje, total);
    }

    // Faturamento Mensal
    public static void faturamentoMensal() {
        LocalDate hoje = LocalDate.now();
        LocalDate inicioMes = hoje.withDayOfMonth(1); // Primeiro dia do mês
        double total = calcularFaturamento(inicioMes, hoje);
        System.out.printf("Faturamento Mensal (%s a %s): %.2f\n", inicioMes, hoje, total);
    }

     */
}
