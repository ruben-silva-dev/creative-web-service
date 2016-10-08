package com.ufc.modulos.brainwriting.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ufc.util.json.CalendarDeserialize;
import com.ufc.util.json.CalendarSerialize;
import com.ufc.util.json.View;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Ideia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView({ View.Ideia.class, View.Avaliacao.class, View.Comentario.class })
	private Long id;

	@Column(columnDefinition = "TEXT")
	@JsonView(View.Ideia.class)
	private String texto;

	@JsonSerialize(using = CalendarSerialize.class)
	@JsonDeserialize(using = CalendarDeserialize.class)
	@JsonView(View.Ideia.class)
	private Calendar data;

	@ManyToMany(mappedBy = "ideias")
	private List<Brainwriting> brainwriting;

	@ManyToMany
	@JoinTable(name = "autor", joinColumns = @JoinColumn(name = "ideia_id"), inverseJoinColumns = @JoinColumn(name = "pessoa_id"))
	private List<PessoaBrainwriting> autores;

	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "ideia", cascade = CascadeType.MERGE)
	private List<Avaliacao> avaliacoes;

	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "ideia", cascade = CascadeType.MERGE)
	private List<Comentario> comentarios;

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

	public List<Brainwriting> getBrainwriting() {
		return brainwriting;
	}

	public void setBrainwriting(List<Brainwriting> brainwriting) {
		this.brainwriting = brainwriting;
	}

	public void addBrainwriting(Brainwriting brainwriting) {
		if (this.brainwriting == null) {
			this.brainwriting = new ArrayList<>();
		}

		this.brainwriting.add(brainwriting);
	}

	public List<PessoaBrainwriting> getAutores() {
		return autores;
	}

	public void setAutores(List<PessoaBrainwriting> autores) {
		this.autores = autores;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public void addAvaliacao(Avaliacao avaliacao) {
		if (this.avaliacoes == null) {
			this.avaliacoes = new ArrayList<>();
		}

		avaliacao.setIdeia(this);
		this.avaliacoes.add(avaliacao);
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public void addComentario(Comentario comentario) {
		if (this.comentarios == null) {
			this.comentarios = new ArrayList<>();
		}

		comentario.setIdeia(this);
		this.comentarios.add(comentario);
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
