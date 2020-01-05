package br.com.system.crud.library.controller;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.exception.Resposta;
import br.com.system.crud.library.model.entity.Aluguel;
import br.com.system.crud.library.model.response.AluguelResponse;
import br.com.system.crud.library.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rent/")
public class AluguelController {

    private AluguelService aluguelService;

    @Autowired
    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @PostMapping("new")
    public ResponseEntity<AluguelResponse> newRent(@RequestBody Aluguel aluguel){

        aluguelService.newRent(aluguel);

        AluguelResponse rentResponse = new AluguelResponse(
                aluguel.getId(),
                aluguel.getLeitor().getNomeCompleto(),
                aluguel.getLivro().getDescricao(),
                aluguel.getDataAdesao(),
                aluguel.getDataEntrega()
        );

        return ResponseEntity.ok(rentResponse);

    }

    @GetMapping("{id}")
    public ResponseEntity<Aluguel> findById(@PathVariable Long id){
        return aluguelService.findById(id)
                .map(aluguelIn -> ResponseEntity.ok().body(aluguelIn))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("list")
    public ResponseEntity<Object> lsitRents(){
        List<AluguelResponse> rentReponseList = new ArrayList<>();
        List<Aluguel> rents = aluguelService.listRent();

        try{
            rents.forEach(rent -> rentReponseList.add(new AluguelResponse(
                    rent.getId(),
                    rent.getLeitor().getNomeCompleto(),
                    rent.getLivro().getDescricao(),
                    rent.getDataAdesao(),
                    rent.getDataEntrega())));

            return ResponseEntity.ok(rentReponseList);
        }catch (ObjetoInexistenteException obj){
            return ResponseEntity.badRequest().body(new Resposta(obj.getCode(), obj.getLocalizedMessage(), null));
        }
    }



}
