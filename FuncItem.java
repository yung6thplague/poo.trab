import myinputs.Ler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Random;

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
        System.out.println("Insira a idade mínima do item.");
        int idademinima = Ler.umInt();
        System.out.println("Insira a data da compra (YYYY-MM-DD): ");
        LocalDate dataCompra = LocalDate.parse(Ler.umaString());
        Item i1 = new Item(codigo, nome, descricao, custo, requisitos, idademinima, dataCompra);
        if (!lista.contains(i1)) {
            lista.add(i1);
        } else {
            throw new NaoEncontreiException("Item já existe na lista!");
        }
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\rodri\\OneDrive\\Documentos\\POO\\item.dat"));
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
            if (lista.get(i).getCodigo() == codigo) {
                lista.remove(i);
                alterou = true;
            }
        }
        if (!alterou) {
            throw new NaoEncontreiException("Produto não encontrado!");
        }
        System.out.println("O produto  foi eliminado com sucesso!");
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\rodri\\OneDrive\\Documentos\\POO\\item.dat"));
            os.writeObject(lista);
            os.flush(); //
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void atualizarItem(ArrayList<Item> lista) throws NaoEncontreiException {
        System.out.println("Insira a referência do item que deseja atualizar.");
        int codigo = Ler.umInt();
        boolean check = false;
        for (Item item : lista) {
            if (item.getCodigo() == codigo) {
                check = true;
            }
        }
        if (!check) {
            throw new NaoEncontreiException("Produto não encontrado! ");
        }
        System.out.println("O que pretende alterar? (1- Referência, 2- Nome, 3- Descrição, 4- Custo, 5- Requisitos, 6- Idade Mínima.) ");
        int escolha = Ler.umInt();
        switch (escolha) {
            case 1:
                System.out.println("Insira a nova referência: ");
                int cod2 = Ler.umInt();
                for (Item i1 : lista) {
                    if (i1.getCodigo() == codigo) {
                        i1.setCodigo(cod2);
                        System.out.println("Referência alterada com sucesso!");
                    }
                }
                break;
            case 2:
                System.out.println("Insira o novo nome: ");
                String nome = Ler.umaString();
                for (Item i1 : lista) {
                    if (i1.getCodigo() == codigo) {
                        i1.setNome(nome);
                        System.out.println("Nome alterado com sucesso!");
                    }
                }
                break;
            case 3:
                System.out.println("Insira a nova descrição: ");
                String desc = Ler.umaString();
                for (Item i1 : lista) {
                    if (i1.getCodigo() == codigo) {
                        i1.setDescricao(desc);
                        System.out.println("Descrição alterada com sucesso!");
                    }
                }
                break;
            case 4:
                System.out.println("Insira o novo custo: ");
                double custo = Ler.umDouble();
                for (Item i1 : lista) {
                    if (i1.getCodigo() == codigo) {
                        i1.setCusto(custo);
                        System.out.println("Custo alterado com sucesso!");
                    }
                }
                break;
            case 5:
                System.out.println("Insira os novos requisitos: ");
                String requisitos = Ler.umaString();
                for (Item i1 : lista) {
                    if (i1.getCodigo() == codigo) {
                        i1.setRequisitos(requisitos);
                        System.out.println("Requisitos alteradas com sucesso!");
                    }
                }
                break;
            case 6:
                System.out.println("Insira a nova idade mínima: ");
                int idademinima = Ler.umInt();
                for (Item i1 : lista) {
                    if (i1.getCodigo() == codigo) {
                        i1.setIdademinima(idademinima);
                        System.out.println("Idade mínima alterada com sucesso!");
                    }
                }
                break;
        }


        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\rodri\\OneDrive\\Documentos\\POO\\item.dat"));
            os.writeObject(lista);
            os.flush(); //
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void registarVenda(String filePathItens, ArrayList<Cliente> listaClientes) {
        ArrayList<Item> listaItens = carregarItens(filePathItens);
        ArrayList<Item> itensComprados = new ArrayList<>();
        filePathItens = "C:\\\\Users\\\\rodri\\\\OneDrive\\\\Documentos\\\\POO\\\\item.dat\"";

        System.out.println("Insira a referência dos itens que foram vendidos. (Prima 0 quando quiser terminar.)");
        int codigo;

        do {
            codigo = Ler.umInt();
            if (codigo == 0) {
                break; // Sai do loop se o código for 0
            }
            boolean encontrado = false;
            for (Item item : listaItens) {
                if (item.getCodigo() == codigo) {
                    encontrado = true;
                    itensComprados.add(item);
                    System.out.println("Item " + item.getNome() + " registrado como vendido.");
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Produto não encontrado!");
            }
        } while (true);

        System.out.println("Insira o NIF do cliente: ");
        int nif = Ler.umInt();
        Cliente cliente = null;

        for (Cliente c : listaClientes) {
            if (c.getNif() == nif) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente não registado. Deseja registar este cliente? (S/N)");
            String resposta = Ler.umaString();
            if (resposta.equals("S")) {
                FuncCliente.adicionarCliente(listaClientes, listaItens);
                for (Cliente c : listaClientes) {
                    if (c.getNif() == nif) {
                        cliente = c;
                        break;
                    }
                }
            }
                    else {
                System.out.println("Venda cancelada, pois o cliente não está registado.");
                return;
            }
        }

        for (Item item : itensComprados) {
            item.setDataCompra(LocalDate.now()); // Define a data de compra para o item
            cliente.getLista_compra().add(item);   //verificar
        }
        System.out.println("Venda registada com sucesso para o cliente " + cliente.getNome() + ".");
        System.out.println("Deseja gerar fatura para esta venda? (S/N)");
        String respostaFatura = Ler.umaString().toUpperCase();
        if (respostaFatura.equals("S")) {
            int numeroFatura = (int) (Math.random() * 100000);
            LocalDate dataAtual = LocalDate.now();
            List<Integer> quantidades = new ArrayList<>();
            for (Item item : itensComprados) {
                quantidades.add(1);
            }

            Fatura.imprimirFatura(numeroFatura, dataAtual, cliente, quantidades, itensComprados);
        } else {
            System.out.println("Fatura não gerada.");
        }
    }


    public static ArrayList<Item> carregarItens(String filePath) {
        ArrayList<Item> lista = new ArrayList<>();
        filePath = "C:\\Users\\rodri\\OneDrive\\Documentos\\POO\\item.dat";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            lista = (ArrayList<Item>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar itens: " + e.getMessage());
        }
        return lista;
    }
}
