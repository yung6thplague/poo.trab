import java.io.Serializable;

public class Item implements Serializable {
    private int codigo;
    private String nome;
    private String requisitos;
    private String descricao;
    private double custo;

    public Item() {

        codigo = 0;
        this.nome = "";
        this.requisitos = "";
        this.descricao = "";
        this.custo = 0.0;
    }

    public Item(int codigo, String nome, String descricao, double custo, String caract_tecnica) {

        this.codigo = codigo;
        this.nome = nome;
        this.custo = custo;
        this.requisitos = caract_tecnica;
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return "Referência do item: " + codigo + " ;\n Nome do item: " + nome + " ;\n Custo do electrodoméstico: " + custo + " ;\n Descrição do eletrodoméstico: " + descricao + " ;\n Características Técnicas : " + requisitos + " \n\n\n";
    }


}
