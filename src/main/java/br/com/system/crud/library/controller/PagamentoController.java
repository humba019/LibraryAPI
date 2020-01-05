package br.com.system.crud.library.controller;

import br.com.system.crud.library.exception.ObjetoInexistenteException;
import br.com.system.crud.library.exception.Resposta;
import br.com.system.crud.library.model.entity.Pagamento;
import br.com.system.crud.library.model.response.PagamentoResponse;
import br.com.system.crud.library.service.PagamentoService;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("payment/")
public class PagamentoController {

    private PagamentoService pagamentoService;

    @Autowired
    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("new")
    public ResponseEntity<PagamentoResponse> newPayment(@RequestBody Pagamento pagamento){
        pagamentoService.newPayment(pagamento);

        PagamentoResponse paymentResponse = new PagamentoResponse(
                pagamento.getId(),
                pagamento.getStatus(),
                pagamento.getAtendente().getNomeCompleto(),
                pagamento.getLeitor().getNomeCompleto(),
                pagamento.getTaxa().getValor()
        );


        return ResponseEntity.ok(paymentResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<Pagamento> findById(@PathVariable Long id){
        return pagamentoService.findById(id)
                .map(pagamentoIn -> ResponseEntity.ok().body(pagamentoIn))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("list")
    public ResponseEntity<Object> listPayments(){
        List<PagamentoResponse> paymentResponseList = new ArrayList<>();
        List<Pagamento> payments = pagamentoService.listPayment();

        try{
            payments.forEach(payment -> paymentResponseList.add(new PagamentoResponse(
                    payment.getId(),
                    payment.getStatus(),
                    payment.getAtendente().getNomeCompleto(),
                    payment.getLeitor().getNomeCompleto(),
                    payment.getTaxa().getValor())));

            return ResponseEntity.ok(paymentResponseList);
        }catch(ObjetoInexistenteException obj) {
            return ResponseEntity.badRequest().body(new Resposta(obj.getCode(), obj.getLocalizedMessage(), null));
        }
    }
}
