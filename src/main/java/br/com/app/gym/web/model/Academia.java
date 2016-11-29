package br.com.app.gym.web.model;

import java.math.BigDecimal;

/**
 * @author RGC
 */
public class Academia {

    private Integer id;
    private BigDecimal valorServico;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public void setValorServico(BigDecimal valorServico) {
        this.valorServico = valorServico;
    }

}
