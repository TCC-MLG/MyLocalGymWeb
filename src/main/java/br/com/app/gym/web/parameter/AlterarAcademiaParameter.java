package br.com.app.gym.web.parameter;

import br.com.app.gym.web.presenters.AlterarDadosAcademiaPresenter;
import java.io.Serializable;

/**
 *
 * @author Luciano
 */
public class AlterarAcademiaParameter implements Serializable{

    private String razaoSocial;
    private String email;
    private String telefone;
    private String cep;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public AlterarAcademiaParameter(AlterarDadosAcademiaPresenter dadosAcademia) {
        
        if (dadosAcademia != null) {
            this.razaoSocial = dadosAcademia.getRazaoSocial();
            this.email = dadosAcademia.getEmail();
            this.telefone = dadosAcademia.getTelefone();
            this.cep = dadosAcademia.getCep();
            this.endereco = dadosAcademia.getEndereco();
            this.complemento = dadosAcademia.getComplemento();
            this.bairro = dadosAcademia.getBairro();
            this.cidade = dadosAcademia.getCidade();
            this.estado = dadosAcademia.getEstado();
        }

    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
