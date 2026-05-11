package ui;

import model.Usuario;

import javax.swing.*;
import java.awt.*;

public class CadastroUI {

    public void criarTelaCadastro() {

        JFrame frame = new JFrame("Cadastro");

        frame.setSize(400, 300);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        20,
                        20,
                        20
                )
        );

        panel.setLayout(
                new GridLayout(5, 1, 10, 10)
        );

        JTextField usuarioField =
                new JTextField();

        JPasswordField senhaField =
                new JPasswordField();

        JButton cadastrarBtn =
                new JButton("Cadastrar");

        panel.add(new JLabel("Novo usuário"));
        panel.add(usuarioField);

        panel.add(new JLabel("Nova senha"));
        panel.add(senhaField);

        panel.add(cadastrarBtn);

        cadastrarBtn.addActionListener(e -> {

            Usuario.usuarioCadastrado =
                    usuarioField.getText();

            Usuario.senhaCadastrada =
                    new String(
                            senhaField.getPassword()
                    );

            JOptionPane.showMessageDialog(
                    null,
                    "Conta criada com sucesso!"
            );

            frame.dispose();

            LoginUI login =
                    new LoginUI();

            login.criarTelaLogin();

        });

        frame.add(panel);

        frame.setVisible(true);
    }
}