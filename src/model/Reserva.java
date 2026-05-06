// =======================
// Reserva.java
// package: model
// =======================

package model;

public class Reserva {

    private Cliente cliente;
    private Quarto quarto;
    private String dataEntrada;
    private String dataSaida;
    private double total;

    public Reserva(Cliente cliente,
                   Quarto quarto,
                   String dataEntrada,
                   String dataSaida) {

        this.cliente = cliente;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.total = quarto.getPreco();
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public String getInfo() {

        return "Cliente: " + cliente.getNome()
                + " | CPF: " + cliente.getCpf()
                + " | Quarto: " + quarto.getNumero()
                + " | Tipo: " + quarto.getTipo()
                + " | Entrada: " + dataEntrada
                + " | Saída: " + dataSaida
                + " | Valor: R$ " + total;
    }
}