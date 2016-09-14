package br.com.app.gym.web.rest.impl;

import br.com.app.gym.web.parameter.FaturamentoParameter;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.app.gym.web.rest.FaturamentoRest;
import java.io.Serializable;
import java.text.MessageFormat;
import javax.ws.rs.core.GenericType;

public class FaturamentoRestImpl implements FaturamentoRest, Serializable {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/mylocalgym/resources";

    public FaturamentoRestImpl() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("transacao");
    }

    @Override
    public List<FaturamentoParameter> listarTransacoesPorPeriodo(String periodo) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(MessageFormat.format("listar/{0}", new Object[]{periodo}));
        Response response = resource.request(MediaType.APPLICATION_JSON).get();

        List<FaturamentoParameter> parameters = response.readEntity(new GenericType<List<FaturamentoParameter>>() {
        });

        return parameters;
    }

    @Override
    public List<FaturamentoParameter> listarTransacoes() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("listar");

        Response response = resource.request(MediaType.APPLICATION_JSON).get();

        List<FaturamentoParameter> parameters = response.readEntity(new GenericType<List<FaturamentoParameter>>() {
        });
        
        return parameters;
    }

    public void close() {
        client.close();
    }

}
