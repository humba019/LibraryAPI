package br.com.system.crud.library.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AluguelResponse {

    @JsonProperty("id_aluguel")
    private Long id;

    @JsonProperty("nome_leitor")
    private String nomeLeitor;

    @JsonProperty("nome_livro")
    private String nomeLivro;

    @JsonProperty("data_adesao")
    private String dataAdesao;

    @JsonProperty("data_entrega")
    private String dataEntrega;

    public AluguelResponse() {}

    public AluguelResponse(Long id,
                           String nomeLeitor,
                           String nomeLivro,
                           String dataAdesao,
                           String dataEntrega) {

        this.id = id;
        this.nomeLeitor = nomeLeitor;
        this.nomeLivro = nomeLivro;
        this.dataAdesao = dataAdesao;
        this.dataEntrega = dataEntrega;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeLeitor() {
        return nomeLeitor;
    }

    public void setNomeLeitor(String nomeLeitor) {
        this.nomeLeitor = nomeLeitor;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getDataAdesao() {
        return dataAdesao;
    }

    public void setDataAdesao(String dataAdesao) {
        this.dataAdesao = dataAdesao;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
