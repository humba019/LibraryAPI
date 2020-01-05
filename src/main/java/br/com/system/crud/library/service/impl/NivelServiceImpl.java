package br.com.system.crud.library.service.impl;

import java.util.List;
import java.util.Optional;

import br.com.system.crud.library.model.entity.Nivel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.repository.NivelRepository;
import br.com.system.crud.library.service.NivelService;

@Service
public class NivelServiceImpl implements NivelService {

	private NivelRepository nivelRepository;
	
	@Autowired
	public NivelServiceImpl(NivelRepository nivelRepository) {
		this.nivelRepository = nivelRepository;
	}

	@Override
	public void newLevel(Nivel nivel) {
		nivelRepository.save(nivel);
	}

	@Override
	public List<Nivel> listLevel() {
		List<Nivel> rackList = nivelRepository.findAll();
		if(rackList.size() > 0) {
			return rackList;
		}else {
			throw new ObjetoInexistenteException("payment's list has 0 positions");
		}
	}

	@Override
	public Optional<Nivel> findById(Long id) {
		Optional<Nivel> rack = nivelRepository.findById(id);
		if(rack.isPresent()) {
			return rack;
		}else {
			throw new ObjetoInexistenteException("id "+ id+" not found");			
		}
	}

}
