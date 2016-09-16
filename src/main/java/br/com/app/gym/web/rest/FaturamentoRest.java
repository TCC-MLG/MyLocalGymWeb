package br.com.app.gym.web.rest;

import br.com.app.gym.web.parameter.FaturamentoParameter;
import br.com.app.gym.web.parameter.PeriodoParameter;
import java.util.List;
import javax.ws.rs.ClientErrorException;

/**
 * @author Luciano
 */
public interface FaturamentoRest {
    
     public List<FaturamentoParameter> listarTransacoesPorPeriodo(String periodo) throws ClientErrorException;
     
     public List<FaturamentoParameter> listarTransacoes() throws ClientErrorException;
     
     public PeriodoParameter listarFaturamento(String academiaId) throws ClientErrorException;
    
}
