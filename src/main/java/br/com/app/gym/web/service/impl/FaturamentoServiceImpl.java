package br.com.app.gym.web.service.impl;

import br.com.app.gym.web.model.Faturamento;
import br.com.app.gym.web.parameter.PeriodoParameter;
import java.util.List;
import javax.inject.Inject;
import br.com.app.gym.web.service.FaturamentoService;
import br.com.app.gym.web.rest.FaturamentoRest;
import java.io.Serializable;
import javax.ws.rs.ClientErrorException;

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

    @Override
    public PeriodoParameter listarFaturamento(String academiaId) throws ClientErrorException {
        
        return this.historicoTransacaoRest.listarFaturamento(academiaId);
        
    }

}
