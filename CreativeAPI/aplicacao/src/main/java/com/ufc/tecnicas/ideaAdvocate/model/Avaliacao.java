package com.ufc.tecnicas.ideaAdvocate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.tecnicas.model.Pessoa;

@Entity
@Table(name = "advocate_avaliacao")
public class Avaliacao {

	@Id
	@GeneratedValue
	private Long id;

	private Integer voto;

	@ManyToOne
	private Pessoa votante;

	@ManyToOne
	private AdvocateIdeia ideia;

	@JsonView(AdvocateViews.IdeiaDetalhes.class)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonView(AdvocateViews.IdeiaDetalhes.class)
	public Integer getVoto() {
		return voto;
	}

	public void setVoto(Integer voto) {
		this.voto = voto;
	}

	public Pessoa getVotante() {
		return votante;
	}

	public void setVotante(Pessoa votante) {
		this.votante = votante;
	}

	@JsonView(AdvocateViews.IdeiaDetalhes.class)
	public PessoaAdvocate votante() {
		return new PessoaAdvocate(votante);
	}

	public AdvocateIdeia getIdeia() {
		return ideia;
	}

	public void setIdeia(AdvocateIdeia ideia) {
		this.ideia = ideia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avaliacao other = (Avaliacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
