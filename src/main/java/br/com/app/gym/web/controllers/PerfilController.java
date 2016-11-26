package br.com.app.gym.web.controllers;

import br.com.app.gym.web.parameter.AlterarAcademiaParameter;
import br.com.app.gym.web.presenters.AlterarDadosAcademiaPresenter;
import br.com.app.gym.web.service.ClienteService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 * @author Luciano
 */
@ViewScoped
@Named("perfilController")
public class PerfilController implements Serializable {

    @Inject
    private ClienteService clienteService;

    private AlterarDadosAcademiaPresenter dadosAcademia;

    @PostConstruct
    public void init() {

        this.dadosAcademia = this.clienteService.buscarDadosAcademia(this.buscarIdSessao());
    }

    public void alterar() {

        AlterarAcademiaParameter parameter = new AlterarAcademiaParameter(this.dadosAcademia);

        boolean alterado = this.clienteService.atualizarAcademia(parameter, this.buscarIdSessao());

        if (alterado) {
            RequestContext rc = RequestContext.getCurrentInstance();
            rc.execute("PF('confirm').show()");
        } else {
            RequestContext rc = RequestContext.getCurrentInstance();
            rc.execute("PF('erro').show()");
        }
    }

    public Integer buscarIdSessao() {

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        int idUsuarioSession = (int) session.getAttribute("ID_USUARIO");

        return idUsuarioSession;
    }

    public AlterarDadosAcademiaPresenter getDadosAcademia() {
        return dadosAcademia;
    }

    public void setDadosAcademia(AlterarDadosAcademiaPresenter dadosAcademia) {
        this.dadosAcademia = dadosAcademia;
    }

}
