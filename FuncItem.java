import myinputs.Ler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FuncItem {


    public static void adicionarItem(ArrayList<Item> lista) {
        System.out.println("Insira a referência do item.");
        int codigo = Ler.umInt();
        System.out.println("Insira o nome do item.");
        String nome = Ler.umaString();
        System.out.println("Insira a descrição do item.");
        String descricao = Ler.umaString();
        System.out.println("Insira o custo do item.");
        double custo = Ler.umDouble();
        System.out.println("Insira os requisitos do item.");
        String requisitos = Ler.umaString();
        Item i1 = new Item(codigo,nome,descricao,custo,requisitos);
        if (!lista.contains(i1)) {
            lista.add(i1);
        } else {
            throw new NaoEncontreiException("Item já existe na lista!");
        }
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Maia\\Documents\\UBI\\POO\\Projeto\\src\\item.dat"));
            os.writeObject(lista);
            os.flush(); //
            os.close();
            System.out.println("Items written to file successfully. Current items:");
            for (Item item : lista) {
                System.out.println(item);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarItem(ArrayList<Item> lista) throws NaoEncontreiException {
        System.out.println("Insira a referência do item que deseja remover.");
        int codigo = Ler.umInt();
        boolean alterou = false;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCodigo()==codigo) {
                lista.remove(i);
                alterou = true;
            }
        }
        if (!alterou) {
            throw new NaoEncontreiException("Produto não encontrado!");
        }
        System.out.println("O produto  foi eliminado com sucesso!");
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Maia\\Documents\\UBI\\POO\\Projeto\\src\\item.dat"));
            os.writeObject(lista);
            os.flush(); //
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void atualizarItem(ArrayList<Item> lista) throws NaoEncontreiException{
        System.out.println("Insira a referência do item que deseja atualizar.");
        int codigo = Ler.umInt();
        boolean check = false;
        for (Item item : lista) {
            if(item.getCodigo()==codigo) {
                check = true;
            }
        }
        if(!check) {
            throw new NaoEncontreiException("Produto não encontrado! ");
        }
        System.out.println("O que pretende alterar? (1- Referência, 2- Nome, 3- Descrição, 4- Custo, 5- Requisitos) ");
        int escolha = Ler.umInt();
        switch (escolha) {
            case 1:
                System.out.println("Insira a nova referência: ");
                int cod2 = Ler.umInt();
                for(Item i1 : lista) {
                    if(i1.getCodigo()==codigo) {
                        i1.setCodigo(cod2);
                        System.out.println("Referência alterada com sucesso!");
                    }
                }
                break;
            case 2:
                System.out.println("Insira o novo nome: ");
                String nome = Ler.umaString();
                for(Item i1 : lista) {
                    if(i1.getCodigo()==codigo) {
                        i1.setNome(nome);
                        System.out.println("Nome alterado com sucesso!");
                    }
                }
                break;
            case 3:
                System.out.println("Insira a nova descrição: ");
                String desc = Ler.umaString();
                for(Item i1 : lista) {
                    if(i1.getCodigo()==codigo) {
                        i1.setDescricao(desc);
                        System.out.println("Descrição alterada com sucesso!");
                    }
                }
                break;
            case 4:
                System.out.println("Insira o novo custo: ");
                double custo = Ler.umDouble();
                for(Item i1 : lista) {
                    if(i1.getCodigo()==codigo) {
                        i1.setCusto(custo);
                        System.out.println("Custo alterado com sucesso!");
                    }
                }
                break;
            case 5:
                System.out.println("Insira os novos requisitos: ");
                String requisitos = Ler.umaString();
                for(Item i1 : lista) {
                    if(i1.getCodigo()==codigo) {
                        i1.setRequisitos(requisitos);
                        System.out.println("Requisitos alteradas com sucesso!");
                    }
                }
                break;
        }

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Maia\\Documents\\UBI\\POO\\Projeto\\src\\item.dat"));
            os.writeObject(lista);
            os.flush(); //
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
