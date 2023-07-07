package model;

import java.util.ArrayList;

public class Compra {
    private int id;
    private float totalCompra;
    private ArrayList<Roupa> roupas = new ArrayList<Roupa>();

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
        this.totalCompra = totalCompra;
    }

    public ArrayList<Roupa> getRoupas() {
        return roupas;
    }

    public void setRoupas(Roupa roupa) {
        if(this.roupas.size() == 0){
            this.totalCompra =roupa.getPreco();
        }
        this.roupas.add(roupa);
    }
}
