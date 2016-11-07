package com.ufc.geral.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ufc.geral.json.CalendarDeserialize;
import com.ufc.geral.json.CalendarSerialize;
import com.ufc.modulos.relacionamento.RelacionamentoViews;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Ideia {

	@Id
	@GeneratedValue
	private Long id;

	@Column(columnDefinition = "TEXT")
	private String texto;

	@JsonSerialize(using = CalendarSerialize.class)
	@JsonDeserialize(using = CalendarDeserialize.class)
	private Calendar data;

	@ManyToOne
	private Tecnica tecnica;

	@JsonView(RelacionamentoViews.RelacionamentoView.class)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Tecnica getTecnica() {
		return tecnica;
	}

	public void setTecnica(Tecnica tecnica) {
		this.tecnica = tecnica;
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
		Ideia other = (Ideia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
