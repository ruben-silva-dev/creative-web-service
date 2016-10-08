package com.ufc.modulos.brainwriting.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ufc.util.json.CalendarDeserialize;
import com.ufc.util.json.CalendarSerialize;
import com.ufc.util.json.View;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(View.Comentario.class)
	private Long id;

	@Column(columnDefinition = "TEXT")
	@JsonView(View.Comentario.class)
	private String texto;

	@JsonSerialize(using = CalendarSerialize.class)
	@JsonDeserialize(using = CalendarDeserialize.class)
	@JsonView(View.Comentario.class)
	private Calendar data;

	@ManyToOne
	@JsonView(View.Comentario.class)
	private PessoaBrainwriting autor;

	@ManyToOne
	@JsonView(View.Comentario.class)
	private Ideia ideia;

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

	public PessoaBrainwriting getAutor() {
		return autor;
	}

	public void setAutor(PessoaBrainwriting autor) {
		this.autor = autor;
	}

	public Ideia getIdeia() {
		return ideia;
	}

	public void setIdeia(Ideia ideia) {
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
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
