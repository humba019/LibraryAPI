package br.com.system.crud.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.model.entity.Corredor;
import br.com.system.crud.library.repository.CorredorRepository;
import br.com.system.crud.library.service.CorredorService;

@Service
public class CorredorServiceImpl implements CorredorService {

	private CorredorRepository corredorRepository;
	
	@Autowired
	public CorredorServiceImpl(CorredorRepository corredorRepository) {
		this.corredorRepository = corredorRepository;
	}

	@Override
	public void newHall(Corredor corredor) {
		corredorRepository.save(corredor);
	}

	@Override
	public List<Corredor> listHall() {
		List<Corredor> hallList = corredorRepository.findAll();
		if(hallList.size() > 0) {
			return hallList;
		}else {
			throw new ObjetoInexistenteException("hall's list has 0 positions");
		}
	}

	@Override
	public Optional<Corredor> findById(Long id) {
		Optional<Corredor> hall = corredorRepository.findById(id);
		if(hall.isPresent()) {
			return hall;
		}else {
			throw new ObjetoInexistenteException("id "+ id +" not found");			
		}
	}

}
