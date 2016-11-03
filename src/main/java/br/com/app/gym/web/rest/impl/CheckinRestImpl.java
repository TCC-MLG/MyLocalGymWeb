package br.com.app.gym.web.rest.impl;

import br.com.app.gym.web.model.CheckinDadosCliente;
import br.com.app.gym.web.model.CheckinSolicitacao;
import br.com.app.gym.web.parameter.CheckinParameter;
import br.com.app.gym.web.presenters.CheckinClientePresenter;
import br.com.app.gym.web.presenters.CheckinSolicitacaoPresenter;
import br.com.app.gym.web.rest.CheckinRest;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import static javax.ws.rs.client.Entity.entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;

public class CheckinRestImpl implements CheckinRest, Serializable {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/mylocalgym/resources";

    public CheckinRestImpl() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("checkin");
    }

    @Override
    public List<CheckinSolicitacao> listarSolicitacao(String academiaId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(MessageFormat.format("solicitacoes/{0}", new Object[]{academiaId}));
        Response response = resource.request(APPLICATION_JSON).get();
        List<CheckinSolicitacaoPresenter> list = response.readEntity(new GenericType<List<CheckinSolicitacaoPresenter>>() {
        });

        List<CheckinSolicitacao> solicitacoes = new ArrayList<>();

        this.converterPresenterParaModel(list, solicitacoes);

        return solicitacoes;
    }

    @Override
    public CheckinDadosCliente getDadosCliente(Integer checkinId, Integer academiaId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(MessageFormat.format("{0}/cliente/{1}", new Object[]{checkinId, academiaId}));
        Response response = resource.request(MediaType.APPLICATION_JSON).get();

        CheckinClientePresenter presenter = response.readEntity(CheckinClientePresenter.class);

        return presenter != null ? presenter.convert() : null;
    }

    @Override
    public boolean liberarCliente(CheckinParameter checkinParameter) throws ClientErrorException {
        Response response = webTarget.path("liberar")
                .request(MediaType.APPLICATION_JSON)
                .post(entity(checkinParameter, MediaType.APPLICATION_JSON), Response.class);

        Boolean liberado = response.readEntity(Boolean.class);
        
        return liberado;
    }

    public void close() {
        client.close();
    }

    private void converterPresenterParaModel(List<CheckinSolicitacaoPresenter> list, List<CheckinSolicitacao> solicitacoes) {
        if (list != null && !list.isEmpty()) {
            for (CheckinSolicitacaoPresenter presenter : list) {
                solicitacoes.add(presenter.convert());
            }
        }
    }

}
