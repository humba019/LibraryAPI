package br.com.system.crud.library.service;

import java.util.List;
import java.util.Optional;

import br.com.system.crud.library.model.entity.Pagamento;

public interface PagamentoService {

	public void newPayment(Pagamento pagamento);
	
	public List<Pagamento> listPayment();
	
	public Optional<Pagamento> findById(Long id);
	
}
