package br.com.system.crud.library.controller;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.exception.Resposta;
import br.com.system.crud.library.model.entity.Estante;
import br.com.system.crud.library.model.response.EstanteResponse;
import br.com.system.crud.library.service.EstanteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("shelf/")
public class EstanteController {

    private EstanteService estanteService;

    @Autowired
    public EstanteController(EstanteService estanteService) {
        this.estanteService = estanteService;
    }

    @PostMapping("new")
    public ResponseEntity<EstanteResponse> newShelf(@RequestBody Estante estante){
        estanteService.newShelf(estante);

        EstanteResponse shelfResponse = new EstanteResponse(
                estante.getId(),
                estante.getDescricao(),
                estante.getNivel().getDescricao()
        );

        return ResponseEntity.ok(shelfResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<Estante> findById(@PathVariable Long id){
        return estanteService.findById(id)
                .map(estanteIn -> ResponseEntity.ok().body(estanteIn))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("list")
    public ResponseEntity<Object> listShelfs(){
        List<EstanteResponse> shelfResponseList = new ArrayList<>();
        List<Estante> shelfs = estanteService.listShelf();
        try{
            shelfs.forEach(shelf -> shelfResponseList.add(new EstanteResponse(
                    shelf.getId(),
                    shelf.getDescricao(),
                    shelf.getNivel().getDescricao())));
            return ResponseEntity.ok(shelfResponseList);
        }catch(ObjetoInexistenteException obj) {
            return ResponseEntity.badRequest().body(new Resposta(obj.getCode(), obj.getLocalizedMessage(), null));
        }
    }


    }
