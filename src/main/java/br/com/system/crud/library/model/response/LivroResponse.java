package br.com.system.crud.library.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LivroResponse {

    @JsonProperty("id_livro")
    private Long id;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("autor")
    private String autor;

    @JsonProperty("editora")
    private String editora;

    @JsonProperty("ano")
    private Integer ano;

    public LivroResponse() {}

    public LivroResponse(Long id, String descricao, String autor, String editora, Integer ano) {
        this.id = id;
        this.descricao = descricao;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
