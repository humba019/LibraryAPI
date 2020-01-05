package br.com.system.crud.library.service;

import java.util.List;
import java.util.Optional;

import br.com.system.crud.library.model.entity.Local;

public interface LocalService {
	
	public void newPlace(Local local);
	
	public List<Local> listPlace();
	
	public Optional<Local> findById(Long id);
	
}
