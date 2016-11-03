package br.com.app.gym.web.service;

import br.com.app.gym.web.model.ServicoModel;
import java.util.List;
import javax.ws.rs.ClientErrorException;

/**
 * @author Luciano
 */
public interface ServicoService {

    public ServicoModel obterServico(Integer servicoId) throws ClientErrorException;

    public List<ServicoModel> listarTransacoesPorPeriodo(Integer academiaId);

    }
