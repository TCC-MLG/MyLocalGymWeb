package br.com.app.gym.web.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.app.gym.web.model.Pessoa;
import br.com.app.gym.web.service.CadastrarPessoa;

@Model
@RequestScoped
public class Hello {

	@Inject
	CadastrarPessoa cadastrarPessoa;

	private Pessoa pessoa;

	@PostConstruct
	public void init() {
		pessoa = new Pessoa();
	}

	public void cadastrarPessoa() {
		boolean certo;
		System.out.println("hoje");

		certo = cadastrarPessoa.cadastrarPessoa(pessoa);

		if (certo) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Ae Sim mano!", ""));
		}

	}

	public String getMessage() {
		return "Hello World JSF!";
	}

	public String register() {
		return "/public/register.xhtml";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}