package com.ufc.tecnicas.brainwriting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.tecnicas.model.Pessoa;

@Entity
public class Avaliacao {

	@Id
	@GeneratedValue
	private Long id;

	private Integer avaliacao;

	@ManyToOne
	private Pessoa autor;

	@ManyToOne
	private IdeiaBrainwriting ideia;

	@JsonView(BrainwritingViews.IdeiaDetalhes.class)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonView(BrainwritingViews.IdeiaDetalhes.class)
	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Pessoa getAutor() {
		return autor;
	}

	public void setAutor(Pessoa autor) {
		this.autor = autor;
	}

	@JsonView(BrainwritingViews.IdeiaDetalhes.class)
	public PessoaBrainwriting autor() {
		return new PessoaBrainwriting(autor);
	}

	@JsonIgnore
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
