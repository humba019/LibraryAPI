package br.com.system.crud.library.controller;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.exception.Resposta;
import br.com.system.crud.library.model.entity.Corredor;
import br.com.system.crud.library.service.CorredorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("hall/")
public class CorredorController {

    private CorredorService corredorService;

    @Autowired
    public CorredorController(CorredorService corredorService) {
        this.corredorService = corredorService;
    }
    @PostMapping("new")
    public ResponseEntity<Corredor> newHall(@RequestBody Corredor corredor){
        corredorService.newHall(corredor);
        return ResponseEntity.ok(corredor);
    }
    @GetMapping("{id}")
    public ResponseEntity<Corredor> findById(@PathVariable Long id) {
        return corredorService.findById(id)
                .map(corredorIn -> ResponseEntity.ok().body(corredorIn))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("list")
    public ResponseEntity<Object> listHalls() {
        List<Corredor> hallResponseList = new ArrayList<>();
        List<Corredor> halls = corredorService.listHall();
        try{
            halls.forEach(hall -> hallResponseList.add(new Corredor(
                    hall.getId(),
                    hall.getDescricao())));

            return ResponseEntity.ok(hallResponseList);
        }catch(ObjetoInexistenteException obj) {
            return ResponseEntity.badRequest().body(new Resposta(obj.getCode(), obj.getLocalizedMessage(), null));
        }
    }

}
