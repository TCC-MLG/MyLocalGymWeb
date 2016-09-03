package br.com.app.gym.web.service.impl;

import br.com.app.gym.web.model.Academia;

import br.com.app.gym.web.model.Login;
import br.com.app.gym.web.service.LoginService;
import br.com.app.gym.web.rest.LoginRest;
import javax.inject.Inject;
import javax.ws.rs.ClientErrorException;

public class LoginServiceImpl implements LoginService {

    @Inject
    private LoginRest loginRest;
    
    @Override
    public Academia efetuarLogin(Login login) throws ClientErrorException {
  
        return loginRest.autenticarAcademia(login);
    }
}
