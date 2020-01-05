package br.com.system.crud.library.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtendenteResponse {

    @JsonProperty("id_atendente")
    private Long idAtendente;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("nome_completo")
    private String nomeCompleto;

    public AtendenteResponse() {
    }

    public AtendenteResponse(Long idAtendente, String cpf, String nomeCompleto) {
        this.idAtendente = idAtendente;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
    }

    public Long getIdAtendente() {
        return idAtendente;
    }

    public void setIdAtendente(Long idAtendente) {
        this.idAtendente = idAtendente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
}
