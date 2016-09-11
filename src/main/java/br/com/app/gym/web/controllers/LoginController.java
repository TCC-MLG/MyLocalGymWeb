package br.com.app.gym.web.controllers;

import br.com.app.gym.web.model.Academia;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.app.gym.web.model.Login;
import br.com.app.gym.web.service.LoginService;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

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

    public String entrar() throws IOException {

        Academia academia = this.service.efetuarLogin(this.login);

        if (academia != null) {

            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            session.setAttribute("ID_USUARIO", academia.getId());

            return "principal";

        } else {

            this.login.setSenha(null);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "CNPJ/senha não econtrada!"));

        }

        return null;

    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

}
