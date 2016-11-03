package br.com.app.gym.web.model;

import java.io.Serializable;

/**
 * @author Luciano
 */
public class CheckinDadosCliente implements Serializable {

    private Integer id;
    private boolean solicitacaoCliente;
    private Integer clienteId;
    private String nome;
    private String email;
    private Long cpf;
    private byte[] foto;
    private byte[] exame;

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

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] getExame() {
        return exame;
    }

    public void setExame(byte[] exame) {
        this.exame = exame;
    }

}
