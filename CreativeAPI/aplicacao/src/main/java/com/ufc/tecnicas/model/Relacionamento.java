package com.ufc.tecnicas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "relacionamento")
public class Relacionamento {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	private Tecnica tecnicaRaiz;

	@ManyToOne
	private Tecnica tecnicaRelacionada;

	private String tipoRelacionamento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tecnica getTecnicaRaiz() {
		return tecnicaRaiz;
	}

	public void setTecnicaRaiz(Tecnica tecnicaRaiz) {
		this.tecnicaRaiz = tecnicaRaiz;
	}

	public Tecnica getTecnicaRelacionada() {
		return tecnicaRelacionada;
	}

	public void setTecnicaRelacionada(Tecnica tecnicaRelacionada) {
		this.tecnicaRelacionada = tecnicaRelacionada;
	}

	public String getTipoRelacionamento() {
		return tipoRelacionamento;
	}

	public void setTipoRelacionamento(String tipoRelacionamento) {
		this.tipoRelacionamento = tipoRelacionamento;
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
