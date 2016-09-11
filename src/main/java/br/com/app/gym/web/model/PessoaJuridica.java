package br.com.app.gym.web.model;

import br.com.app.gym.web.parameter.AcademiaParameter;
import java.io.Serializable;

public class PessoaJuridica implements Serializable {
    
    private String razaoSocial;
    private Integer cnpj;
    private String email;
    private String cep;
    private String telefone;
    private String cidade;
    private String bairro;
    private String estado;
    private String logradouro;
    private String senha;
    private Integer numero;
    private String complemento;
    
    public AcademiaParameter convert() {
        
        AcademiaParameter ap = new AcademiaParameter();
        
        ap.setRazaoSocial(this.razaoSocial);
        ap.setCnpj(this.cnpj);
        ap.setEmail(this.email);
        ap.setCep(this.cep);
        ap.setTelefone(this.telefone);
        ap.setCidade(this.cidade);
        ap.setBairro(this.bairro);
        ap.setEstado(this.estado);
        ap.setLogradouro(this.logradouro);
        ap.setSenha(this.senha);
        ap.setNumero(this.numero);
        ap.setComplemento(this.complemento);
        
        return ap;
        
    }
    
    public Integer getNumero() {
        return numero;
    }
    
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    public String getComplemento() {
        return complemento;
    }
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public String getRazaoSocial() {
        return razaoSocial;
    }
    
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public Integer getCnpj() {
        return cnpj;
    }
    
    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
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
    
    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getBairro() {
        return bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getLogradouro() {
        return logradouro;
    }
    
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getCep() {
        return cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    
}
