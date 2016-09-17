package br.com.app.gym.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Luciano
 */
public class Faturamento implements Serializable{
    
    private String nome;
    
    private BigDecimal valor;
    
    private String horario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
}
