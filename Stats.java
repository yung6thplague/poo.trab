import java.util.*;
import java.time.LocalDate;
import myinputs.Ler;

public class Stats {
    private List<Cliente> clientes;


    // Construtor
    public Stats(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    // Produtos Mais/Menos Vendidos
    public void produtosVendidos() {
        Map<Item, Integer> contador = new HashMap<>();

        for (Cliente cliente: clientes) {
            List<Item> produtos = cliente.getLista_compra();
            for (Item produto : produtos) {
                contador.put(produto, contador.getOrDefault(produto, 0) + 1);
            }
        }

        Item maisVendido = null;
        Item menosVendido = null;
        int maxVendas = Integer.MIN_VALUE;
        int minVendas = Integer.MAX_VALUE;

        for (Map.Entry<Item, Integer> entry : contador.entrySet()) {
            int quantidade = entry.getValue();
            if (quantidade > maxVendas) {
                maxVendas = quantidade;
                maisVendido = entry.getKey();
            }
            if (quantidade < minVendas) {
                minVendas = quantidade;
                menosVendido = entry.getKey();
            }
        }

        System.out.println("Produto Mais Vendido: " + (maisVendido != null ? maisVendido.getNome() : "Nenhum"));
        System.out.println("Produto Menos Vendido: " + (menosVendido != null ? menosVendido.getNome() : "Nenhum"));
    }

    // Melhor Cliente
    public void melhoresClientes() {
        Map<Cliente, Double> totalPorCliente = new HashMap<>();

        for (Cliente cliente : clientes) {
            double total = 0;
            for (Item item : cliente.getLista_compra()) {
                total += item.getCusto();
            }

            totalPorCliente.put(cliente, total);
        }

        Cliente melhorCliente = null;
        double maiorGasto = 0;

        for (Map.Entry<Cliente, Double> entry : totalPorCliente.entrySet()) {
            if (entry.getValue() > maiorGasto) {
                maiorGasto = entry.getValue();
                melhorCliente = entry.getKey();
            }
        }

        System.out.println("Melhor Cliente: " + (melhorCliente != null ? melhorCliente.getNome() : "Nenhum"));
    }

    // Calcular Faturamento em um Período
    public double calcularFaturamento(LocalDate inicio, LocalDate fim) {
        double total = 0;

        for (Item item : cliente.getLista_compra()) {
            if (!item.getDataCompra().isBefore(inicio) && !item.getDataCompra().isAfter(fim)) {
                total += item.getCusto();
            }
        }

        return total;
    }

    // Faturamento Diário
    public void faturamentoDiario() {
        LocalDate hoje = LocalDate.now();
        double total = calcularFaturamento(hoje, hoje);
        System.out.printf("Faturamento Diário (%s): %.2f\n", hoje, total);
    }

    // Faturamento Semanal
    public void faturamentoSemanal() {
        LocalDate hoje = LocalDate.now();
        LocalDate inicioSemana = hoje.minusDays(6); // Últimos 7 dias
        double total = calcularFaturamento(inicioSemana, hoje);
        System.out.printf("Faturamento Semanal (%s a %s): %.2f\n", inicioSemana, hoje, total);
    }

    // Faturamento Mensal
    public void faturamentoMensal() {
        LocalDate hoje = LocalDate.now();
        LocalDate inicioMes = hoje.withDayOfMonth(1); // Primeiro dia do mês
        double total = calcularFaturamento(inicioMes, hoje);
        System.out.printf("Faturamento Mensal (%s a %s): %.2f\n", inicioMes, hoje, total);
    }

}
