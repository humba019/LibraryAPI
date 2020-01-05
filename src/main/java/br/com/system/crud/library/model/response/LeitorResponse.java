package br.com.system.crud.library.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LeitorResponse {

	@JsonProperty("id_leitor")
	private Long idLeitor;

	@JsonProperty("cpf")
	private String cpf;
	
	@JsonProperty("nome_completo")
	private String nomeCompleto;

	public LeitorResponse() {}
	
	public LeitorResponse(Long idLeitor, String cpf, String nomeCompleto) {
		this.idLeitor = idLeitor;
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
	}

	public Long getIdLeitor() {
		return idLeitor;
	}

	public void setIdLeitor(Long idLeitor) {
		this.idLeitor = idLeitor;
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
