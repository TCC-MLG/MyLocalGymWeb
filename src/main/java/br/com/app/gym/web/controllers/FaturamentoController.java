package br.com.app.gym.web.controllers;

import br.com.app.gym.web.service.FaturamentoService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Luciano
 */
@ViewScoped
@Named("faturamentoController")
public class FaturamentoController implements Serializable {

    @Inject
    private FaturamentoService faturamentoService;

    @PostConstruct
    public void init() {

    }

    public void listarFaturamentoPorPeriado() {

        this.faturamentoService.listarTransacoesPorPeriodo("11-09-2016");

    }

    public void listarFaturamento() {

        this.faturamentoService.listarTransacoes();

    }

}
