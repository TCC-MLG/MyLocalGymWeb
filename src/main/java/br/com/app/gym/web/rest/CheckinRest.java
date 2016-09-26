package br.com.app.gym.web.rest;

import br.com.app.gym.web.model.CheckinSolicitacao;
import java.util.List;
import javax.ws.rs.ClientErrorException;

/**
 * @author Luciano
 */
public interface CheckinRest {

    public List<CheckinSolicitacao> listarSolicitacao(String academiaId) throws ClientErrorException;
    
}
