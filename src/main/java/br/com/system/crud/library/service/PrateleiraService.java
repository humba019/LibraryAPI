package br.com.system.crud.library.service;

import java.util.List;
import java.util.Optional;

import br.com.system.crud.library.model.entity.Prateleira;

public interface PrateleiraService {

	public void newRack(Prateleira prateleira);
	
	public List<Prateleira> listRack();
	
	public Optional<Prateleira> findById(Long id);
	
}
