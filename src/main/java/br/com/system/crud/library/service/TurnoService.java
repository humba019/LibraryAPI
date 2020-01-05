package br.com.system.crud.library.service;

import java.util.List;
import java.util.Optional;

import br.com.system.crud.library.model.entity.Turno;

public interface TurnoService {

	public void newBout(Turno turno);
	
	public List<Turno> listBout();
	
	public Optional<Turno> findById(Long id);
	
	
}
