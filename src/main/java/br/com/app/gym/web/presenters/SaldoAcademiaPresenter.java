package br.com.app.gym.web.presenters;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author mgraciano
 */
public class SaldoAcademiaPresenter implements Serializable {

    private BigDecimal saldo;

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

}
