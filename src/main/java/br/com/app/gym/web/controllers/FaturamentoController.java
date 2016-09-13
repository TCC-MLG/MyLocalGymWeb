package br.com.app.gym.web.controllers;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author Luciano
 */

@ViewScoped
@Named("faturamentoController")
public class FaturamentoController implements Serializable {
    
    
    @PostConstruct
    public void init(){
        
    }
    
}
