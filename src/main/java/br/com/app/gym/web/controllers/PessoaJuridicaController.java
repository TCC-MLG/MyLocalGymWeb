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
import org.primefaces.context.RequestContext;

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
        String CEP = pessoa.getCep().toString();
        BuscaCEP busca = new BuscaCEP();
        String rua = busca.getEndereco(CEP);
        String bairro = busca.getBairro(CEP);
        String cidade = busca.getCidade(CEP);
        String estado = busca.getUF(CEP);

        if (rua.equals(CEP)) {

            this.pessoa.setLogradouro(rua);
            this.pessoa.setBairro(bairro);
            this.pessoa.setCidade(cidade);
            this.pessoa.setEstado(estado);

        }

    }

    public void cadastrar() {

        if (!this.campoVazio()) {

            if (this.pessoa.getSenha().equals(this.pessoa.getSenha2())) {

                boolean cadastrado = this.clienteService.cadastrarCliente(pessoa);

                if (cadastrado) {

                    RequestContext rc = RequestContext.getCurrentInstance();
                    rc.execute("PF('confirm').show()");

                } else {

                    RequestContext rc = RequestContext.getCurrentInstance();
                    rc.execute("PF('erro').show()");

                }
            } else {
                this.pessoa.setSenha("");
                this.pessoa.setSenha2("");

                RequestContext rc = RequestContext.getCurrentInstance();
                rc.execute("PF('diferente').show()");

            }
        } else {
            RequestContext rc = RequestContext.getCurrentInstance();
            rc.execute("PF('vazio').show()");
        }

    }

    public PessoaJuridica getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaJuridica pessoa) {
        this.pessoa = pessoa;
    }

    private boolean campoVazio() {

        if (pessoa.getRazaoSocial() == null) {
            return true;
        }
        if (pessoa.getCnpj() == null) {
            return true;
        }
        if (pessoa.getEmail() == null) {
            return true;
        }
        if (pessoa.getTelefone() == null) {
            return true;
        }
        if (pessoa.getCep() == null) {
            return true;
        }
        if (pessoa.getLogradouro() == null) {
            return true;
        }
        if (pessoa.getNumero() == null) {
            return true;
        }
        if (pessoa.getComplemento() == null) {
            return true;
        }
        if (pessoa.getBairro() == null) {
            return true;
        }
        if (pessoa.getEstado() == null) {
            return true;
        }
        if (pessoa.getSenha() == null) {
            return true;
        }
        if (pessoa.getSenha2() == null) {
            return true;
        }
        return false;
    }

}
