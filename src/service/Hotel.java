// =======================
// Hotel.java
// package: service
// =======================

package service;

import model.Cliente;
import model.Quarto;
import model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private List<Quarto> quartos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public Hotel() {

        quartos.add(new Quarto(1, "Simples", 120));
        quartos.add(new Quarto(2, "Luxo", 250));
        quartos.add(new Quarto(3, "Simples", 120));
        quartos.add(new Quarto(4, "Luxo", 250));
        quartos.add(new Quarto(5, "Premium", 400));
    }

    public String reservarQuarto(String nome,
                                 String cpf,
                                 String entrada,
                                 String saida,
                                 String tipo) {

        Cliente cliente = new Cliente(nome, cpf);

        for (Quarto q : quartos) {

            if (q.isDisponivel()
                    && q.getTipo().equals(tipo)) {

                q.reservar();

                Reserva reserva =
                        new Reserva(cliente, q,
                                entrada, saida);

                reservas.add(reserva);

                return "Reserva feita com sucesso!\n"
                        + "Quarto: " + q.getNumero()
                        + " | Tipo: " + q.getTipo();
            }
        }

        return "Nenhum quarto disponível";
    }

    public String cancelarReserva(int numeroQuarto) {

        for (Reserva r : reservas) {

            if (r.getQuarto().getNumero() == numeroQuarto) {

                r.getQuarto().liberar();
                reservas.remove(r);

                return "Reserva cancelada!";
            }
        }

        return "Reserva não encontrada";
    }

    public List<Reserva> listarReservas() {
        return reservas;
    }

    public String listarDisponiveis() {

        StringBuilder sb = new StringBuilder();

        for (Quarto q : quartos) {

            if (q.isDisponivel()) {

                sb.append("Quarto ")
                        .append(q.getNumero())
                        .append(" | ")
                        .append(q.getTipo())
                        .append(" | R$ ")
                        .append(q.getPreco())
                        .append("\n");
            }
        }

        return sb.toString();
    }
}