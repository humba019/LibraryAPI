package br.com.system.crud.library.controller;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.exception.Resposta;
import br.com.system.crud.library.model.entity.Nivel;
import br.com.system.crud.library.service.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("level/")
public class NivelController {

    private NivelService nivelService;

    @Autowired
    public NivelController(NivelService nivelService) {
        this.nivelService = nivelService;
    }

    @PostMapping("new")
    public ResponseEntity<Nivel> newLevel(@RequestBody Nivel nivel){
        nivelService.newLevel(nivel);
        return ResponseEntity.ok(nivel);
    }

    @GetMapping("{id}")
    public ResponseEntity<Nivel> findById(@PathVariable Long id){
        return nivelService.findById(id)
                .map(nivelIn -> ResponseEntity.ok().body(nivelIn))
                .orElse(ResponseEntity.notFound().build());

    }
    @GetMapping("list")
    public ResponseEntity<Object> listLevel(){
        List<Nivel>  levelResponseList =  new ArrayList<>();
        List<Nivel> levels = nivelService.listLevel();
        try {
            levels.forEach(level -> levelResponseList.add(new Nivel(
                    level.getId(),
                    level.getDescricao()
            )));

            return ResponseEntity.ok(levelResponseList);
        }catch(ObjetoInexistenteException obj) {
            return ResponseEntity.badRequest().body(new Resposta(obj.getCode(), obj.getLocalizedMessage(), null));
        }
    }

}
