package br.com.system.crud.library.service;

import java.util.List;
import java.util.Optional;

import br.com.system.crud.library.model.entity.Taxa;

public interface TaxaService {
	
	public void newRate(Taxa taxa);
	
	public List<Taxa> listRate();
	
	public Optional<Taxa> findById(Long id);
	
}
