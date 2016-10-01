package br.com.app.gym.web.controllers;

import br.com.app.gym.web.model.CheckinDadosCliente;
import br.com.app.gym.web.model.CheckinSolicitacao;
import br.com.app.gym.web.service.CheckinService;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * @author Luciano
 */
@ViewScoped
@Named("checkinController")
public class CheckinController implements Serializable {

    @Inject
    private CheckinService checkinService;

    private HashMap<String, Integer> solicitacoes;

    private CheckinDadosCliente dadosCliente;

    private Integer checkinId;

    @PostConstruct
    public void init() {

        this.solicitacoes = new HashMap<>();
        this.dadosCliente = new CheckinDadosCliente();

    }

    public void listarSolicitacao() {

        List<CheckinSolicitacao> checkinSolicitacoes = this.checkinService.listarSolicitacao("1");

        for (CheckinSolicitacao checkin : checkinSolicitacoes) {
            this.getSolicitacoes().put(checkin.getNome(), checkin.getId());
        }

    }

    public void buscarCliente() {

        this.dadosCliente = this.checkinService.getDadosCliente(this.checkinId, 1);

    }

    public void liberar() {

        this.liberar(true);

    }

    private boolean liberar(boolean liberado) {

        boolean result = this.checkinService.liberarCliente(this.checkinId, this.dadosCliente.getId(), this.buscarIdSessao(), liberado, 1);

        return result;
    }

    public Integer buscarIdSessao() {

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        int idUsuarioSession = (int) session.getAttribute("ID_USUARIO");

        return idUsuarioSession;

    }

    public void recusar() {

        this.liberar(false);

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

    public CheckinDadosCliente getDadosCliente() {
        return dadosCliente;
    }

    public void setDadosCliente(CheckinDadosCliente dadosCliente) {
        this.dadosCliente = dadosCliente;
    }

}
