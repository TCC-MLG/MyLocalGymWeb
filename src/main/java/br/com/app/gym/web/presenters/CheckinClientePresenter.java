package br.com.app.gym.web.presenters;

import br.com.app.gym.web.model.CheckinDadosCliente;

/**
 * @author Luciano
 */
public class CheckinClientePresenter {

    private Integer id;
    private boolean solicitacaoCliente;
    private Integer clienteId;
    private String nome;
    private String email;
    private Integer cpf;

    public CheckinDadosCliente convert() {

        CheckinDadosCliente cliente = new CheckinDadosCliente();

        cliente.setId(this.id);
        cliente.setClienteId(this.clienteId);
        cliente.setCpf(this.cpf);
        cliente.setEmail(this.email);
        cliente.setNome(this.nome);
        cliente.setSolicitacaoCliente(this.solicitacaoCliente);

        return cliente;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isSolicitacaoCliente() {
        return solicitacaoCliente;
    }

    public void setSolicitacaoCliente(boolean solicitacaoCliente) {
        this.solicitacaoCliente = solicitacaoCliente;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

}
