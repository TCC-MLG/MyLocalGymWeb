package br.com.app.gym.web.controllers;

import br.com.app.gym.web.model.CheckinDadosCliente;
import br.com.app.gym.web.model.CheckinSolicitacao;
import br.com.app.gym.web.service.CheckinService;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import org.primefaces.context.RequestContext;

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

    private String image;

    private boolean aparecer = false;

    private String myImageBase64;

    @PostConstruct
    public void init() {

        this.solicitacoes = new HashMap<>();
        this.dadosCliente = new CheckinDadosCliente();

    }

    public void listarSolicitacao() {

        List<CheckinSolicitacao> checkinSolicitacoes = this.checkinService.listarSolicitacao(this.buscarIdSessao().toString());

        for (CheckinSolicitacao checkin : checkinSolicitacoes) {
            this.getSolicitacoes().put(checkin.getNome(), checkin.getId());
        }

    }

    public void buscarCliente() throws IOException {

        this.dadosCliente = this.checkinService.getDadosCliente(this.checkinId, this.buscarIdSessao());

        byte[] array = this.dadosCliente.getFoto();

        this.getImageFromDB(array);
        this.aparecer = true;
    }

    public void getImageFromDB(byte[] array) throws IOException {

        if (array != null) {

            this.myImageBase64 = "data:" + "jpg" + ";base64," + DatatypeConverter.printBase64Binary(array);
            

        }

    }

    public void abrirExame() {
        byte[] array = this.dadosCliente.getExame();

        if (array != null) {
            this.image = this.myImageBase64 = "data:" + "jpg" + ";base64," + DatatypeConverter.printBase64Binary(array);

            RequestContext rc = RequestContext.getCurrentInstance();
            rc.execute("PF('exame').show()");
        } else {
            RequestContext rc = RequestContext.getCurrentInstance();
            rc.execute("PF('exame_nao').show()");
        }
    }

    public void liberar() {

        boolean liberado = this.liberar(true);

        if (liberado) {
            RequestContext rc = RequestContext.getCurrentInstance();
            rc.execute("PF('liber').show()");
        } else {
            RequestContext rc = RequestContext.getCurrentInstance();
            rc.execute("PF('falh').show()");
        }

        this.solicitacoes = new HashMap<>();
        this.listarSolicitacao();

    }

    public void recusar() {

        boolean liberado = this.liberar(false);

        if (liberado) {
            RequestContext rc = RequestContext.getCurrentInstance();
            rc.execute("PF('recus').show()");
        }
    }

    private boolean liberar(boolean liberado) {

        boolean result = this.checkinService.liberarCliente(this.checkinId, this.dadosCliente.getClienteId(), this.buscarIdSessao(), liberado, buscarValorServico());

        this.dadosCliente = new CheckinDadosCliente();
        this.aparecer = false;

        return result;
    }

    public Integer buscarIdSessao() {

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        int idUsuarioSession = (int) session.getAttribute("ID_USUARIO");

        return idUsuarioSession;

    }

    public BigDecimal buscarValorServico() {

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        BigDecimal idUsuarioSession = (BigDecimal) session.getAttribute("VALOR_SERVICO");

        return idUsuarioSession;

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

    public String getImage() {
        return image;
    }

    public boolean isAparecer() {
        return aparecer;
    }

    public String getMyImageBase64() {
        return myImageBase64;
    }
}
