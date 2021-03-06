package br.com.system.crud.library.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluguel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonProperty("data_adesao")
	private String dataAdesao;

	@JsonProperty("data_entrega")
	private String dataEntrega;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_fk_atendente",	referencedColumnName = "id")
    private Atendente atendente;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_fk_leitor",	referencedColumnName = "id")
    private Leitor leitor;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_fk_livro",	referencedColumnName = "id")
    private Livro livro;

	public Aluguel() {}

	public Aluguel(Long id, String dataAdesao, String dataEntrega, Atendente atendente, Leitor leitor, Livro livro) {
		this.id = id;
		this.dataAdesao = dataAdesao;
		this.dataEntrega = dataEntrega;
		this.atendente = atendente;
		this.leitor = leitor;
		this.livro = livro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public Leitor getLeitor() {
		return leitor;
	}

	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
