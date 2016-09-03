package br.com.app.gym.web.rest;

import br.com.app.gym.web.model.Academia;
import br.com.app.gym.web.model.Login;
import javax.ws.rs.ClientErrorException;

/**
 * @author Matheus
 */
public interface LoginRest {
    
    Academia autenticarAcademia(Login login) throws ClientErrorException;
    
}
