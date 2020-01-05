package br.com.system.crud.library.controller;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.exception.Resposta;
import br.com.system.crud.library.model.entity.Livro;
import br.com.system.crud.library.model.response.LivroResponse;
import br.com.system.crud.library.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("book/")
public class LivroController {

    private LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("new")
    public ResponseEntity<LivroResponse> newBook(@RequestBody Livro livro){
        livroService.newBook(livro);

        LivroResponse bookResponse = new LivroResponse(
                livro.getId(),
                livro.getDescricao(),
                livro.getAutor(),
                livro.getEditora(),
                livro.getAno()
        );

        return ResponseEntity.ok(bookResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        return livroService.findById(id)
                .map(livroIn -> ResponseEntity.ok().body(livroIn))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("list")
    public ResponseEntity<Object> listBooks(){
        List<LivroResponse> bookResponseList =  new ArrayList<>();
        List<Livro> books = livroService.listBook();

        try{
            books.forEach(book -> bookResponseList.add( new LivroResponse(
                    book.getId(),
                    book.getDescricao(),
                    book.getAutor(),
                    book.getEditora(),
                    book.getAno())));

            return  ResponseEntity.ok(bookResponseList);
        }catch(ObjetoInexistenteException obj) {
            return ResponseEntity.badRequest().body(new Resposta(obj.getCode(), obj.getLocalizedMessage(), null));
        }
    }

}
