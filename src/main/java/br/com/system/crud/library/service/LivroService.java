package br.com.system.crud.library.service;

import java.util.List;
import java.util.Optional;

import br.com.system.crud.library.model.entity.Livro;

public interface LivroService {
	
	public void newBook(Livro livro);
	
	public List<Livro> listBook();
	
	public Optional<Livro> findById(Long id);
	
}
