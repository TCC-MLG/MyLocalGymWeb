package br.com.app.gym.web.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;

import br.com.app.gym.web.model.PessoaJuridica;

@Model
@RequestScoped
public class CadastrarController {
	
	private PessoaJuridica pessoa;

	@PostConstruct
	public void init() {
		
		this.pessoa = new PessoaJuridica();

	}

	public PessoaJuridica getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaJuridica pessoa) {
		this.pessoa = pessoa;
	}

}
