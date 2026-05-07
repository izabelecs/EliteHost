package service;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AuthService {

    private List<Usuario> usuarios =
            new ArrayList<>();

    public AuthService() {

        usuarios.add(
                new Usuario("admin", "123")
        );
    }

    public boolean cadastrar(
            String usuario,
            String senha
    ) {

        for (Usuario u : usuarios) {

            if (u.getUsuario().equals(usuario)) {
                return false;
            }
        }

        usuarios.add(
                new Usuario(usuario, senha)
        );

        return true;
    }

    public boolean login(
            String usuario,
            String senha
    ) {

        for (Usuario u : usuarios) {

            if (u.getUsuario().equals(usuario)
                    && u.getSenha().equals(senha)) {

                return true;
            }
        }

        return false;
    }
}