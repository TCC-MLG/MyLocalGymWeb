package br.com.app.gym.web.service;

import br.com.app.gym.web.model.CheckinDadosCliente;
import br.com.app.gym.web.model.CheckinSolicitacao;
import java.util.List;
import javax.ws.rs.ClientErrorException;

/**
 * @author Luciano
 */
public interface CheckinService {

    public List<CheckinSolicitacao> listarSolicitacao(String academiaId);

    public CheckinDadosCliente getDadosCliente(Integer checkinId, Integer academiaId) throws ClientErrorException;

    public boolean liberarCliente(Integer checkinId, Integer clienteId, Integer academiaId, boolean liberado, Integer servicoId) throws ClientErrorException;

}
