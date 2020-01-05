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
	@JoinColumn(name = "id_fk_nivel",	referencedColumnName = "id")
    private Nivel nivel;

	public Estante() {}

	public Estante(Long id, String descricao, Nivel nivel) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.nivel = nivel;
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

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}	
	
}
