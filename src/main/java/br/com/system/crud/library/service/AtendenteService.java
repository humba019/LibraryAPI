package br.com.system.crud.library.service;

import java.util.List;
import java.util.Optional;

import br.com.system.crud.library.model.entity.Atendente;

public interface AtendenteService {
	
	public void newClerk(Atendente atendente);
	
	public List<Atendente> listClerk();
	
	public Optional<Atendente> findById(Long id);
	
}
