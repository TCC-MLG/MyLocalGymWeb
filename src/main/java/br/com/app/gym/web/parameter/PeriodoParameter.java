package br.com.app.gym.web.parameter;

import java.math.BigDecimal;

/**
 * @author Luciano
 */
public class PeriodoParameter {

    private BigDecimal semanal;
    private BigDecimal trimestral;
    private BigDecimal semestral;
    private BigDecimal anual;
    private BigDecimal mensal;

    public BigDecimal getSemanal() {
        return semanal;
    }

    public void setSemanal(BigDecimal semanal) {
        this.semanal = semanal;
    }

    public BigDecimal getTrimestral() {
        return trimestral;
    }

    public void setTrimestral(BigDecimal trimestral) {
        this.trimestral = trimestral;
    }

    public BigDecimal getSemestral() {
        return semestral;
    }

    public void setSemestral(BigDecimal semestral) {
        this.semestral = semestral;
    }

    public BigDecimal getAnual() {
        return anual;
    }

    public void setAnual(BigDecimal anual) {
        this.anual = anual;
    }

    public BigDecimal getMensal() {
        return mensal;
    }

    public void setMensal(BigDecimal mensal) {
        this.mensal = mensal;
    }

}
