package br.com.app.gym.web.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.com.app.gym.web.model.PessoaJuridica;
import br.com.app.gym.web.service.ClienteService;

@Model
@RequestScoped
public class CadastrarController {
	
	@Inject
	private ClienteService clienteService;
	
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
	public void cadastrarPessoaJuridica(){
		this.clienteService.cadastrarCliente(pessoa);
	}

}
