package br.com.system.crud.library.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TurnoResponse {

    @JsonProperty("id_turno")
    private Long id;

    @JsonProperty("descricao")
    private String descricao;

    public TurnoResponse() {}

    public TurnoResponse(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
