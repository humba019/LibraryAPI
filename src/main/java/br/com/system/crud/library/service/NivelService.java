package br.com.system.crud.library.service;

import java.util.List;
import java.util.Optional;

import br.com.system.crud.library.model.entity.Nivel;

public interface NivelService {

	public void newLevel(Nivel nivel);
	
	public List<Nivel> listLevel();
	
	public Optional<Nivel> findById(Long id);
	
}
