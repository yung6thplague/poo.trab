import java.util.*;
import java.time.LocalDate;
import myinputs.Ler;

public class Stats {
    private List<Venda> vendas;

    // Construtor
    public Stats(List<Venda> vendas) {
        this.vendas = vendas;
    }

    // Produtos Mais/Menos Vendidos
    public void produtosVendidos() {
        Map<Item, Integer> contador = new HashMap<>();

        for (Venda venda : vendas) {
            List<Item> produtos = venda.getProdutos();
            List<Integer> quantidades = venda.getQuantidades();

            for (int i = 0; i < produtos.size(); i++) {
                Item produto = produtos.get(i);
                int quantidade = quantidades.get(i);
                if (contador.containsKey(produto)) {
                    contador.put(produto, contador.get(produto) + quantidade);
                } else {
                    contador.put(produto, quantidade);
                }
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

        for (Venda venda : vendas) {
            Cliente cliente = venda.getCliente();
            double total = venda.getTotal();

            if (totalPorCliente.containsKey(cliente)) {
                totalPorCliente.put(cliente, totalPorCliente.get(cliente) + total);
            } else {
                totalPorCliente.put(cliente, total);
            }
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

        for (Venda venda : vendas) {
            if (!venda.getData().isBefore(inicio) && !venda.getData().isAfter(fim)) {
                total += venda.getTotal();
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
