package br.com.app.gym.web.rest;

import br.com.app.gym.web.parameter.AcademiaParameter;
import br.com.app.gym.web.parameter.AlterarAcademiaParameter;
import br.com.app.gym.web.presenters.AlterarDadosAcademiaPresenter;
import javax.ws.rs.ClientErrorException;

/**
 * @author Matheus
 */
public interface AcademiaRest {

    public boolean cadastrarAcademia(AcademiaParameter academiaParameter) throws ClientErrorException;

    public AlterarDadosAcademiaPresenter buscarDadosAcademia(Integer academiaId) throws ClientErrorException;

    public boolean atualizarAcademia(AlterarAcademiaParameter parameter, String academiaId) throws ClientErrorException;

}
