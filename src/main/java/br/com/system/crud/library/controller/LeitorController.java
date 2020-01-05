package br.com.system.crud.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.model.entity.Leitor;
import br.com.system.crud.library.model.response.LeitorResponse;
import br.com.system.crud.library.service.LeitorService;
import br.com.system.crud.library.exception.Resposta;

@RestController
@RequestMapping("reader/")
public class LeitorController {
	
	private LeitorService leitorService;

	@Autowired
	public LeitorController(LeitorService leitorService) {
		this.leitorService = leitorService;
	}
	
	
	@PostMapping("new")
	public ResponseEntity<LeitorResponse> newReader(@RequestBody Leitor leitor){

		leitorService.newReader(leitor);
		
		LeitorResponse readerResponse =  new LeitorResponse();
		readerResponse.setIdLeitor(leitor.getId());
		readerResponse.setCpf(leitor.getCpf());
		readerResponse.setNomeCompleto(leitor.getNomeCompleto());
		
		return ResponseEntity.ok(readerResponse);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Leitor> findById(@PathVariable Long id){
		   return leitorService.findById(id)
		           .map(leitorIn -> ResponseEntity.ok().body(leitorIn))
		           .orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("list")
	public ResponseEntity<Object> listReaders(){
		List<LeitorResponse> readerResponseList = new ArrayList<>();
		List<Leitor> readers = leitorService.listReaders();
		
		try {
			readers.forEach(reader -> readerResponseList.add( new LeitorResponse(
												reader.getId(), 
												reader.getCpf(), 
												reader.getNomeCompleto())));
			
			return ResponseEntity.ok(readerResponseList);
		}catch(ObjetoInexistenteException obj) {
            return ResponseEntity.badRequest().body(new Resposta(obj.getCode(), obj.getLocalizedMessage(), null));
		}
	}


}
