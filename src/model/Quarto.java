// =======================
// Quarto.java
// package: model
// =======================

package model;

public class Quarto {

    private int numero;
    private String tipo;
    private double preco;
    private boolean disponivel = true;

    public Quarto(int numero, String tipo, double preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void reservar() {
        disponivel = false;
    }

    public void liberar() {
        disponivel = true;
    }
}