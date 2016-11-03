package br.com.app.gym.web.service.impl;

import br.com.app.gym.web.model.ServicoModel;
import br.com.app.gym.web.rest.ServicoRest;
import br.com.app.gym.web.service.ServicoService;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Luciano
 */
public class ServicoServiceImpl implements ServicoService, Serializable {

    @Inject
    private ServicoRest rest;

    @Override
    public ServicoModel obterServico(Integer servicoId) {

        return this.rest.obterServico(servicoId);
    }

    @Override
    public List<ServicoModel> listarTransacoesPorPeriodo(Integer academiaId) {

        return this.rest.listarTransacoesPorPeriodo(academiaId);
    }

}
