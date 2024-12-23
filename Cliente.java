import myinputs.Ler;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Pessoa  {

    private ArrayList<Item> lista_compra;

    public Cliente(Pessoa pessoa, ArrayList<Item> lista_compra) {
        super(pessoa.getNome(), pessoa.getNif(), pessoa.getEmail(), pessoa.getIdade());
        this.lista_compra = new ArrayList<Item>();
    }

    public Cliente() {
        this.lista_compra = new ArrayList<Item>();
    }


    public ArrayList<Item> getLista_compra() {
        return lista_compra;
    }




    public void setLista_compra(ArrayList<Item> lista_compra) {
        this.lista_compra = (ArrayList<Item>)lista_compra.clone();
    }

    @Override
    public String toString()
    {
        return "NIF do cliente: " + super.getNif() + " ;\n Nome do Cliente: " + super.getNome() + " ;\n Email do Cliente: " +super.getEmail()+ " ;\n Idade do cliente: "+ super.getIdade()+ " ;\n Lista de Compras: " + lista_compra.toString() + " \n\n\n";
    }



}
