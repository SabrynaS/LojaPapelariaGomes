package acesso;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Vendedor{
    private String nome;
    private int matricula;
    public HashMap <Produto, Integer> vendas = new HashMap<>();

    //metodos construtores
    public Vendedor() {}

    public Vendedor( String nome,int matricula){
        this.nome = nome;
        this.matricula = matricula;
    }

    //getters
    public String getNome(){
        return nome;
    }
    public int getMatricula(){
        return matricula;
    }
    public HashMap <Produto,Integer> getVendas(){
        return vendas;
    }



    //and setters
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    public void setVendas(HashMap<Produto,Integer> getVendas){
        this.vendas = vendas;
    }

    //metodos adicionais

    //mostrarRelatorio( ) – mostra o nome, descrição e a quantidade dos produtos vendidos pelo
    //vendedor, por fim, o valor total vendido;

    public void mostrarRelatorio() {
        float valorTotal = 0;
        int quantidadeTotal = 0;


        //mapear e seguir o hashMap
        for(Map.Entry<Produto,Integer> entry: vendas.entrySet()){
            //pega quantidade  <Integer>
            quantidadeTotal += entry.getValue();
            //pega a key <Produto> e o valor e multiplica pela quantidade  <Integer>
            valorTotal += entry.getKey().getValor() * entry.getValue();

            //printando nome do produto e descrição
            System.out.println("Produto: "+ entry.getKey().getNome());
            System.out.println("Descrição: "+ entry.getKey().getDescricao());
            System.out.println("Unidades vendidas: "+entry.getValue());
        }
        System.out.println("----------------------------RELATORIO DO VENDEDOR-----------------------------");
        System.out.println("Vendas Total : "+ quantidadeTotal);
        System.out.println("Valor Total: "+ valorTotal);
        System.out.println("------------------------------------------------------------------------------");
    }

    public int vendedorQtdFinal () {
        int qtdFinal = 0;
        for (Map.Entry<Produto,Integer> entry : vendas.entrySet()){
            qtdFinal += entry.getValue();
        }
        return qtdFinal;
    }

    public float vendedorValorFinal(){
        int valorFinal = 0;
        for (Map.Entry<Produto,Integer> entry : vendas.entrySet()){
            valorFinal += entry.getKey().getValor()* entry.getValue();
        }
        return valorFinal;
    }



}
