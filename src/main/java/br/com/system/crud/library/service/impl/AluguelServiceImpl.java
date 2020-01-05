package br.com.system.crud.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.model.entity.Aluguel;
import br.com.system.crud.library.repository.AluguelRepository;
import br.com.system.crud.library.service.AluguelService;

@Service
public class AluguelServiceImpl implements AluguelService{

	private AluguelRepository aluguelRepository;
	
	@Autowired
	public AluguelServiceImpl(AluguelRepository aluguelRepository) {
		this.aluguelRepository = aluguelRepository;
	}

	@Override
	public void newRent(Aluguel aluguel) {
		aluguelRepository.save(aluguel);
	}

	@Override
	public List<Aluguel> listRent() {
		List<Aluguel> rentList = aluguelRepository.findAll();
		if(rentList.size() > 0) {
			return rentList;
		}else {
			throw new ObjetoInexistenteException("rent's list has 0 positions");
		}
	}

	@Override
	public Optional<Aluguel> findById(Long id) {
		Optional<Aluguel> rent = aluguelRepository.findById(id);
		if(rent.isPresent()) {
			return rent;			
		}else {
			throw new ObjetoInexistenteException("id "+ id +" not found");			
		}
	}

}
