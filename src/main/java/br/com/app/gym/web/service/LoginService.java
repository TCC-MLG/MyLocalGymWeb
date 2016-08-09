package br.com.app.gym.web.service;

import br.com.app.gym.web.model.Login;
import br.com.gym.mylocalgym.messages.Message;

public interface LoginService {
	
	 public Message efetuarLogin(Login login);

}
