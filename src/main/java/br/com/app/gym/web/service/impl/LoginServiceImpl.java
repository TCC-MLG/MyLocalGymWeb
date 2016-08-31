package br.com.app.gym.web.service.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import br.com.app.gym.web.model.Login;
import br.com.app.gym.web.service.LoginService;
import java.text.MessageFormat;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class LoginServiceImpl implements LoginService {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/mylocalgym//resources";

    public LoginServiceImpl() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("login");
    }

    @Override
    public boolean efetuarLogin(Login login) throws ClientErrorException {
        WebTarget resource = webTarget;
        
        resource = resource.path(MessageFormat.format("autenticar/{0}/{1}", new Object[]{login.getUsuario(), login.getSenha()}));

        Response response = resource.request(MediaType.APPLICATION_JSON).get();

        return false;
    }

    public void close() {
        client.close();
    }

}
