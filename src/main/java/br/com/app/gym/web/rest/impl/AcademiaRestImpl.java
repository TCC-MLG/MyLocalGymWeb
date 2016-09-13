package br.com.app.gym.web.rest.impl;

import br.com.app.gym.web.parameter.AcademiaParameter;
import br.com.app.gym.web.rest.AcademiaRest;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import static javax.ws.rs.client.Entity.entity;
import javax.ws.rs.client.WebTarget;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;

/**
 * @author Matheus
 */
public class AcademiaRestImpl implements AcademiaRest{

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/mylocalgym/resources";

    public AcademiaRestImpl() {
        this.client = ClientBuilder.newClient();
        this.webTarget = this.client.target(BASE_URI).path("academia");
    }

    @Override
    public boolean cadastrarAcademia(AcademiaParameter academiaParameter) throws ClientErrorException {
        
        Response response = webTarget.path("cadastrar")
                .request(APPLICATION_JSON)
                .post(entity(academiaParameter, APPLICATION_JSON), Response.class);

        Integer status = response.getStatus();
        
        return status == 204;
    }

    public void close() {
        client.close();
    }

}
