package br.com.app.gym.web.presenters;

import br.com.app.gym.web.model.CheckinSolicitacao;
import java.io.Serializable;

/**
 * @author Luciano
 */
public class CheckinSolicitacaoPresenter implements Serializable {
    
    private Integer id;
    private String nome;
    
    public CheckinSolicitacaoPresenter() {}
    
    public CheckinSolicitacao convert(){
        CheckinSolicitacao solicitacao = new CheckinSolicitacao();
        
        solicitacao.setId(this.id);
        solicitacao.setNome(this.nome);
        
        return solicitacao;
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
    
}
