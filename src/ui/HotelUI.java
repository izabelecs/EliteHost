package ui;

import model.Reserva;
import service.Hotel;

import java.util.Date;
import javax.swing.*;
import java.awt.*;

public class HotelUI {

    private Hotel hotel = new Hotel();

    public void criarTela() {

        JFrame frame = new JFrame("Sistema de Hotel");

        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        JPanel top = new JPanel();

        JTextField nomeField = new JTextField(10);
        JTextField cpfField = new JTextField(10);
        JSpinner entradaField =
                new JSpinner(new SpinnerDateModel());
        JSpinner saidaField =
                new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor entradaEditor =
                new JSpinner.DateEditor(
                        entradaField,
                        "dd/MM/yyyy"
                );

        entradaField.setEditor(entradaEditor);

        JSpinner.DateEditor saidaEditor =
                new JSpinner.DateEditor(
                        saidaField,
                        "dd/MM/yyyy"
                );

        saidaField.setEditor(saidaEditor);
        String[] tipos = {"Simples", "Luxo", "Premium"};
        JComboBox<String> tipoBox =
                new JComboBox<>(tipos);
        JTextField cancelarField = new JTextField(5);

        JButton reservarBtn = new JButton("Reservar");
        JButton listarBtn = new JButton("Ver Reservas");
        JButton disponiveisBtn = new JButton("Quartos Livres");
        JButton cancelarBtn = new JButton("Cancelar");

        top.add(new JLabel("Nome:"));
        top.add(nomeField);

        top.add(new JLabel("CPF:"));
        top.add(cpfField);

        top.add(new JLabel("Entrada:"));
        top.add(entradaField);

        top.add(new JLabel("Saída:"));
        top.add(saidaField);
        top.add(new JLabel("Tipo:"));
        top.add(tipoBox);

        top.add(reservarBtn);

        JTextArea area = new JTextArea();

        JScrollPane scroll = new JScrollPane(area);


        JPanel bottom = new JPanel();

        bottom.add(listarBtn);

        bottom.add(disponiveisBtn);

        bottom.add(new JLabel("Quarto:"));
        bottom.add(cancelarField);

        bottom.add(cancelarBtn);


        reservarBtn.addActionListener(e -> {

            String nome = nomeField.getText();
            String cpf = cpfField.getText();
            String entrada =
                    entradaField.getValue().toString();

            String saida =
                    saidaField.getValue().toString();
            String tipo =
                    tipoBox.getSelectedItem().toString();

            String resultado =
                    hotel.reservarQuarto(
                            nome,
                            cpf,
                            entrada,
                            saida,
                            tipo
                    );

            area.append(resultado + "\n\n");
        });

        listarBtn.addActionListener(e -> {

            area.append("=== RESERVAS ===\n");

            for (Reserva r : hotel.listarReservas()) {
                area.append(r.getInfo() + "\n");
            }

            area.append("\n");
        });

        disponiveisBtn.addActionListener(e -> {

            area.append("=== QUARTOS DISPONÍVEIS ===\n");

            area.append(hotel.listarDisponiveis());

            area.append("\n");
        });

        cancelarBtn.addActionListener(e -> {

            int numero =
                    Integer.parseInt(cancelarField.getText());

            area.append(
                    hotel.cancelarReserva(numero) + "\n\n"
            );
        });


        area.setEditable(false);

        frame.add(top, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}