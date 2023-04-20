package acesso;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Loja {

    private String nome;
    ArrayList<Vendedor> vendedores = new ArrayList<>();
    ArrayList<Produto> produtos = new ArrayList<>();

    //metodos construtores
    public Loja() {
    }

    public Loja(String nome) {
        this.nome = nome;
    }

    //GETTERS
    public String getNome() {
        return this.nome;
    }

    //SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    //metodos adicionais

    //adicionar vendendor ao array de vendedores
    public void addVendedor(Vendedor vendedor) {
        this.vendedores.add(vendedor);
    }

    //adicionar produtos ao array de produtos
    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }


    //registrarVenda(. . .) – adiciona para o Vendedor v a venda do Produto p, na quantidade informada.

    public void registrarVenda(Vendedor v, Produto p, int quantidade) {
    	
        //ver se temos estoque sobrando
    	if (quantidade>0) {
        if (quantidade <= p.getEstoque()) {

            //altera a quantidade no estoque
            p.setEstoque(p.getEstoque() - quantidade);

            //adicionar venda ao vendedor
            //é criada uma nova variável de HashMap chamada vendas para armazenar as vendas do vendedor v
            HashMap<Produto, Integer> vendas = v.getVendas();

            //verificar se o vendendor ja vendeu algum produto
            //se ele ja vendeu, precisamos adicionar a venda para alguma variavel que armazene isso
            if (vendas.containsKey(p)) {
                int vendasAntes = vendas.get(p);
                //adicionando novas vendas ao hashmap
                vendas.put(p, vendasAntes + quantidade);
            }
            //caso ainda nao tenha vendido o produto P, adicionaremos ele no hashmap como um novo produto
            else {
                vendas.put(p, quantidade);
            }
        } else {
            System.out.println("-----------------------------PROBLEMAS NA COMPRA------------------------------");
            System.out.println("A quantidade de produto " + p.getNome() + " que o vendedor " + v.getNome() + " quer vender é maior do que o estoque!");
            System.out.println("Portanto, a compra nao será registrada!");
            System.out.println();
        }
    	}
        else {
        	System.out.println("NÃO É POSSIVEL ADICIONAR VALORES NEGATIVOS!");
        	}
    	
    }

    //mostrarRelatorioCompleto( ) – mostra o código e o nome de cada vendedor,
    //juntamente com seu relatório individual, por fim, o somatório das vendas de todos;

    public void mostrarRelatorioCompleto() {
        float valorTotal = 0;
        int qtdTotal = 0;
        for (Vendedor v : vendedores){
            System.out.println("------------------------------DADOS DO VENDEDOR-------------------------------");
            System.out.println("Nome do Vendedor: " + v.getNome());
            System.out.println("Matricula do vendedor: " + v.getMatricula());
            v.mostrarRelatorio();
        }
        for (Vendedor v : vendedores) {
            //pegando o valor de cada vendendor e somando
            valorTotal += v.vendedorValorFinal();
            //pegando a quantidade de cada vendendor e somando
            qtdTotal += v.vendedorQtdFinal();
        }
        System.out.println("---------------------RELATORIO COMPLETO DA "+getNome().toUpperCase()+"--------------------");
        System.out.println();
        System.out.println("Valor total vendido em produtos pela Loja: "+ valorTotal);
        System.out.println("Quantidade total de produtos vendidos pela Loja: "+ qtdTotal);
        System.out.println();
    }

    //mostrarEstoque( ) – mostra o valor e a quantidade restante de cada produto;

    public void mostrarEstoque(){
        int qtdRestante=0;
        float valorRestante=0;
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("---------------------RELATORIO ESTOQUE DA "+getNome().toUpperCase()+"---------------------");
        System.out.println();

        for (Produto p : produtos){

            //GUARDANDO OS PRODUTOS RESTANTES
            //NAO SERIA NECESSARIO UTILIZAR VARIAVEIS, POREM ELAS FACILITAM A VISUALIZAÇÃO
            qtdRestante =p.getEstoque();
            valorRestante = p.getValor() * p.getEstoque();

            System.out.println("PRODUTO: "+ p.getNome());
            System.out.println("QUANTIDADE RESTANTE: "+ qtdRestante);
            System.out.println("VALOR RESTANTE: " + valorRestante);
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------------");
    }
    public Vendedor vendedorMaisVendas() {
		    Vendedor vendedorComMaiorQuantidadeDeVendas = null;
		    int maiorQuantidadeDeVendas = 0;
		   

		    for (Vendedor v : vendedores) {
		        int quantidadeTotalDeVendasDoVendedor = 0;
		        
		        

		        HashMap <Produto, Integer> vendas = v.getVendas();

		        for (Map.Entry<Produto, Integer> entry :vendas.entrySet()) {
		            quantidadeTotalDeVendasDoVendedor += entry.getValue();
		        }

		        if (quantidadeTotalDeVendasDoVendedor > maiorQuantidadeDeVendas) {
		            vendedorComMaiorQuantidadeDeVendas = v;
		            maiorQuantidadeDeVendas = quantidadeTotalDeVendasDoVendedor;
		        }
		        //System.out.println(quantidadeTotalDeVendasDoVendedor);
		        
		       
		    }
		    
		 

		    return vendedorComMaiorQuantidadeDeVendas;
		}

}