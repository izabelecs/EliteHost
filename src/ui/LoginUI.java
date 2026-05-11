package ui;

import model.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginUI {

    public void criarTelaLogin() {

        JFrame frame = new JFrame("Login");

        frame.setSize(500, 600);

        frame.setMinimumSize(
                new Dimension(400, 500)
        );

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);
        

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(
                new GridBagLayout()
        );

        mainPanel.setBackground(
                new Color(245, 245, 245)
        );

        frame.setContentPane(mainPanel);


        JPanel card = new JPanel();

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        card.setBackground(Color.WHITE);

        card.setBorder(
                new EmptyBorder(
                        30,
                        40,
                        30,
                        40
                )
        );

        card.setMaximumSize(
                new Dimension(350, 500)
        );



        ImageIcon icon =
                new ImageIcon(
                        "src/images/hotel.jpg"
                );

        Image img =
                icon.getImage().getScaledInstance(
                        220,
                        150,
                        Image.SCALE_SMOOTH
                );

        JLabel imagem =
                new JLabel(
                        new ImageIcon(img)
                );

        imagem.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JLabel titulo =
                new JLabel("Hotel Login");

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        titulo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );



        JTextField usuarioField =
                new JTextField();

        usuarioField.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        JPasswordField senhaField =
                new JPasswordField();

        senhaField.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );


        JButton entrarBtn =
                new JButton("Entrar");

        entrarBtn.setBackground(
                new Color(33, 150, 243)
        );

        entrarBtn.setForeground(
                Color.WHITE
        );

        entrarBtn.setFocusPainted(false);

        entrarBtn.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        45
                )
        );

        JButton cadastroBtn =
                new JButton("Criar conta");

        cadastroBtn.setFocusPainted(false);

        cadastroBtn.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        45
                )
        );


        entrarBtn.addActionListener(e -> {

            String usuario =
                    usuarioField.getText();

            String senha =
                    new String(
                            senhaField.getPassword()
                    );

            if (usuario.equals(
                    Usuario.usuarioCadastrado
            ) && senha.equals(
                    Usuario.senhaCadastrada
            )) {

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


        cadastroBtn.addActionListener(e -> {

            frame.dispose();

            CadastroUI cadastro =
                    new CadastroUI();

            cadastro.criarTelaCadastro();

        });


        card.add(imagem);

        card.add(
                Box.createRigidArea(
                        new Dimension(0, 20)
                )
        );

        card.add(titulo);

        card.add(
                Box.createRigidArea(
                        new Dimension(0, 30)
                )
        );

        card.add(new JLabel("Usuário"));

        card.add(
                Box.createRigidArea(
                        new Dimension(0, 5)
                )
        );

        card.add(usuarioField);

        card.add(
                Box.createRigidArea(
                        new Dimension(0, 20)
                )
        );

        card.add(new JLabel("Senha"));

        card.add(
                Box.createRigidArea(
                        new Dimension(0, 5)
                )
        );

        card.add(senhaField);

        card.add(
                Box.createRigidArea(
                        new Dimension(0, 30)
                )
        );

        card.add(entrarBtn);

        card.add(
                Box.createRigidArea(
                        new Dimension(0, 10)
                )
        );

        card.add(cadastroBtn);


        mainPanel.add(card);

        frame.setVisible(true);
    }
}