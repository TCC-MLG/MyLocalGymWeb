package br.com.app.gym.web.controllers;

import br.com.app.gym.web.model.Academia;
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

       Academia academia = this.service.efetuarLogin(this.login);
       
        if (academia.getId() != null) {
            
            System.out.println("PULAR PARA O SISTEMA");
            
        }else{
            
            System.err.println("mensagem de erro.");
            
        }

    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

}
