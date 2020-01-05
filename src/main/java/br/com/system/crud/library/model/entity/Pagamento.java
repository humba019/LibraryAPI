package br.com.system.crud.library.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String status;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_fk_atendente",	referencedColumnName = "id")
    private Atendente atendente;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_fk_leitor",	referencedColumnName = "id")
    private Leitor leitor;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_fk_taxa",	referencedColumnName = "id")
    private Taxa taxa;

	public Pagamento() {}

	public Pagamento(Long id, String status, Atendente atendente, Leitor leitor, Taxa taxa) {
		this.id = id;
		this.status = status;
		this.atendente = atendente;
		this.leitor = leitor;
		this.taxa = taxa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Taxa getTaxa() {
		return taxa;
	}

	public void setTaxa(Taxa taxa) {
		this.taxa = taxa;
	}
	
	
}
