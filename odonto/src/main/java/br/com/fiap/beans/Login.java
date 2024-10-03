package br.com.fiap.beans;

import jdk.jfr.DataAmount;

@DataAmount
public class Login {

    String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;

    public void validarLogin(String senha, String nome){

    }

}
