package ui;

import javax.swing.*;
import java.awt.*;

public class LoginUI {

    public void criarTelaLogin() {

        JFrame frame = new JFrame("Login");

        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // ======================
        // IMAGEM
        // ======================

        ImageIcon icon =
                new ImageIcon("src/images/hotel.jpg");

        Image img =
                icon.getImage().getScaledInstance(
                        250,
                        180,
                        Image.SCALE_SMOOTH
                );

        ImageIcon imagemRedimensionada =
                new ImageIcon(img);

        JLabel imagem =
                new JLabel(imagemRedimensionada);

        imagem.setHorizontalAlignment(
                JLabel.CENTER
        );

        // ======================
        // CAMPOS
        // ======================

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(5, 1));

        JTextField usuarioField =
                new JTextField();

        JPasswordField senhaField =
                new JPasswordField();

        JButton entrarBtn =
                new JButton("Entrar");

        panel.add(new JLabel("Usuário"));
        panel.add(usuarioField);

        panel.add(new JLabel("Senha"));
        panel.add(senhaField);

        panel.add(entrarBtn);

        // ======================
        // AÇÃO LOGIN
        // ======================

        entrarBtn.addActionListener(e -> {

            String usuario =
                    usuarioField.getText();

            String senha =
                    new String(
                            senhaField.getPassword()
                    );

            if (usuario.equals("admin")
                    && senha.equals("123")) {

                frame.dispose();

                HotelUI hotel =
                        new HotelUI();

                hotel.criarTela();

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Login inválido"
                );
            }
        });

        // ======================
        // MONTAGEM
        // ======================

        frame.add(imagem, BorderLayout.NORTH);

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}