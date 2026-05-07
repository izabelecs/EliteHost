package model;

public class Quarto implements Reservavel {

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

    @Override
    public void reservar() {
        disponivel = false;
    }

    @Override
    public void liberar() {
        disponivel = true;
    }
}