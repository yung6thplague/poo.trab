import myinputs.Ler;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GerirLoja {

    private static int menu() {
        int opcao;
        System.out.println("Seja bem-vind@ à loja de software! Por favor indique a sua escolha!");
        System.out.println("1 - Consultar catálogo de softwares de segurança.");
        System.out.println("2 - Consultar catálogo de sistemas operacionais");
        System.out.println("3 - Consultar catálogo de aplicativos");
        System.out.println("4 - Consultar catálogo de programas especializados");
        System.out.println("5 - Consultar estatísticas sobre loja.");
        System.out.println("6 – Consultar vendas a clientes.");
        System.out.println("7 - Registrar Venda");
        System.out.println("8 - Sair");
        System.out.println("\n");
        opcao = Ler.umInt();
        return opcao;
    }

    private static int menu_soft_segur() {
        int opcao;
        System.out.println("----- Catálogo de softwares de segurança -----");
        System.out.println("1 - Consultar softwares de segurança disponíveis.");
        System.out.println("2 - Adicionar software de segurança.");
        System.out.println("3 - Eliminar software de segurança.");
        System.out.println("4 - Atualizar software de segurança.");
        System.out.println("5 - Sair");
        System.out.println("\n");
        opcao = Ler.umInt();
        return opcao;
    }

    private static int menu_sist_oper() {
        int opcao;
        System.out.println("----- Catálogo de sistemas operacionais -----");
        System.out.println("1 - Consultar sistemas operacionais disponíveis.");
        System.out.println("2 - Adicionar sistema operacional.");
        System.out.println("3 - Eliminar sistema operacional.");
        System.out.println("4 - Atualizar sistema operacional.");
        System.out.println("5 - Sair");
        System.out.println("\n");
        opcao = Ler.umInt();
        return opcao;
    }

    private static int menu_apt() {
        int opcao;
        System.out.println("----- Catálogo de aplicativos -----");
        System.out.println("1 - Consultar aplicativos disponíveis.");
        System.out.println("2 - Adicionar aplicativo.");
        System.out.println("3 - Eliminar aplicativo.");
        System.out.println("4 - Atualizar aplicativo.");
        System.out.println("5 - Sair");
        System.out.println("\n");
        opcao = Ler.umInt();
        return opcao;
    }

    private static int menu_prog_espec() {
        int opcao;
        System.out.println("----- Catálogo de programas especializados -----");
        System.out.println("1 - Consultar programas especializados disponíveis.");
        System.out.println("2 - Adicionar programa especializado.");
        System.out.println("3 - Eliminar programa especializado.");
        System.out.println("4 - Atualizar programa especializado.");
        System.out.println("5 - Sair");
        System.out.println("\n");
        opcao = Ler.umInt();
        return opcao;
    }

    private static int menu_stats() {
        int opcao;
        System.out.println("----- Estatísticas da Loja -----");
        System.out.println("1 - Itens mais vendidos.");
        System.out.println("2 - Melhores clientes.");
        System.out.println("3 - Valor faturado.");
        System.out.println("4 - Sair");
        System.out.println("\n");
        opcao = Ler.umInt();
        return opcao;
    }
    private static int menu_stats2(){
        int opcao;
        System.out.println("Deseja verificar em que intervalo de tempo?");
        System.out.println("1- Faturamento geral.");
        System.out.println("2- Faturamento diário.");
        System.out.println("3- Faturamento semanal.");
        System.out.println("4- Faturamento mensal.");
        System.out.println("\n");
        opcao = Ler.umInt();
        return opcao;
    }

    private static int menu_cliente() {
        int opcao;
        System.out.println("----- Clientes -----");
        System.out.println("1 - Consultar lista de clientes.");
        System.out.println("2 - Atualizar lista de clientes.");
        System.out.println("3 - Eliminar clientes.");
        System.out.println("4 - Adicionar clientes.");
        System.out.println("5 - Sair");
        System.out.println("\n");
        opcao = Ler.umInt();
        return opcao;
    }
    private static int menu_venda() {
        int opcao;
        System.out.println("----- Registrar Venda  -----");
        System.out.println("1- Começar a registrar a venda.");
        System.out.println("2 - Sair");
        System.out.println("\n");
        opcao = Ler.umInt();
        return opcao;
    }


    public static void main(String[] args) throws IOException {
        int escolha, escolha_soft_segur, escolha_sist_oper, escolha_apt, escolha_prog_espec, escolha_stats, escolha_stats2, escolha_cliente, escolha_venda;
        ArrayList<Cliente> lista_clientes = new ArrayList<Cliente>();
        ArrayList<Item> lista_item = new ArrayList<Item>();
        ObjectInputStream is = new ObjectInputStream( new FileInputStream("C:\\Users\\rodri\\OneDrive\\Documentos\\POO\\item.dat"));
        ObjectInputStream is_cliente = new ObjectInputStream(new FileInputStream("C:\\Users\\rodri\\OneDrive\\Documentos\\POO\\cliente.dat"));
        try {
            if (is == null || is_cliente == null) {
                throw new IOException("Can't find file.");
            }


            while (true) {
                lista_item = (ArrayList<Item>) is.readObject();
                lista_clientes = (ArrayList<Cliente>) is_cliente.readObject();
            }
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (is != null || is_cliente != null) {
                    is.close();
                    is_cliente.close();
                }
            } catch (IOException closeException) {
                closeException.printStackTrace();
            }
        }
        do{
            escolha = menu();
            switch (escolha){
                case 1:
                    do{
                        escolha_soft_segur = menu_soft_segur();
                        switch (escolha_soft_segur){
                            case 1:

                                System.out.println(lista_item.toString());
                                break;
                            case 2:
                                FuncItem.adicionarItem(lista_item);
                                break;
                            case 3:
                                FuncItem.eliminarItem(lista_item);
                                break;
                            case 4:
                                FuncItem.atualizarItem(lista_item);
                                break;
                        }
                    } while (escolha_soft_segur != 5);
                    break;
                case 2:
                    do{
                        escolha_sist_oper = menu_sist_oper();
                        switch (escolha_sist_oper){
                            case 1:
                                System.out.println(lista_item.toString());
                                break;
                            case 2:
                                FuncItem.adicionarItem(lista_item);
                                break;
                            case 3:
                                FuncItem.eliminarItem(lista_item);
                                break;
                            case 4:
                                FuncItem.atualizarItem(lista_item);
                                break;
                        }
                    } while (escolha_sist_oper != 5);
                    break;
                case 3:
                    do{
                        escolha_apt = menu_apt();
                        switch (escolha_apt) {
                            case 1:
                                System.out.println(lista_item.toString());
                                break;
                            case 2:
                                FuncItem.adicionarItem(lista_item);
                                break;
                            case 3:
                                FuncItem.eliminarItem(lista_item);
                                break;
                            case 4:
                                FuncItem.atualizarItem(lista_item);
                                break;
                        }
                    } while (escolha_apt != 5);
                    break;
                case 4:
                    do{
                        escolha_prog_espec = menu_prog_espec();
                        switch (escolha_prog_espec) {
                            case 1:
                                System.out.println(lista_item.toString());
                                break;
                            case 2:
                                FuncItem.adicionarItem(lista_item);
                                break;
                            case 3:
                                FuncItem.eliminarItem(lista_item);
                                break;
                            case 4:
                                FuncItem.atualizarItem(lista_item);
                                break;
                        }
                    } while (escolha_prog_espec!=5);
                    break;
                case 5:
                    do{
                        escolha_stats = menu_stats();
                        switch (escolha_stats) {
                            case 1:
                                Stats.produtosVendidos();
                            case 2:
                                Stats.melhoresClientes();
                            case 3:
                            do{
                                escolha_stats2 = menu_stats2();
                                switch(escolha_stats2){
                                    case 1:
                                        Stats.calcularFaturamento();
                                        case 2:
                                            Stats.faturamentoDiario();
                                    case 3:
                                        Stats.faturamentoSemanal();
                                    case 4:
                                        Stats.faturamentoMensal();




                                }

                            }while (escolha_stats2 != 5);



                        }
                    } while (escolha_stats !=4 );
                    break;
                case 6:
                    do{
                        escolha_cliente = menu_cliente();
                        switch (escolha_cliente) {
                            case 1:
                                System.out.println(lista_clientes.toString());
                                break;
                            case 2:
                                FuncCliente.adicionarCliente(lista_clientes, lista_item);
                                break;

                        }


                    } while (escolha_cliente != 5);
                    break;
                case 7:
                    do{
                        escolha_venda = menu_venda();
                        switch (escolha_venda) {
                            case 1:
                                FuncItem.registarVenda("C:\\Users\\rodri\\OneDrive\\Documentos\\POO\\item.dat",lista_clientes);
                                break;

                        }


                    } while (escolha_venda != 2);
                    break;
            }



        } while(escolha != 8);

    }

}