package br.com.system.crud.library.controller;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.exception.Resposta;
import br.com.system.crud.library.model.entity.Local;
import br.com.system.crud.library.model.response.LocalResponse;
import br.com.system.crud.library.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("place/")
public class LocalController {

    private LocalService localService;

    @Autowired
    public LocalController(LocalService localService) {
        this.localService = localService;
    }

    @PostMapping("new")
    public ResponseEntity<LocalResponse> newPlace(@RequestBody Local local){
        localService.newPlace(local);

        LocalResponse placeResponse = new LocalResponse(
                local.getId(),
                local.getDescricao(),
                local.getEstante().getDescricao(),
                local.getEstante().getNivel().getDescricao(),
                local.getCorredor().getDescricao()
        );
        return ResponseEntity.ok(placeResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<Local> findById(@PathVariable Long id){
        return  localService.findById(id)
                .map(localIn -> ResponseEntity.ok().body(localIn))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("list")
    public ResponseEntity<Object> listPlaces(){
        List<LocalResponse> placeResponseList = new ArrayList<>();
        List<Local> places = localService.listPlace();

        try{
            places.forEach(place -> placeResponseList.add(new LocalResponse(
                    place.getId(),
                    place.getDescricao(),
                    place.getEstante().getDescricao(),
                    place.getEstante().getNivel().getDescricao(),
                    place.getCorredor().getDescricao())));

            return ResponseEntity.ok(placeResponseList);
        }catch (ObjetoInexistenteException obj){
            return ResponseEntity.badRequest().body(new Resposta(obj.getCode(), obj.getMessage(), null));
        }
    }

}
