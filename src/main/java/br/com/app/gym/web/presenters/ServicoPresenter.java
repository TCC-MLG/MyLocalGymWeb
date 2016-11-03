package br.com.app.gym.web.presenters;

import br.com.app.gym.web.model.ServicoModel;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Luciano
 */
public class ServicoPresenter implements Serializable{

    private Integer id;
    private String nome;
    private boolean padrao;
    private BigDecimal preco;
    private String tipo;
    
    public ServicoModel convert(){
        ServicoModel servicoModel = new ServicoModel();
        
        servicoModel.setId(this.id);
        servicoModel.setNome(this.nome);
        servicoModel.setPadrao(this.padrao);
        servicoModel.setPreco(this.preco);
        servicoModel.setTipo(this.tipo);
        
        return servicoModel;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPadrao() {
        return padrao;
    }

    public void setPadrao(boolean padrao) {
        this.padrao = padrao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
