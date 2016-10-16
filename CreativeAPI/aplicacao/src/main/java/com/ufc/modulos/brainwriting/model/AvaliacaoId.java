package com.ufc.modulos.brainwriting.model;

import java.io.Serializable;

public class AvaliacaoId implements Serializable {

	private static final long serialVersionUID = 1L;

	private PessoaBrainwriting autor;

	private IdeiaBrainwriting ideia;

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
		AvaliacaoId other = (AvaliacaoId) obj;
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
