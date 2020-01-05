package br.com.system.crud.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.model.entity.Livro;
import br.com.system.crud.library.repository.LivroRepository;
import br.com.system.crud.library.service.LivroService;

@Service
public class LivroServiceImpl implements LivroService{

	private LivroRepository livroRepository;
	
	@Autowired
	public LivroServiceImpl(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@Override
	public void newBook(Livro livro) {
		livroRepository.save(livro);
	}

	@Override
	public List<Livro> listBook() {
		List<Livro> bookList = livroRepository.findAll();
		if(bookList.size()>0) {
			return bookList;
		}else {
			throw new ObjetoInexistenteException("book's list has 0 positions");
		}
	}

	@Override
	public Optional<Livro> findById(Long id) {
		Optional<Livro> book = livroRepository.findById(id);
		if(book.isPresent()) {
			return book;
		}else {
			throw new ObjetoInexistenteException("id "+ id+" not found");			
		}
	}

}
