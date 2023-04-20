package acesso;
public class Produto {

    private String nome;
    private String descricao;
    private float valor;
    private int estoque;


    //metodos construtores
    public Produto() {

    }

    public Produto(String nome,String descricao,float valor,int estoque){
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.estoque = estoque;
    }

    //metodos de acesso
    //GETTERS
    public String getNome(){
        return this.nome;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public float getValor(){
        return this.valor;
    }
    public int getEstoque(){
        return this.estoque;
    }

    //SETTERS
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setDescricao(String descricao){
        this.descricao=descricao;
    }
    public void setValor(float valor){
        this.valor=valor;
    }
    public void setEstoque(int estoque){
        this.estoque=estoque;
    }

}



