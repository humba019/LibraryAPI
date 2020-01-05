package br.com.system.crud.library.service;

import java.util.List;
import java.util.Optional;

import br.com.system.crud.library.model.entity.Estante;

public interface EstanteService {

	public void newShelf(Estante estante);
	
	public List<Estante> listShelf();
	
	public Optional<Estante> findById(Long id);

}
