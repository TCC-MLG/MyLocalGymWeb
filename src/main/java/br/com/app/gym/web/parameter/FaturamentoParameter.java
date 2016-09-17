package br.com.app.gym.web.parameter;

import br.com.app.gym.web.model.Faturamento;
import java.math.BigDecimal;

/**
 * @author Luciano
 */
public class FaturamentoParameter {

    private String nome;

    private BigDecimal valor;

    private String horario;

    public Faturamento convert() {

        Faturamento faturamento = new Faturamento();

        faturamento.setNome(this.nome);
        faturamento.setHorario(this.horario);
        faturamento.setValor(this.valor);

        return faturamento;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

}
