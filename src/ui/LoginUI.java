package ui;

import service.AuthService;

import javax.swing.*;
import java.awt.*;

public class LoginUI {

    private AuthService auth =
            new AuthService();

    public void criarTelaLogin() {

        JFrame frame = new JFrame("StayEase Login");

        frame.setSize(450, 550);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setLayout(new BorderLayout());

        frame.getContentPane().setBackground(
                new Color(245,245,245)
        );



        ImageIcon icon =
                new ImageIcon("src/images/EliteHost.png");

        Image img =
                icon.getImage().getScaledInstance(
                        200,
                        200,
                        Image.SCALE_SMOOTH
                );

        ImageIcon imagemRedimensionada =
                new ImageIcon(img);

        JLabel imagem =
                new JLabel(imagemRedimensionada);

        imagem.setHorizontalAlignment(
                JLabel.CENTER
        );


        JLabel titulo =
                new JLabel("");

        titulo.setFont(
                new Font(
                        "Times New Roman",
                        Font.BOLD,
                        28
                )
        );

        titulo.setHorizontalAlignment(
                JLabel.CENTER
        );



        JPanel panel = new JPanel();

        panel.setBackground(
                new Color(245,245,245)
        );

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        40,
                        20,
                        40
                )
        );

        panel.setLayout(
                new GridLayout(8,1,10,10)
        );

        JTextField usuarioField =
                new JTextField();

        JPasswordField senhaField =
                new JPasswordField();

        JButton entrarBtn =
                new JButton("Entrar");

        JButton cadastrarBtn =
                new JButton("Cadastrar");



        entrarBtn.setBackground(
                new Color(52,152,219)
        );

        entrarBtn.setForeground(Color.WHITE);

        cadastrarBtn.setBackground(
                new Color(46,204,113)
        );

        cadastrarBtn.setForeground(Color.WHITE);



        panel.add(new JLabel("Usuário"));
        panel.add(usuarioField);

        panel.add(new JLabel("Senha"));
        panel.add(senhaField);

        panel.add(entrarBtn);

        panel.add(cadastrarBtn);



        entrarBtn.addActionListener(e -> {

            String usuario =
                    usuarioField.getText();

            String senha =
                    new String(
                            senhaField.getPassword()
                    );

            if (auth.login(usuario, senha)) {

                frame.dispose();

                HotelUI hotel =
                        new HotelUI();

                hotel.criarTela();

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Usuário ou senha inválidos!"
                );
            }
        });



        cadastrarBtn.addActionListener(e -> {

            String usuario =
                    usuarioField.getText();

            String senha =
                    new String(
                            senhaField.getPassword()
                    );

            boolean sucesso =
                    auth.cadastrar(
                            usuario,
                            senha
                    );

            if (sucesso) {

                JOptionPane.showMessageDialog(
                        null,
                        "Cadastro realizado!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Usuário já existe!"
                );
            }
        });

        // ======================
        // MONTAGEM
        // ======================

        frame.add(imagem, BorderLayout.NORTH);

        frame.add(titulo, BorderLayout.CENTER);

        frame.add(panel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}