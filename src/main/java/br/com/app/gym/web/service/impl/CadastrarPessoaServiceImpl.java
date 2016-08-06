package br.com.app.gym.web.service.impl;

import br.com.app.gym.web.model.Pessoa;
import br.com.app.gym.web.service.CadastrarPessoa;

public class CadastrarPessoaServiceImpl implements CadastrarPessoa{
	
//	RestConsumeService restConsumeService;

	@Override
	public boolean cadastrarPessoa(Pessoa pessoa) {
//		restConsumeService = new RestConsumeService();
//		System.out.println("Chegamos aqui" +pessoa.getNomePessoa() + pessoa.getNomePessoa());
//		pessoa = (Pessoa) restConsumeService.restGet("pessoaWeb", "passarNome", pessoa.getNomePessoa());
//		
//		System.out.println(pessoa.getNomePessoa());
//		
		return true;
	}

}
