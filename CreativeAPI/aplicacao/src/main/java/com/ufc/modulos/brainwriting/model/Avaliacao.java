package com.ufc.modulos.brainwriting.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@IdClass(AvaliacaoId.class)
public class Avaliacao {

	@JsonView(BrainwritingViews.AvaliacaoView.class)
	private Integer avaliacao;

	@Id
	@ManyToOne
	@JsonView(BrainwritingViews.AvaliacaoView.class)
	private PessoaBrainwriting autor;

	@Id
	@ManyToOne
	@JsonView(BrainwritingViews.AvaliacaoView.class)
	private IdeiaBrainwriting ideia;

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	public PessoaBrainwriting getAutor() {
		return autor;
	}

	public void setAutor(PessoaBrainwriting autor) {
		this.autor = autor;
	}

	public IdeiaBrainwriting getIdeia() {
		return ideia;
	}

	public void setIdeia(IdeiaBrainwriting ideia) {
		this.ideia = ideia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((ideia == null) ? 0 : ideia.hashCode());
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
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (ideia == null) {
			if (other.ideia != null)
				return false;
		} else if (!ideia.equals(other.ideia))
			return false;
		return true;
	}

}
