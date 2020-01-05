package br.com.system.crud.library.service;

import java.util.List;
import java.util.Optional;

import br.com.system.crud.library.model.entity.Leitor;

public interface LeitorService {

	public void newReader(Leitor leitor);
	
	public List<Leitor> listReaders();
	
	public Optional<Leitor> findById(Long id);
	
}
