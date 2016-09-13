package br.com.app.gym.web.rest.impl;

import br.com.app.gym.web.model.Academia;
import br.com.app.gym.web.model.Login;
import br.com.app.gym.web.presenters.LoginAcademiaPresenter;
import br.com.app.gym.web.rest.LoginRest;
import java.text.MessageFormat;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class LoginRestImpl implements LoginRest{

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/mylocalgym/resources";

    public LoginRestImpl() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("login");
    }
    
    @Override
    public Academia autenticarAcademia(Login login) throws ClientErrorException {
       
        WebTarget resource = webTarget;
        resource = resource.path(MessageFormat.format("academia/{0}/{1}", new Object[]{login.getUsuario(), login.getSenha()}));
        Response response = resource.request(MediaType.APPLICATION_JSON).get();
        
        LoginAcademiaPresenter academia = response.readEntity(LoginAcademiaPresenter.class);  
        
        return academia.convert();
        
    }

    public void close() {
        client.close();
    }
    
}
