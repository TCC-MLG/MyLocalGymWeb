package br.com.app.gym.web.rest.impl;

import br.com.app.gym.web.model.CheckinSolicitacao;
import br.com.app.gym.web.presenters.CheckinSolicitacaoPresenter;
import br.com.app.gym.web.rest.CheckinRest;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;

public class CheckinRestImpl implements CheckinRest{

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
        List<CheckinSolicitacaoPresenter> list = response.readEntity(new GenericType<List<CheckinSolicitacaoPresenter>>() {});
        
        List<CheckinSolicitacao> solicitacoes = new ArrayList<>();
        
        for (CheckinSolicitacaoPresenter presenter : list) {
            
            solicitacoes.add(presenter.convert());
            
        }
        
        return solicitacoes;
    }

    public void close() {
        client.close();
    }
    
}
