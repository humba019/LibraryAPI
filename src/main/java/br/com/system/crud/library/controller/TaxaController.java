package br.com.system.crud.library.controller;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.exception.Resposta;
import br.com.system.crud.library.model.entity.Taxa;
import br.com.system.crud.library.model.response.TaxaResponse;
import br.com.system.crud.library.service.TaxaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rate/")
public class TaxaController {

    private TaxaService taxaService;

    @Autowired
    public TaxaController(TaxaService taxaService) {
        this.taxaService = taxaService;
    }

    @PostMapping("new")
    public ResponseEntity<TaxaResponse> newRate(@RequestBody Taxa taxa){
        taxaService.newRate(taxa);
        TaxaResponse rateResponse = new TaxaResponse(
                taxa.getId(),
                taxa.getValor());

        return ResponseEntity.ok(rateResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<Taxa> findById(@PathVariable Long id){
        return taxaService.findById(id)
                .map(taxaIn -> ResponseEntity.ok().body(taxaIn))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("list")
    public ResponseEntity<Object> listRates(){
        List<TaxaResponse> rateResponseList = new ArrayList<>();
        List<Taxa> rates =  taxaService.listRate();

        try{
            rates.forEach(rate -> rateResponseList.add(new TaxaResponse(
                    rate.getId(),
                    rate.getValor())));
            return ResponseEntity.ok(rateResponseList);
        }catch(ObjetoInexistenteException obj) {
            return ResponseEntity.badRequest().body(new Resposta(obj.getCode(), obj.getLocalizedMessage(), null));
        }
    }
}
