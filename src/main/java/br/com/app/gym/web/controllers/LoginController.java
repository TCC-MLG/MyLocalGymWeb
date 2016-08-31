package br.com.app.gym.web.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.app.gym.web.model.Login;
import br.com.app.gym.web.service.LoginService;
import java.io.Serializable;
import javax.inject.Named;

@RequestScoped
@Named("loginController")
public class LoginController implements Serializable {

    private Login login;

    @Inject
    private LoginService service;

    @PostConstruct
    public void init() {

        this.login = new Login();

    }

    public void entrar() {

        this.service.efetuarLogin(this.login);

    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

}
