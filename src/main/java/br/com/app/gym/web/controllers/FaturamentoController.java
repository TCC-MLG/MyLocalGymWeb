package br.com.app.gym.web.controllers;

import br.com.app.gym.web.model.Faturamento;
import br.com.app.gym.web.parameter.PeriodoParameter;
import br.com.app.gym.web.service.FaturamentoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
@Named("faturamentoController")
public class FaturamentoController implements Serializable {

    @Inject
    private FaturamentoService faturamentoService;

    private String city;
    private Map<String, String> cities = new HashMap<String, String>();
    private PeriodoParameter periodoParameter;
    private List<Faturamento> faturamento;

    @PostConstruct
    public void init() {

        setCities(new LinkedHashMap<String, String>());
        getCities().put("Hoje", "1");
        getCities().put("7", "7");
        getCities().put("15", "15");
        getCities().put("30", "30");

        this.periodoParameter = new PeriodoParameter();
        this.faturamento = new ArrayList<>();

        this.faturamento = this.faturamentoService.listarTransacoesPorPeriodo(buscarIdSessao(), "1");
        this.listarFaturamento();

    }

    public void listarFaturamentoPorPeriado() {

        this.faturamento = this.faturamentoService.listarTransacoesPorPeriodo(buscarIdSessao(), this.city);

    }

    public void listarFaturamento() {

        this.periodoParameter = this.faturamentoService.listarFaturamento("1");

    }

    public Integer buscarIdSessao() {

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        int idUsuarioSession = (int) session.getAttribute("ID_USUARIO");

        return idUsuarioSession;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }

    public PeriodoParameter getPeriodoParameter() {
        return periodoParameter;
    }

    public void setPeriodoParameter(PeriodoParameter periodoParameter) {
        this.periodoParameter = periodoParameter;
    }

    public List<Faturamento> getFaturamento() {
        return faturamento;
    }

}
