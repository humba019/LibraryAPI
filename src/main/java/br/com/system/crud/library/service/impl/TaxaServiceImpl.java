package br.com.system.crud.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.model.entity.Taxa;
import br.com.system.crud.library.repository.TaxaRepository;
import br.com.system.crud.library.service.TaxaService;

@Service
public class TaxaServiceImpl implements TaxaService {

	private TaxaRepository taxaRepository;
		
	@Autowired
	public TaxaServiceImpl(TaxaRepository taxaRepository) {
		this.taxaRepository = taxaRepository;
	}

	@Override
	public void newRate(Taxa taxa) {
		taxaRepository.save(taxa);
	}

	@Override
	public List<Taxa> listRate() {
		List<Taxa> rateList = taxaRepository.findAll();
		if(rateList.size() > 0) {
			return rateList;
		}else {
			throw new ObjetoInexistenteException("rate's list has 0 positions");
		}
	}

	@Override
	public Optional<Taxa> findById(Long id) {
		Optional<Taxa> rate = taxaRepository.findById(id);
		if(rate.isPresent()) {
			return rate;
		}else {
			throw new ObjetoInexistenteException("id "+ id +" not found");			
		}
	}

}
