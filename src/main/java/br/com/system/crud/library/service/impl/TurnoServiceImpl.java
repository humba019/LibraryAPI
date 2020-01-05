package br.com.system.crud.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.model.entity.Turno;
import br.com.system.crud.library.repository.TurnoRepository;
import br.com.system.crud.library.service.TurnoService;

@Service
public class TurnoServiceImpl implements TurnoService {

	private TurnoRepository turnoRepository;
	
	@Autowired
	public TurnoServiceImpl(TurnoRepository turnoRepository) {
		this.turnoRepository = turnoRepository;
	}

	@Override
	public void newBout(Turno turno) {
		turnoRepository.save(turno);
	}

	@Override
	public List<Turno> listBout() {
		List<Turno> boutList = turnoRepository.findAll();
		if(boutList.size() > 0) {
			return boutList;
		}else {
			throw new ObjetoInexistenteException("bout's list has 0 positions");
		}
	}

	@Override
	public Optional<Turno> findById(Long id) {
		Optional<Turno> bout = turnoRepository.findById(id);
		if(bout.isPresent()) {
			return bout;
		}else {
			throw new ObjetoInexistenteException("id "+ id +" not found");			
		}
	}

}
