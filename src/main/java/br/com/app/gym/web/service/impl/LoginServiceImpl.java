package br.com.app.gym.web.service.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import br.com.app.gym.web.model.Login;
import br.com.app.gym.web.service.LoginService;
import br.com.gym.mylocalgym.messages.Message;

public class LoginServiceImpl implements LoginService {

	Client client = ClientBuilder.newClient();

	@Override
	public Message efetuarLogin(Login login) {

		Response response = this.client
				.target("http://localhost:8080/mylocalgymservices/login/logar/"+login.getUsuario()+"/"+login.getSenha())
				.request().get();
		
		Message message = (Message) response.getEntity();

		return null;
	}

}
