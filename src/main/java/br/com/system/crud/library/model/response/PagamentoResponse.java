package br.com.system.crud.library.model.response;

import br.com.system.crud.library.model.entity.Atendente;
import br.com.system.crud.library.model.entity.Leitor;
import br.com.system.crud.library.model.entity.Taxa;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PagamentoResponse {


    @JsonProperty("id_pagamento")
    private Long id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("nome_atendente")
    private String nomeAtendente;

    @JsonProperty("nome_leitor")
    private String nomeLeitor;

    @JsonProperty("valor_taxa")
    private String valorTaxa;

    public PagamentoResponse() {}

    public PagamentoResponse(Long id, String status, String nomeAtendente, String nomeLeitor, String valorTaxa) {
        this.id = id;
        this.status = status;
        this.nomeAtendente = nomeAtendente;
        this.nomeLeitor = nomeLeitor;
        this.valorTaxa = valorTaxa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomeAtendente() {
        return nomeAtendente;
    }

    public void setNomeAtendente(String nomeAtendente) {
        this.nomeAtendente = nomeAtendente;
    }

    public String getNomeLeitor() {
        return nomeLeitor;
    }

    public void setNomeLeitor(String nomeLeitor) {
        this.nomeLeitor = nomeLeitor;
    }

    public String getValorTaxa() {
        return valorTaxa;
    }

    public void setValorTaxa(String valorTaxa) {
        this.valorTaxa = valorTaxa;
    }
}
