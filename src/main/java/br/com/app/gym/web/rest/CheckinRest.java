package br.com.app.gym.web.rest;

import br.com.app.gym.web.model.CheckinDadosCliente;
import br.com.app.gym.web.model.CheckinSolicitacao;
import br.com.app.gym.web.parameter.CheckinParameter;
import java.util.List;
import javax.ws.rs.ClientErrorException;

/**
 * @author Luciano
 */
public interface CheckinRest {

    public List<CheckinSolicitacao> listarSolicitacao(String academiaId) throws ClientErrorException;

    public CheckinDadosCliente getDadosCliente(Integer checkinId, Integer academiaId) throws ClientErrorException;

    public boolean liberarCliente(CheckinParameter checkinParameter) throws ClientErrorException;

}
