package br.com.app.gym.web.controllers;

import br.com.app.gym.web.model.HistoricoClienteModel;
import br.com.app.gym.web.service.ClienteService;
import br.com.app.gym.web.service.FaturamentoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * @author Luciano
 */
@ViewScoped
@Named("historicoController")
public class HistoricoController implements Serializable{

    @Inject
    private FaturamentoService faturamentoService;

    private HistoricoClienteModel dadosCliente;

    private List<HistoricoClienteModel> clientesList;

    private String startDate;
    private String endDate;

    @PostConstruct
    public void init() {

        this.dadosCliente = new HistoricoClienteModel();
        this.clientesList = new ArrayList<>();

    }

    public void listarHistorico() {
        
        String clienteId = this.buscarIdSessao().toString();

        this.clientesList = this.faturamentoService.listarHistoricoClientes(clienteId, this.startDate, this.endDate, this.dadosCliente);

    }

    public Integer buscarIdSessao() {

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        int idUsuarioSession = (int) session.getAttribute("ID_USUARIO");

        return idUsuarioSession;

    }

    public HistoricoClienteModel getDadosCliente() {
        return dadosCliente;
    }

    public void setDadosCliente(HistoricoClienteModel dadosCliente) {
        this.dadosCliente = dadosCliente;
    }

    public List<HistoricoClienteModel> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<HistoricoClienteModel> clientesList) {
        this.clientesList = clientesList;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
