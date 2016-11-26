package br.com.app.gym.web.rest;

import br.com.app.gym.web.model.ServicoModel;
import java.math.BigDecimal;
import java.util.List;
import javax.ws.rs.ClientErrorException;

/**
 * @author Luciano
 */
public interface ServicoRest {

    public List<ServicoModel> listarTransacoesPorPeriodo(Integer academiaId) throws ClientErrorException;

    public ServicoModel obterServico(Integer servicoId) throws ClientErrorException;

    public BigDecimal alterarServico(BigDecimal valor, Integer clienteId);

}
