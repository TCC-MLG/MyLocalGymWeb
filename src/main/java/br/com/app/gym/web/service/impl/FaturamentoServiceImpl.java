package br.com.app.gym.web.service.impl;

import br.com.app.gym.web.model.Faturamento;
import br.com.app.gym.web.model.HistoricoClienteModel;
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
    public List<Faturamento> listarTransacoesPorPeriodo(Integer academiaId, String periodo) {

        List<Faturamento> faturamentos = this.historicoTransacaoRest.listarTransacoesPorPeriodo(academiaId, periodo);

        return faturamentos;
    }

    @Override
    public PeriodoParameter listarFaturamento(String academiaId) throws ClientErrorException {

        return this.historicoTransacaoRest.listarFaturamento(academiaId);

    }

    public List<HistoricoClienteModel> listarHistoricoClientes(String academiaId, String start, String end, HistoricoClienteModel dadosCliente) throws ClientErrorException {

        Integer cpf = dadosCliente.getCpfInput() == null ? Integer.getInteger(dadosCliente.getCpfInput().replace(".", "").replace(".", "").replace("-", "")) : null;

        return this.historicoTransacaoRest.listarHistoricoClientes(academiaId, start, end, dadosCliente.getNome(), dadosCliente.getEmail(), cpf);

    }

}
