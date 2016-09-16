package br.com.app.gym.web.controllers;

import br.com.app.gym.web.parameter.PeriodoParameter;
import br.com.app.gym.web.service.FaturamentoService;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
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
    private PeriodoParameter periodoParameter;

    @PostConstruct
    public void init() {

        setCities(new HashMap<String, String>());
        getCities().put("Semanal", "1");
        getCities().put("Mensal", "2");
        getCities().put("Semestral", "3");
        getCities().put("Anual", "4");
        
        this.periodoParameter = new PeriodoParameter();
        
         this.listarFaturamento();

    }

    public void listarFaturamentoPorPeriado() {

        this.faturamentoService.listarTransacoesPorPeriodo("11-09-2016");

    }

    public void listarTransacoes() {

        this.faturamentoService.listarTransacoes();

    }
    
    public void listarFaturamento(){
        
       this.periodoParameter = this.faturamentoService.listarFaturamento("1");
        
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

}
