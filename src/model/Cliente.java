package model;

public class Cliente extends Pessoa {

    public Cliente(String nome, String cpf) {

        super(nome, cpf);
    }

    @Override
    public String getTipoPessoa() {

        return "Cliente";
    }
}