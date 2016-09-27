package br.com.app.gym.web.controllers;

import br.com.app.gym.web.model.CheckinSolicitacao;
import br.com.app.gym.web.service.CheckinService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Luciano
 */

@ViewScoped
@Named("checkinController")
public class CheckinController implements Serializable {
    
    @Inject
    private CheckinService checkinService;
       
    private HashMap<String, Integer> solicitacoes; 
    
    private Integer checkinId;
    
    @PostConstruct
    public void init() {
   
        this.solicitacoes = new HashMap<>();
        
    }
    
    public void listarSolicitacao(){
        
       List<CheckinSolicitacao> checkinSolicitacoes = this.checkinService.listarSolicitacao("1");
        
        for (CheckinSolicitacao checkin : checkinSolicitacoes) {
            this.getSolicitacoes().put(checkin.getNome(), checkin.getId());
        }
        
    }

    public Integer getCheckinId() {
        return checkinId;
    }

    public void setCheckinId(Integer checkinId) {
        this.checkinId = checkinId;
    }

    public HashMap<String, Integer> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(HashMap<String, Integer> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }
    
}
