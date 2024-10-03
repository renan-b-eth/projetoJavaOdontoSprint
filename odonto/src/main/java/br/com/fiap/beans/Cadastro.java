package br.com.fiap.beans;

public class Cadastro {
    String nome;
    String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeConsultorio() {
        return nomeConsultorio;
    }

    public void setNomeConsultorio(String nomeConsultorio) {
        this.nomeConsultorio = nomeConsultorio;
    }

    String senha;
    String nomeConsultorio;
}
