package br.com.app.gym.web.parameter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Luciano
 */
public class CheckinParameter implements Serializable{
    
    private Integer checkinId;
    private Integer clienteId;
    private Integer academiaId;
    private boolean liberado;
    private Integer servicoId;
    private BigDecimal valorServico;

    public CheckinParameter(Integer checkinId, Integer clienteId, Integer academiaId, boolean liberado, Integer servicoId) {
        
        this.checkinId = checkinId;
        this.clienteId = clienteId;
        this.academiaId = academiaId;
        this.liberado = liberado;
        this.servicoId = servicoId;
        
    }

    public Integer getCheckinId() {
        return checkinId;
    }

    public void setCheckinId(Integer checkinId) {
        this.checkinId = checkinId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public boolean isLiberado() {
        return liberado;
    }

    public void setLiberado(boolean liberado) {
        this.liberado = liberado;
    }

    public Integer getServicoId() {
        return servicoId;
    }

    public void setServicoId(Integer servicoId) {
        this.servicoId = servicoId;
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public void setValorServico(BigDecimal valorServico) {
        this.valorServico = valorServico;
    }

    public Integer getAcademiaId() {
        return academiaId;
    }

    public void setAcademiaId(Integer academiaId) {
        this.academiaId = academiaId;
    }
    
    
    
}
