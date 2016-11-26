/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app.gym.web.presenters;

import br.com.app.gym.web.model.Academia;
import java.math.BigDecimal;

/**
 *
 * @author Matheus
 */
public class LoginAcademiaPresenter {

    private Integer id;
    private BigDecimal valorServico;

    public Integer getId() {
        return id;
    }

    public Academia convert() {

        Academia academia = new Academia();

        academia.setId(this.id);
        academia.setValorServico(this.valorServico);

        return academia;
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
