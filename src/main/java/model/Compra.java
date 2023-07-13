package model;

import java.util.ArrayList;

public class Compra {
    private int id;
    private float totalCompra = 0;
    private ArrayList<Roupa> roupas = new ArrayList<Roupa>();

    private Usuario cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(float totalCompra) {
        this.totalCompra += totalCompra;
    }

    public ArrayList<Roupa> getRoupas() {
        return roupas;
    }

    public void setRoupas(Roupa roupa) {
        //roupa.setQuantidade(+1);
        this.roupas.add(roupa);
        this.setTotalCompra(roupa.getPreco());
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
}
