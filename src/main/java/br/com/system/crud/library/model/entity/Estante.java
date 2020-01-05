package br.com.system.crud.library.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Estante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_fk_prateleira",	referencedColumnName = "id")
    private Prateleira prateleira;

	public Estante() {}

	public Estante(Long id, String descricao, Prateleira prateleira) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.prateleira = prateleira;
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

	public Prateleira getPrateleira() {
		return prateleira;
	}

	public void setPrateleira(Prateleira prateleira) {
		this.prateleira = prateleira;
	}	
	
}
