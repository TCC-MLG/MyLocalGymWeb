package br.com.app.gym.web.model;

import java.io.Serializable;

public class Login implements Serializable {

    private String usuario;
    private String senha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {

        String cnpjString = usuario.replace(".", "").replace("/", "").replace("-", "");

        this.usuario = cnpjString;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
