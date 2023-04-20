package acesso;
import java.util.Scanner;

// Main class
public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //adicionar objeto loja
        Loja loja = new Loja("Papelaria Gomes");

        //adicionar produtos
        Produto caneta = new Produto("Caneta", "azul", 3.00F, 25);
        Produto caderno = new Produto("Caderno", "96 folhas", 25.00F, 20);
        Produto lapis = new Produto("Lapis", "HB", 1.00F, 5);

        //adicionar produto ao arraylist
        loja.addProduto(caneta);
        loja.addProduto(caderno);
        loja.addProduto(lapis);

        //Adicionar vendedor
        Vendedor manoel = new Vendedor("Manoel Gomes", 1);
        Vendedor joao = new Vendedor("João Gomes", 2);
        Vendedor ciro = new Vendedor("Ciro Gomes", 3);

        //adiciona vendedor no arrayList
        loja.addVendedor(manoel);
        loja.addVendedor(joao);
        loja.addVendedor(ciro);

        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("------------------------BEM VINDO A "+loja.getNome().toUpperCase()+"!!-------------------------");
        System.out.println();
        boolean comprando = true;
        while (comprando) {
            System.out.println("-----------------------------O QUE DESEJA FAZER?------------------------------");
            System.out.println();
            System.out.println("DIGITE [ 1 ] PARA REGISTRAR NOVAS VENDAS.");
            System.out.println("DIGITE [ 2 ] CASO QUEIRA REGISTRAR AS VENDAS ANTES SUGERIDAS.");
            System.out.println("DIGITE [ 3 ] CASO NÃO QUEIRA ADICIONAR VENDAS E MOSTRAR O RELATÓRIO.");
            System.out.println("DIGITE [ 4 ] SE DESEJA SABER O VENDEDOR COM MAIS VENDAS.");
            System.out.println("DIGITE [ 5 ] SE DESEJA FECHAR O PROGRAMA.");
          
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:

                    System.out.println("DIGITE O MATRICULA DO VENDEDOR: ");
                    System.out.println("[1] Manoel Gomes \n[2] João Gomes \n[3] Ciro Gomes \n");
                    int matricula = input.nextInt();

                    System.out.println("Quantas vendas deseja adicionar? ");
                    int novasVendas = input.nextInt();

                    for (int i = 0; i < novasVendas; i++) {
                        //REGISTRANDO NOVAS VENDAS DO USUÁRIO

                        System.out.println("Que produto deseja comprar?");
                        System.out.println("[1] Caneta \n[2] Caderno \n[3] Lapis");
                        int produto = input.nextInt();
                        System.out.println("Quantas unidades deseja? ");
                        int quantidade = input.nextInt();

                        if (matricula == 1) {
                            if (produto == 1) {
                                loja.registrarVenda(manoel, caneta, quantidade);
                            }
                            if (produto == 2) {
                                loja.registrarVenda(manoel, caderno, quantidade);
                            }
                            if (produto == 3) {
                                loja.registrarVenda(manoel, lapis, quantidade);
                            }
                        }
                        if (matricula == 2) {
                            if (produto == 1) {
                                loja.registrarVenda(joao, caneta, quantidade);
                            }
                            if (produto == 2) {
                                loja.registrarVenda(joao, caderno, quantidade);
                            }
                            if (produto == 3) {
                                loja.registrarVenda(joao, lapis, quantidade);
                            }
                        }
                        if (matricula == 3) {
                            if (produto == 1) {
                                loja.registrarVenda(ciro, caneta, quantidade);
                            }
                            if (produto == 2) {
                                loja.registrarVenda(ciro, caderno, quantidade);
                            }
                            if (produto == 3) {
                                loja.registrarVenda(ciro, lapis, quantidade);
                            }
                        }
                    }
                    break;

                case 2:

                    loja.registrarVenda(manoel, caneta, 5);
                    loja.registrarVenda(manoel, caderno, 2);
                    loja.registrarVenda(joao, lapis, 3);
                    loja.registrarVenda(ciro, lapis, 2);
                    loja.registrarVenda(manoel, caneta, 10);
                    loja.registrarVenda(joao, caderno, 9);
                    loja.registrarVenda(manoel, lapis, 1);
                    loja.registrarVenda(ciro, caderno, 2);
                    loja.registrarVenda(ciro, caneta, 2);
                    break;

                case 3:
                    //RESULTADO
                    loja.mostrarRelatorioCompleto();
                    loja.mostrarEstoque();
                    break;
                
                 case 4:
	                Vendedor vendedorMaisVendas = loja.vendedorMaisVendas();
	                	if (vendedorMaisVendas != null) {
		        		        System.out.println("O vendedor com a maior quantidade de vendas é " + vendedorMaisVendas.getNome());
		        		    } else {
		        		        System.out.println("Nenhum vendedor encontrado.");
		        		    }
	                	
	                	
	                    break;

	                case 5:
	                    System.out.println("-----------------Obrigado por utilizar o programa!!-------------------");
	                    comprando = false;
	                    break;


                default:
                    System.out.println();
                    System.out.println("Digite uma opção válida!");
                    System.out.println();
                    break;
            }
        }

    }
}