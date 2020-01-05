package br.com.system.crud.library.service;

import java.util.List;
import java.util.Optional;

import br.com.system.crud.library.model.entity.Aluguel;

public interface AluguelService {

	public void newRent(Aluguel aluguel);
	
	public List<Aluguel> listRent();

	public Optional<Aluguel> findById(Long id);
	
}
