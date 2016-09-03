package br.com.app.gym.web.service;

import br.com.app.gym.web.model.Academia;
import br.com.app.gym.web.model.Login;

public interface LoginService {

    Academia efetuarLogin(Login login);

}
