import java.io.Serializable;
import java.time.LocalDate;
public class Item implements Serializable {
    private int codigo;
    private String nome;
    private String requisitos;
    private String descricao;
    private double custo;
    private int idademinima;
    private LocalDate dataCompra;

    public Item() {

        codigo = 0;
        this.nome = "";
        this.requisitos = "";
        this.descricao = "";
        this.custo = 0.0;
    }

    public Item(int codigo, String nome, String descricao, double custo, String caract_tecnica, int idademinima, LocalDate dataCompra) {

        this.codigo = codigo;
        this.nome = nome;
        this.custo = custo;
        this.requisitos = caract_tecnica;
        this.descricao = descricao;
        this.idademinima = idademinima;
        this.dataCompra = dataCompra;
    }



    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public int getIdademinima() {return idademinima;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setRequisitos(String caract_tecnica) {
        this.requisitos = caract_tecnica;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setIdademinima(int idademinima) {this.idademinima = idademinima;}

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    @Override
    public String toString() {
        return "Referência do item: " + codigo + " ;\n Nome do item: " + nome + " ;\n Custo do produto: " + custo + " ;\n Descrição do produto: " + descricao + " ;\n Requisitos: " + requisitos + "\n Idade Mínima: "+ idademinima+" \n\n\n";
    }


}
