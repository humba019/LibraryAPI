package br.com.system.crud.library.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstanteResponse {

    @JsonProperty("id_estante")
    private Long id;

    @JsonProperty("descricao_estante")
    private String descricaoEstante;

    @JsonProperty("descricao_nivel")
    private String descricaoNivel;

    public EstanteResponse() {}

    public EstanteResponse(Long id, String descricaoEstante, String descricaoNivel) {
        this.id = id;
        this.descricaoEstante = descricaoEstante;
        this.descricaoNivel = descricaoNivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoEstante() {
        return descricaoEstante;
    }

    public void setDescricaoEstante(String descricaoEstante) {
        this.descricaoEstante = descricaoEstante;
    }

    public String getDescricaoNivel() {
        return descricaoNivel;
    }

    public void setDescricaoNivel(String descricaoNivel) {
        this.descricaoNivel = descricaoNivel;
    }
}
