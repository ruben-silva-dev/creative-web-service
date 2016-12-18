package com.ufc.tecnicas.ideaAdvocate.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ufc.tecnicas.model.Pessoa;
import com.ufc.util.json.CalendarDeserialize;
import com.ufc.util.json.CalendarSerialize;

@Entity
@Table(name = "advocate_comentario")
public class Comentario {

	@Id
	@GeneratedValue
	private Long id;

	private String texto;

	@JsonSerialize(using = CalendarSerialize.class)
	@JsonDeserialize(using = CalendarDeserialize.class)
	private Calendar data;

	@ManyToOne
	private Pessoa autor;

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
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@JsonView(AdvocateViews.IdeiaDetalhes.class)
	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Pessoa getAutor() {
		return autor;
	}

	@JsonView(AdvocateViews.IdeiaDetalhes.class)
	public PessoaAdvocate autor() {
		return new PessoaAdvocate(autor);
	}

	public void setAutor(Pessoa autor) {
		this.autor = autor;
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
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
