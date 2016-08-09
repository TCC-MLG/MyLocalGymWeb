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
		this.message = new Message();

	}
	
	public void entrar(){
		
		this.message = service.efetuarLogin(login);
		
	}
	

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
