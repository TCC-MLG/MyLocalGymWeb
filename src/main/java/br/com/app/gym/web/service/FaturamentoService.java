package br.com.app.gym.web.service;

import br.com.app.gym.web.model.Faturamento;
import java.util.List;

/**
 * @author Luciano
 */
public interface FaturamentoService {

    public List<Faturamento> listarTransacoesPorPeriodo(String periodo);
    
    public List<Faturamento> listarTransacoes();

}
