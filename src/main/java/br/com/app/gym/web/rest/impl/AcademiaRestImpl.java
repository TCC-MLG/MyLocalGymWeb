package br.com.app.gym.web.rest.impl;

import br.com.app.gym.web.parameter.AcademiaParameter;
import br.com.app.gym.web.parameter.AlterarAcademiaParameter;
import br.com.app.gym.web.presenters.AlterarDadosAcademiaPresenter;
import br.com.app.gym.web.rest.AcademiaRest;
import java.io.Serializable;
import java.text.MessageFormat;
import javax.inject.Named;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import static javax.ws.rs.client.Entity.entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;

/**
 * @author Matheus
 */
@Named("academiaRestImpl")
public class AcademiaRestImpl implements AcademiaRest, Serializable {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/mylocalgym/resources";

    public AcademiaRestImpl() {
        this.client = ClientBuilder.newClient();
        this.webTarget = this.client.target(BASE_URI).path("academia");
    }

    @Override
    public boolean cadastrarAcademia(AcademiaParameter academiaParameter) throws ClientErrorException {

        Response response = this.webTarget.path("cadastrar")
                .request(APPLICATION_JSON)
                .post(entity(academiaParameter, APPLICATION_JSON), Response.class);

        Integer status = response.getStatus();

        boolean gravado = status.equals(204);

        return gravado;
    }

    @Override
    public boolean atualizarAcademia(AlterarAcademiaParameter parameter, Integer academiaId) throws ClientErrorException {
    
        Response response = webTarget.path(MessageFormat.format("{0}/alterar", new Object[]{academiaId}))
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(parameter, MediaType.APPLICATION_JSON), Response.class);

        Integer status = response.getStatus();

        boolean atualizado = status.equals(NO_CONTENT.getStatusCode());

        return atualizado;
    }

    @Override
    public AlterarDadosAcademiaPresenter buscarDadosAcademia(Integer academiaId) throws ClientErrorException {
       
        WebTarget resource = webTarget;
        resource = resource.path(MessageFormat.format("{0}/dadosCompleto", new Object[]{academiaId}));
        Response response = resource.request(MediaType.APPLICATION_JSON).get();

        AlterarDadosAcademiaPresenter presenter = response.readEntity(AlterarDadosAcademiaPresenter.class);

        return presenter;
    }

    public void close() {
        client.close();
    }

}
