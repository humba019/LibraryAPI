package br.com.system.crud.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.model.entity.Prateleira;
import br.com.system.crud.library.repository.PrateleiraRepository;
import br.com.system.crud.library.service.PrateleiraService;

@Service
public class PrateleiraServiceImpl implements PrateleiraService{

	private PrateleiraRepository prateleiraRepository;
	
	@Autowired
	public PrateleiraServiceImpl(PrateleiraRepository prateleiraRepository) {
		this.prateleiraRepository = prateleiraRepository;
	}

	@Override
	public void newRack(Prateleira prateleira) {
		prateleiraRepository.save(prateleira);
	}

	@Override
	public List<Prateleira> listRack() {
		List<Prateleira> rackList = prateleiraRepository.findAll();
		if(rackList.size() > 0) {
			return rackList;
		}else {
			throw new ObjetoInexistenteException("payment's list has 0 positions");
		}
	}

	@Override
	public Optional<Prateleira> findById(Long id) {
		Optional<Prateleira> rack = prateleiraRepository.findById(id);
		if(rack.isPresent()) {
			return rack;
		}else {
			throw new ObjetoInexistenteException("id "+ id+" not found");			
		}
	}

}
