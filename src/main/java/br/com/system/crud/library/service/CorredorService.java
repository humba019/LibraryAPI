package br.com.system.crud.library.service;

import java.util.List;
import java.util.Optional;

import br.com.system.crud.library.model.entity.Corredor;

public interface CorredorService {
	
	public void newHall(Corredor corredor);
	
	public List<Corredor> listHall();
	
	public Optional<Corredor> findById(Long id);
	
}
