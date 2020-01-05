package br.com.system.crud.library.controller;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.exception.Resposta;
import br.com.system.crud.library.model.entity.Leitor;
import br.com.system.crud.library.model.entity.Turno;
import br.com.system.crud.library.model.response.TurnoResponse;
import br.com.system.crud.library.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("bout/")
public class TurnoController {

    private TurnoService turnoService;

    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping("new")
    public ResponseEntity<TurnoResponse> newBout(@RequestBody Turno turno){
        turnoService.newBout(turno);

        TurnoResponse boutResponse = new TurnoResponse(
                turno.getId(),
                turno.getDescricao()
        );

        return ResponseEntity.ok(boutResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<Turno> findById(@PathVariable Long id) {
        return turnoService.findById(id)
                .map(turnoIn -> ResponseEntity.ok().body(turnoIn))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("list")
    public ResponseEntity<Object> listBout(){
        List<TurnoResponse> boutResponseList =  new ArrayList<>();
        List<Turno> bouts =  turnoService.listBout();

        try{
            bouts.forEach(bout -> boutResponseList.add( new TurnoResponse(
                    bout.getId(),
                    bout.getDescricao())));

            return ResponseEntity.ok(boutResponseList);
        }catch(ObjetoInexistenteException obj) {
            return ResponseEntity.badRequest().body(new Resposta(obj.getCode(), obj.getLocalizedMessage(), null));
        }
    }

}
