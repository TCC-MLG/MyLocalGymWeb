package br.com.app.gym.web.service.impl;

import br.com.app.gym.web.model.CheckinDadosCliente;
import br.com.app.gym.web.model.CheckinSolicitacao;
import br.com.app.gym.web.parameter.CheckinParameter;
import br.com.app.gym.web.rest.CheckinRest;
import br.com.app.gym.web.service.CheckinService;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.ClientErrorException;

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

    public CheckinDadosCliente getDadosCliente(Integer checkinId, Integer academiaId) throws ClientErrorException {
        
        return this.checkinRest.getDadosCliente(checkinId, academiaId);

    }
    
    public boolean liberarCliente(Integer checkinId, Integer clienteId, Integer academiaId, boolean liberado, BigDecimal valorServico) throws ClientErrorException{

        CheckinParameter checkinParameter = new CheckinParameter(checkinId, clienteId, academiaId, liberado, valorServico);
        
        return  this.checkinRest.liberarCliente(checkinParameter);
        
    }

}
