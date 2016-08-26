package br.com.app.gym.web.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.com.app.gym.web.model.BuscaCEP;
import br.com.app.gym.web.model.PessoaJuridica;
import br.com.app.gym.web.service.ClienteService;

@Model
@RequestScoped
public class PessoaJuridicaController {
	private PessoaJuridica pessoaJuridica;

	@Inject
	private ClienteService service;

	@PostConstruct
	public void init() {
		this.pessoaJuridica = new PessoaJuridica();
	}

	public void buscaCep() throws IOException {
		String CEP = pessoaJuridica.getCep();
		BuscaCEP busca = new BuscaCEP();
		String rua = busca.getEndereco(CEP);
		String bairro = busca.getBairro(CEP);
		String cidade = busca.getCidade(CEP);
		String estado = busca.getUF(CEP);

	}

	public ClienteService getService() {
		return service;
	}

	public void setService(ClienteService service) {
		this.service = service;
	}
}
