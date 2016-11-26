package br.com.app.gym.web.presenters;

import java.io.Serializable;

/**
 * @author Luciano
 */
public class AlterarDadosAcademiaPresenter implements Serializable{

    private String razaoSocial;
    private String email;
    private String telefone;
    private String cep;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Integer numero;

    public String getRazaoSocial() {
        return razaoSocial;
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

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}
