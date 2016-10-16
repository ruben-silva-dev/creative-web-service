package com.ufc.modulos.definicoes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Relacionamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Ideia ideiaRaiz;

	@ManyToOne
	private Ideia ideiaRelacionada;

	private String tipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ideia getIdeiaRaiz() {
		return ideiaRaiz;
	}

	public void setIdeiaRaiz(Ideia ideiaRaiz) {
		this.ideiaRaiz = ideiaRaiz;
	}

	public Ideia getIdeiaRelacionada() {
		return ideiaRelacionada;
	}

	public void setIdeiaRelacionada(Ideia ideiaRelacionada) {
		this.ideiaRelacionada = ideiaRelacionada;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		Relacionamento other = (Relacionamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
