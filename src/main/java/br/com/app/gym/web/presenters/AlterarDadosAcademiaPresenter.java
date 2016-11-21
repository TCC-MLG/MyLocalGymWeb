package br.com.app.gym.web.presenters;

import java.io.Serializable;

/**
 * @author Luciano
 */
public class AlterarDadosAcademiaPresenter implements Serializable{

    private String razãoSocial;
    private String email;
    private String telefone;
    private String cep;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public String getRazãoSocial() {
        return razãoSocial;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

}
