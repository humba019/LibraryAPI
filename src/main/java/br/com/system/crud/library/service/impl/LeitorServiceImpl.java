package br.com.system.crud.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.model.entity.Leitor;
import br.com.system.crud.library.repository.LeitorRepository;
import br.com.system.crud.library.service.LeitorService;

@Service
public class LeitorServiceImpl implements LeitorService{

	private LeitorRepository leitorRepository;
	
	@Autowired
	public LeitorServiceImpl(LeitorRepository leitorRepository) {
		this.leitorRepository = leitorRepository;
	}

	@Override
	public void newReader(Leitor leitor) {	
		try {
			
			leitorRepository.save(leitor);
			
		}catch(Exception exp) {
			
			System.out.println(exp.getMessage());
			
		}
	}

	@Override
	public List<Leitor> listReaders() {
		List<Leitor> readerList = leitorRepository.findAll();
		if(readerList.size() > 0) {
			return readerList;
		}else {
			throw new ObjetoInexistenteException("reader's list has 0 positions");
		}
	}

	@Override
	public Optional<Leitor> findById(Long id) {
		Optional<Leitor> reader = leitorRepository.findById(id);
		if(reader.isPresent()) {
			return reader;
		}else {
			throw new ObjetoInexistenteException("id "+ id+" not found");			
		}
	}
	

}
