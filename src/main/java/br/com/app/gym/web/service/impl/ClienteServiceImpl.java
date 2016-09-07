package br.com.app.gym.web.service.impl;

import br.com.app.gym.web.model.PessoaJuridica;
import br.com.app.gym.web.rest.AcademiaRest;
import br.com.app.gym.web.service.ClienteService;
import javax.inject.Inject;

public class ClienteServiceImpl implements ClienteService {

    @Inject
    private AcademiaRest academiaRest;

    @Override
    public boolean cadastrarCliente(PessoaJuridica pessoaJuridica) {

        return this.academiaRest.cadastrarAcademia(pessoaJuridica.convert());
        
    }

}
