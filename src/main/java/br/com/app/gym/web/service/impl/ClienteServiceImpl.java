package br.com.app.gym.web.service.impl;

import br.com.app.gym.web.model.PessoaJuridica;
import br.com.app.gym.web.parameter.AlterarAcademiaParameter;
import br.com.app.gym.web.presenters.AlterarDadosAcademiaPresenter;
import br.com.app.gym.web.rest.AcademiaRest;
import br.com.app.gym.web.service.ClienteService;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;

@Named("clienteServiceImpl")
public class ClienteServiceImpl implements ClienteService, Serializable {

    @Inject
    private AcademiaRest academiaRest;

    @Override
    public boolean cadastrarCliente(PessoaJuridica pessoaJuridica) {

        return this.academiaRest.cadastrarAcademia(pessoaJuridica.convert());
        
    }
    
    @Override
    public AlterarDadosAcademiaPresenter buscarDadosAcademia(Integer academiaId){
        
        return this.academiaRest.buscarDadosAcademia(academiaId);
    }
    
    @Override
    public boolean atualizarAcademia(AlterarAcademiaParameter parameter, Integer academiaId){
        
        return  this.academiaRest.atualizarAcademia(parameter, academiaId);
    }

}
