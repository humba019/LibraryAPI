package br.com.system.crud.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.model.entity.Pagamento;
import br.com.system.crud.library.repository.PagamentoRepository;
import br.com.system.crud.library.service.PagamentoService;

@Service
public class PagamentoServiceImpl implements PagamentoService {

	
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	public PagamentoServiceImpl(PagamentoRepository pagamentoRepository) {
		this.pagamentoRepository = pagamentoRepository;
	}

	@Override
	public void newPayment(Pagamento pagamento) {
		pagamentoRepository.save(pagamento);
	}

	@Override
	public List<Pagamento> listPayment() {
		List<Pagamento> paymentList = pagamentoRepository.findAll();
		if(paymentList.size() > 0) {
			return paymentList;
		}else {
			throw new ObjetoInexistenteException("payment's list has 0 positions");
		}
	}

	@Override
	public Optional<Pagamento> findById(Long id) {
		Optional<Pagamento> payment = pagamentoRepository.findById(id);
		if(payment.isPresent()) {
			return payment;
		}else {
			throw new ObjetoInexistenteException("id "+ id+" not found");			
		}
	}

}
