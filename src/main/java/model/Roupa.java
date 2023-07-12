package model;

public class Roupa {
    private int id;
    private String nome;
    private String tamanho;
    private int preco;
    private String cor;
    private String descricao;
    private int quantidade = 0;

    public Roupa() {
    }

    public Roupa(String nome, String tamanho, int preco, String cor, String descricao) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.preco = preco;
        this.cor = cor;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }
}
