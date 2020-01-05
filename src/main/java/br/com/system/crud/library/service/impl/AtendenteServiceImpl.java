package br.com.system.crud.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.model.entity.Atendente;
import br.com.system.crud.library.repository.AtendenteRepository;
import br.com.system.crud.library.service.AtendenteService;

@Service
public class AtendenteServiceImpl implements AtendenteService{

	private AtendenteRepository atendenteRepository;
	
	@Autowired
	public AtendenteServiceImpl(AtendenteRepository atendenteRepository) {
		this.atendenteRepository = atendenteRepository;
	}

	@Override
	public void newClerk(Atendente atendente) {
		atendenteRepository.save(atendente);
	}

	@Override
	public List<Atendente> listClerk() {
		List<Atendente> clerkList = atendenteRepository.findAll();
		if(clerkList.size() > 0) {
			return clerkList;
		}else {
			throw new ObjetoInexistenteException("clerk's list has 0 positions");
		}
	}

	@Override
	public Optional<Atendente> findById(Long id) {
		Optional<Atendente> clerk = atendenteRepository.findById(id);
		if(clerk.isPresent()) {
			return clerk;
		}else {
			throw new ObjetoInexistenteException("id "+ id +" not found");			
		}
	}

}
