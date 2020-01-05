package br.com.system.crud.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.model.entity.Local;
import br.com.system.crud.library.repository.LocalRepository;
import br.com.system.crud.library.service.LocalService;

@Service
public class LocalServiceImpl implements LocalService{

	private LocalRepository localRepository;
	
	@Autowired
	public LocalServiceImpl(LocalRepository localRepository) {
		this.localRepository = localRepository;
	}

	@Override
	public void newPlace(Local local) {
		localRepository.save(local);
	}

	@Override
	public List<Local> listPlace() {
		List<Local> placeList = localRepository.findAll();
		if(placeList.size() > 0) {
			return placeList;
		}else {
			throw new ObjetoInexistenteException("place's list has 0 positions");
		}
	}

	@Override
	public Optional<Local> findById(Long id) {
		Optional<Local> place = localRepository.findById(id);
		if(place.isPresent()) {
			return place;
		}else {
			throw new ObjetoInexistenteException("id "+ id+" not found");			
		}
	}

}
