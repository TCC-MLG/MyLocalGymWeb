package br.com.app.gym.web.controllers;

import br.com.app.gym.web.model.CheckinDadosCliente;
import br.com.app.gym.web.model.CheckinSolicitacao;
import br.com.app.gym.web.service.CheckinService;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

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

    private StreamedContent image;
    
    private boolean aparecer = false;

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

    public void buscarCliente() throws IOException {

        this.dadosCliente = this.checkinService.getDadosCliente(this.checkinId, 1);

        byte[] array = this.dadosCliente.getFoto();

        this.image = this.getImageFromDB(array);

        //       BufferedImage img = ImageIO.read(new ByteArrayInputStream(array));
    }

    public StreamedContent getImageFromDB(byte[] array) throws IOException {

        BufferedImage img = ImageIO.read(new ByteArrayInputStream(array));

        ImageIO.write(img, "jpg", new File(
                "C:/Users/Luciano/workspace/mylocalgymweb/src/main/webapp/resources/img/new-darksouls.jpg"));
        
        this.aparecer = true;

        return new DefaultStreamedContent(new ByteArrayInputStream(array),
                "image/png");
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

        boolean result = this.checkinService.liberarCliente(this.checkinId, this.dadosCliente.getClienteId(), this.buscarIdSessao(), liberado, 1);

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

    public StreamedContent getImage() {
        return image;
    }

    public boolean isAparecer() {
        return aparecer;
    }
}
