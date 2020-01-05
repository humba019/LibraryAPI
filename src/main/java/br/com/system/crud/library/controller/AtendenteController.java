package br.com.system.crud.library.controller;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.exception.Resposta;
import br.com.system.crud.library.model.entity.Atendente;
import br.com.system.crud.library.model.response.AtendenteResponse;
import br.com.system.crud.library.service.AtendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("clerk/")
public class AtendenteController {

    private AtendenteService atendenteService;

    @Autowired
    public AtendenteController(AtendenteService atendenteService) {
        this.atendenteService = atendenteService;
    }

    @PostMapping("new")
    public ResponseEntity<AtendenteResponse> newClerk(@RequestBody Atendente atendente){

        atendenteService.newClerk(atendente);

        AtendenteResponse clerkResponse = new AtendenteResponse(
                atendente.getId(),
                atendente.getCpf(),
                atendente.getNomeCompleto()
        );

        return ResponseEntity.ok(clerkResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<Atendente> findById(@PathVariable Long id){
        return atendenteService.findById(id)
                .map(clerkIn -> ResponseEntity.ok().body(clerkIn))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("list")
    public ResponseEntity<Object> listClerks(){
        List<AtendenteResponse> clerkResponseList = new ArrayList<>();
        List<Atendente> clerks = atendenteService.listClerk();

        try {
            clerks.forEach(clerk -> clerkResponseList.add( new AtendenteResponse(
                    clerk.getId(),
                    clerk.getCpf(),
                    clerk.getNomeCompleto())));

            return ResponseEntity.ok(clerkResponseList);
        }catch(ObjetoInexistenteException obj) {
            return ResponseEntity.badRequest().body(new Resposta(obj.getCode(), obj.getLocalizedMessage(), null));
        }
    }



}
