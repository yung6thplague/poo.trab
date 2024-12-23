import myinputs.Ler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FuncCliente {

    public static void adicionarCliente(ArrayList<Cliente> lista_cliente, ArrayList<Item> lista_item) {
        ArrayList<Item> lista_compras = new ArrayList<Item>();
        System.out.println("Insira o nif do cliente.");
        int nif = Ler.umInt();
        System.out.println("Insira o nome do cliente.");
        String nome = Ler.umaString();
        System.out.println("Insira o email do cliente.");
        String email= Ler.umaString();
        System.out.println("Insira a idade do cliente:");
        int idade = Ler.umInt();
        System.out.println("Insira as referências dos produtos comprados pelo cliente. (Insira 0 quando quiser terminar): ");
        System.out.println(lista_item.toString());
        int refer;
        do {
            refer = Ler.umInt();
            if(refer == 0) {
                break;
            }
            boolean check = false;
            for (Item i1 : lista_item) {
                if (i1.getCodigo() == refer) {
                    lista_compras.add(i1);
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println("Item não encontrado!");
            }
        } while (true);
        Pessoa p1 = new Pessoa(nome,nif,email,idade);
        Cliente c1 = new Cliente(p1,lista_item);
        if (!lista_cliente.contains(c1)) {
            lista_cliente.add(c1);
            System.out.println("Cliente " + nif + " adicionado com sucesso!");
        } else {
            throw new NaoEncontreiException("Cliente já existe !");
        }
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Maia\\Documents\\UBI\\POO\\cliente.dat"));
            os.writeObject(lista_cliente);
            os.flush(); //
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarCliente(ArrayList<Cliente> lista_cliente) throws NaoEncontreiException {
        System.out.println("Insira o nif do cliente que pretende remover.");
        int nif = Ler.umInt();
        boolean alterou = false;
        for (int i = 0; i < lista_cliente.size(); i++) {
            if(lista_cliente.get(i).getNif()==nif) {
                lista_cliente.remove(i);
                alterou = true;
            }
        }
        if (!alterou) {
            throw new NaoEncontreiException("O cliente não foi encontrado na lista!");
        }
        System.out.println("O cliente foi eliminado com sucesso!");
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Maia\\Documents\\UBI\\POO\\cliente.dat"));
            os.writeObject(lista_cliente);
            os.flush(); //
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void atualizarCliente(ArrayList<Cliente> lista_cliente) throws NaoEncontreiException {
        System.out.println("Insira o nif do cliente que deseja atualizar.");
        int nif = Ler.umInt();
        boolean check = false;
        for (Cliente c : lista_cliente) {
            if (c.getNif() == nif) {
                check = true;
            }
        }
        if (!check) {
            throw new NaoEncontreiException("Produto não encontrado! ");
        }
        System.out.println("O que pretende alterar? (1- NIF, 2- Nome, 3-Email, 4-Idade, 5- Lista de compras. ) ");
        int escolha = Ler.umInt();
        switch (escolha) {
            case 1:
                System.out.println("Insira o novo NIF: ");
                int nif2 = Ler.umInt();
                for (Cliente c : lista_cliente) {
                    if (c.getNif() == nif) {
                        c.setNif(nif2);
                        System.out.println("Referência alterada com sucesso!");
                    }
                }
                break;
            case 2:
                System.out.println("Insira o novo nome: ");
                String nome = Ler.umaString();
                for (Cliente c : lista_cliente) {
                    if (c.getNif() == nif) {
                        c.setNome(nome);
                        System.out.println("Nome alterado com sucesso!");
                    }
                }
                break;
            case 3:
                System.out.println("Insira o novo email: ");
                String email = Ler.umaString();
                for (Cliente c : lista_cliente) {
                    if (c.getNif() == nif) {
                        c.setEmail(email);
                        System.out.println("Nome alterado com sucesso!");
                    }
                }
                break;
            case 4:
                System.out.println("Insira a nova idade: ");
                int idade = Ler.umInt();
                for (Cliente c : lista_cliente) {
                    if (c.getNif() == nif) {
                        c.setIdade(idade);
                        System.out.println("Idade alterada com sucesso!");
                    }
                }
                break;
        }

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Maia\\Documents\\UBI\\POO\\cliente.dat"));
            os.writeObject(lista_cliente);
            os.flush(); //
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

}
