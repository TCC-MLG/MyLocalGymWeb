package br.com.app.gym.web.parameter;

import java.math.BigDecimal;

/**
 * @author Luciano
 */
public class FaturamentoParameter {

    private String dataTransacao;

    private BigDecimal valor;

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
