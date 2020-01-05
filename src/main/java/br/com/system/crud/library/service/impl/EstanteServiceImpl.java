package br.com.system.crud.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.model.entity.Estante;
import br.com.system.crud.library.repository.EstanteRepository;
import br.com.system.crud.library.service.EstanteService;

@Service
public class EstanteServiceImpl implements EstanteService {

	private EstanteRepository estanteRepository;
	
	@Autowired
	public EstanteServiceImpl(EstanteRepository estanteRepository) {
		this.estanteRepository = estanteRepository;
	}

	@Override
	public void newShelf(Estante estante) {
		estanteRepository.save(estante);
	}

	@Override
	public List<Estante> listShelf() {
		List<Estante> shelfList = estanteRepository.findAll();
		if(shelfList.size()>0) {
			return shelfList;
		}else {
			throw new ObjetoInexistenteException("shelf's list has 0 positions");
		}
	}

	@Override
	public Optional<Estante> findById(Long id) {
		Optional<Estante> shelf = estanteRepository.findById(id);
		if(shelf.isPresent()) {
			return shelf;
		}else {
			throw new ObjetoInexistenteException("id "+ id +" not found");			
		}
	}

}
