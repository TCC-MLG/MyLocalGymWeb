package br.com.app.gym.web.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;

import br.com.app.gym.web.utils.BuscaCEP;
import br.com.app.gym.web.model.PessoaJuridica;
import br.com.app.gym.web.service.ClienteService;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named("pessoaJuridicaController")
public class PessoaJuridicaController implements Serializable {

    private PessoaJuridica pessoa;

    @Inject
    private ClienteService clienteService;

    @PostConstruct
    public void init() {
        this.pessoa = new PessoaJuridica();
    }

    public void buscaCep() throws IOException {
        String CEP = pessoa.getCep();
        BuscaCEP busca = new BuscaCEP();
        String rua = busca.getEndereco(CEP);
        String bairro = busca.getBairro(CEP);
        String cidade = busca.getCidade(CEP);
        String estado = busca.getUF(CEP);

        this.pessoa.setLogradouro(rua);
        this.pessoa.setBairro(bairro);
        this.pessoa.setCidade(cidade);
        this.pessoa.setEstado(estado);

    }

    public String cadastrar() {

        
        boolean cadastrado = this.clienteService.cadastrarCliente(pessoa);

        
        System.out.println("");
        
        return "inicio";

    }

    public PessoaJuridica getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaJuridica pessoa) {
        this.pessoa = pessoa;
    }

}
