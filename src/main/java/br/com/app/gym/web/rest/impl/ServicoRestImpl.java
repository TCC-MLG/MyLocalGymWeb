/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app.gym.web.rest.impl;

import br.com.app.gym.web.model.ServicoModel;
import br.com.app.gym.web.presenters.ServicoPresenter;
import br.com.app.gym.web.rest.ServicoRest;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ServicoRestImpl implements ServicoRest, Serializable {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/mylocalgym/resources";

    public ServicoRestImpl() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("servico");
    }

    @Override
    public List<ServicoModel> listarTransacoesPorPeriodo(Integer academiaId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(MessageFormat.format("listar/{0}", new Object[]{academiaId}));
        Response response = resource.request(MediaType.APPLICATION_JSON).get();

        List<ServicoPresenter> parameters = response.readEntity(new GenericType<List<ServicoPresenter>>() {
        });

        if (parameters != null) {

            List<ServicoModel> faturamentos = new ArrayList<>();
            for (ServicoPresenter presenter : parameters) {

                faturamentos.add(presenter.convert());
            }
            return faturamentos;
        }
        return null;
    }

    @Override
    public ServicoModel obterServico(Integer servicoId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(MessageFormat.format("{0}", new Object[]{servicoId}));
        Response response = resource.request(MediaType.APPLICATION_JSON).get();

        ServicoPresenter presenter = response.readEntity(ServicoPresenter.class);

        return presenter != null ? presenter.convert() : null;
    }

    public void close() {
        client.close();
    }

    @Override
    public BigDecimal alterarServico(BigDecimal valor, Integer clienteId) {

        return null;
    }

}
