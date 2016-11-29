package br.com.app.gym.web.service;

import br.com.app.gym.web.model.Faturamento;
import br.com.app.gym.web.model.HistoricoClienteModel;
import br.com.app.gym.web.parameter.PeriodoParameter;
import java.math.BigDecimal;
import java.util.List;
import javax.ws.rs.ClientErrorException;

/**
 * @author Luciano
 */
public interface FaturamentoService {

    public List<Faturamento> listarTransacoesPorPeriodo(Integer academiaId, String dias);

    public PeriodoParameter listarFaturamento(String academiaId) throws ClientErrorException;

    public List<HistoricoClienteModel> listarHistoricoClientes(String clienteId, String start, String end, HistoricoClienteModel dadosCliente) throws ClientErrorException;

    public BigDecimal buscarSaldoPorId(Integer idCliente) throws ClientErrorException;
}
