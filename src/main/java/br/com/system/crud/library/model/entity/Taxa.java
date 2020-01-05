package br.com.system.crud.library.model.entity;

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
	
	private LocalDate dataEmissao;
	
	private LocalDate dataDebito;

	public Taxa() {}

	public Taxa(Long id, String valor, LocalDate dataEmissao, LocalDate dataDebito) {
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

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public LocalDate getDataDebito() {
		return dataDebito;
	}

	public void setDataDebito(LocalDate dataDebito) {
		this.dataDebito = dataDebito;
	}
	
}
