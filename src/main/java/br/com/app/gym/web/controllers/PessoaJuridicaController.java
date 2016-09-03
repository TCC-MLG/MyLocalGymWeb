package br.com.app.gym.web.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.app.gym.web.utils.BuscaCEP;
import br.com.app.gym.web.model.PessoaJuridica;
import br.com.app.gym.web.service.ClienteService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("pessoaJuridicaController")
public class PessoaJuridicaController {

    public PessoaJuridica getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaJuridica pessoa) {
        this.pessoa = pessoa;
    }

    private PessoaJuridica pessoa;

    @Inject
    private ClienteService service;

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

    public void cadastrar() {

        this.service.cadastrarCliente(this.pessoa);

    }

    public ClienteService getService() {
        return service;
    }

    public void setService(ClienteService service) {
        this.service = service;
    }
}
