package br.com.app.gym.web.rest;

import br.com.app.gym.web.parameter.AcademiaParameter;
import javax.ws.rs.ClientErrorException;

/**
 * @author Matheus
 */
public interface AcademiaRest {
    
    public boolean cadastrarAcademia(AcademiaParameter academiaParameter) throws ClientErrorException;
    
}
