package br.com.app.gym.web.service.impl;

import br.com.app.gym.web.model.Faturamento;
import java.util.List;
import javax.inject.Inject;
import br.com.app.gym.web.service.FaturamentoService;
import br.com.app.gym.web.rest.FaturamentoRest;
import java.io.Serializable;

/**
 * @author Luciano
 */
public class FaturamentoServiceImpl implements FaturamentoService, Serializable {

    @Inject
    private FaturamentoRest historicoTransacaoRest;

    @Override
    public List<Faturamento> listarTransacoesPorPeriodo(String periodo) {

        this.historicoTransacaoRest.listarTransacoesPorPeriodo(periodo);

        return null;
    }

    @Override
    public List<Faturamento> listarTransacoes() {

        this.historicoTransacaoRest.listarTransacoes();

        return null;
    }

}
