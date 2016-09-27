package br.com.app.gym.web.service.impl;

import br.com.app.gym.web.model.CheckinSolicitacao;
import br.com.app.gym.web.rest.CheckinRest;
import br.com.app.gym.web.service.CheckinService;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Luciano
 */
public class CheckinServiceImpl implements CheckinService, Serializable {

    @Inject
    private CheckinRest checkinRest;

    @Override
    public List<CheckinSolicitacao> listarSolicitacao(String academiaId) {

        return this.checkinRest.listarSolicitacao(academiaId);
    }

}
