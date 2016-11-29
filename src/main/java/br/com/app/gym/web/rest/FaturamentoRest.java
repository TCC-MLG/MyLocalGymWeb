package br.com.app.gym.web.rest;

import br.com.app.gym.web.model.Faturamento;
import br.com.app.gym.web.model.HistoricoClienteModel;
import br.com.app.gym.web.parameter.PeriodoParameter;
import java.math.BigDecimal;
import java.util.List;
import javax.ws.rs.ClientErrorException;

/**
 * @author Luciano
 */
public interface FaturamentoRest {

    public List<Faturamento> listarTransacoesPorPeriodo(Integer academiaId, String periodo) throws ClientErrorException;

    public PeriodoParameter listarFaturamento(String academiaId) throws ClientErrorException;
    
    public List<HistoricoClienteModel> listarHistoricoClientes(String academiaId, String start, String end, String nome, String email, Long cpf) throws ClientErrorException;

    public BigDecimal buscarSaldoPorId(Integer idCliente) throws ClientErrorException;
}
