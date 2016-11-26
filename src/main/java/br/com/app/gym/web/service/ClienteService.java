package br.com.app.gym.web.service;

import br.com.app.gym.web.model.PessoaJuridica;
import br.com.app.gym.web.parameter.AlterarAcademiaParameter;
import br.com.app.gym.web.presenters.AlterarDadosAcademiaPresenter;

public interface ClienteService {

    boolean cadastrarCliente(PessoaJuridica pessoaJuridica);

    AlterarDadosAcademiaPresenter buscarDadosAcademia(Integer academiaId);
    
    boolean atualizarAcademia(AlterarAcademiaParameter parameter, Integer academiaId);

}
