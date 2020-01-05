package br.com.system.crud.library.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocalResponse {

    @JsonProperty("id_local")
    private Long id;

    @JsonProperty("descricao_local")
    private String descricaoLocal;

    @JsonProperty("descricao_estante")
    private String descricaoEstante;

    @JsonProperty("descricao_nivel")
    private String descricaoNivel;

    @JsonProperty("descricao_corredor")
    private String descricaoCorredor;

    public LocalResponse() {}

    public LocalResponse(Long id, String descricaoLocal, String descricaoEstante, String descricaoNivel, String descricaoCorredor) {
        this.id = id;
        this.descricaoLocal = descricaoLocal;
        this.descricaoEstante = descricaoEstante;
        this.descricaoNivel = descricaoNivel;
        this.descricaoCorredor = descricaoCorredor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoLocal() {
        return descricaoLocal;
    }

    public void setDescricaoLocal(String descricaoLocal) {
        this.descricaoLocal = descricaoLocal;
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

    public String getDescricaoCorredor() {
        return descricaoCorredor;
    }

    public void setDescricaoCorredor(String descricaoCorredor) {
        this.descricaoCorredor = descricaoCorredor;
    }
}
