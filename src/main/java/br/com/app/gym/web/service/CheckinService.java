package br.com.app.gym.web.service;

import br.com.app.gym.web.model.CheckinSolicitacao;
import java.util.List;

/**
 * @author Luciano
 */
public interface CheckinService {

    public List<CheckinSolicitacao> listarSolicitacao(String academiaId);

}
