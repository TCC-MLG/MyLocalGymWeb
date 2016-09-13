package br.com.app.gym.web.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author Luciano
 */
@RequestScoped
@Named("perfilController")
public class PerfilController {

    @PostConstruct
    public void init() {

    }

}
