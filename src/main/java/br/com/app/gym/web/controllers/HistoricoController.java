package br.com.app.gym.web.controllers;

import br.com.app.gym.web.model.HistoricoClienteModel;
import br.com.app.gym.web.service.ClienteService;
import br.com.app.gym.web.service.FaturamentoService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Luciano
 */

@RequestScoped
@Named("historicoController")
public class HistoricoController {
    
    @Inject
    private FaturamentoService faturamentoService;
    
    private HistoricoClienteModel dadosCliente;
    
    private List<HistoricoClienteModel> clientesList;
    
    @PostConstruct
    public void init(){
        
        this.dadosCliente = new HistoricoClienteModel();
        this.clientesList = new ArrayList<>();
        
    }
    
    public void listarHistorico(){
        
        this.faturamentoService.listarHistoricoClientes("", "", "", "", "");
        
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

}
