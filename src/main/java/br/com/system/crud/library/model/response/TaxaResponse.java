package br.com.system.crud.library.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxaResponse {

    @JsonProperty("id_taxa")
    private Long id;

    @JsonProperty("valor")
    private String valor;

    public TaxaResponse() {}

    public TaxaResponse(Long id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
