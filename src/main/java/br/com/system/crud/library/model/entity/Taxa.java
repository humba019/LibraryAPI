package br.com.system.crud.library.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Taxa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String valor;

	@JsonProperty("data_emissao")
	private String dataEmissao;

	@JsonProperty("data_debito")
	private String dataDebito;

	public Taxa() {}

	public Taxa(Long id, String valor, String dataEmissao, String dataDebito) {
		this.id = id;
		this.valor = valor;
		this.dataEmissao = dataEmissao;
		this.dataDebito = dataDebito;
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

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getDataDebito() {
		return dataDebito;
	}

	public void setDataDebito(String dataDebito) {
		this.dataDebito = dataDebito;
	}
	
}
