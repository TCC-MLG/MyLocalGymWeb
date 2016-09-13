package br.com.app.gym.web.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author Luciano
 */

@RequestScoped
@Named("historicoController")
public class HistoricoController {
    
    @PostConstruct
    public void init(){
        
        
    }
    
}
