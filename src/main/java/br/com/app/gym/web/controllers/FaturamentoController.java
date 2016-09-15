package br.com.app.gym.web.controllers;

import br.com.app.gym.web.service.FaturamentoService;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

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

    @PostConstruct
    public void init() {

        setCities(new HashMap<String, String>());
        getCities().put("Mensal", "New York");
        getCities().put("Semestral", "London");
        getCities().put("Anual", "Paris");

    }

    public void listarFaturamentoPorPeriado() {

        this.faturamentoService.listarTransacoesPorPeriodo("11-09-2016");

    }

    public void listarFaturamento() {

        this.faturamentoService.listarTransacoes();

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

}
