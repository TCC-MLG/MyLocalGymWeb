package br.com.app.gym.web.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.com.app.gym.web.model.Login;
import br.com.app.gym.web.service.LoginService;
import br.com.gym.mylocalgym.messages.Message;

@Model
@RequestScoped
public class LoginController {

	private Login login;
	
	@Inject
	private LoginService service;
	
	private Message message;

	@PostConstruct
	public void init() {

		this.login = new Login();
		this.setMessage(new Message());

	}
	
	public void entrar(){
		
		this.setMessage(service.efetuarLogin(login));
		
	}
	

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
