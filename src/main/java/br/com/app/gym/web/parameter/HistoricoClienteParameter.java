package br.com.app.gym.web.parameter;

import br.com.app.gym.web.model.HistoricoClienteModel;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Luciano
 */
public class HistoricoClienteParameter {

    private Integer id;
    private String nome;
    private Integer cpf;
    private String email;
    private String telefone;
    private boolean exameMedico;
    private String cidade;
    private String endereco;
    private String estado;
    private BigDecimal valor;
    private String dataTransacao;

    public HistoricoClienteModel convert() {

        HistoricoClienteModel clienteModel = new HistoricoClienteModel();

        clienteModel.setId(id);
        clienteModel.setNome(nome);
        clienteModel.setCpf(cpf);
        clienteModel.setEmail(email);
        clienteModel.setTelefone(telefone);
        clienteModel.setExameMedico(exameMedico);
        clienteModel.setCidade(cidade);
        clienteModel.setEndereco(endereco);
        clienteModel.setEstado(estado);
        clienteModel.setValor(valor);
        clienteModel.setDataTransacao(dataTransacao);
        
        return clienteModel;

    }

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

}
