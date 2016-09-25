package br.com.app.gym.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Luciano
 */
public class HistoricoClienteModel implements Serializable {

    private Integer id;
    private String nome;
    private Integer cpf;
    private String cpfInput;
    private String email;
    private String telefone;
    private boolean exameMedico;
    private String cidade;
    private String endereco;
    private String estado;
    private BigDecimal valor;
    private String dataTransacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isExameMedico() {
        return exameMedico;
    }

    public void setExameMedico(boolean exameMedico) {
        this.exameMedico = exameMedico;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getCpfInput() {
        return cpfInput;
    }

    public void setCpfInput(String cpfInput) {
        this.cpfInput = cpfInput;
    }

}
