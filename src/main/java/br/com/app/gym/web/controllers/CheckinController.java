package br.com.app.gym.web.controllers;

import br.com.app.gym.web.model.CheckinSolicitacao;
import br.com.app.gym.web.service.CheckinService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * @author Luciano
 */
public class CheckinController implements Serializable {
    
    @Inject
    private CheckinService checkinService;
    
    private List<CheckinSolicitacao> checkinSolicitacoes;
    
    @PostConstruct
    public void init() {
    
        this.checkinSolicitacoes = new ArrayList<>();
        
    }
    
    public void listarSolicitacao(){
        
        this.checkinSolicitacoes = this.checkinService.listarSolicitacao("1");
        
    }

    public List<CheckinSolicitacao> getCheckinSolicitacoes() {
        return checkinSolicitacoes;
    }
    
}
