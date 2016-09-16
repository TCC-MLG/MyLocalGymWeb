package br.com.app.gym.web.service;

import br.com.app.gym.web.model.Faturamento;
import br.com.app.gym.web.parameter.PeriodoParameter;
import java.util.List;
import javax.ws.rs.ClientErrorException;

/**
 * @author Luciano
 */
public interface FaturamentoService {

    public List<Faturamento> listarTransacoesPorPeriodo(String periodo);
    
    public List<Faturamento> listarTransacoes();
    
    public PeriodoParameter listarFaturamento(String academiaId) throws ClientErrorException;

}
