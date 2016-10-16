package com.ufc.modulos.brainwriting.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.modulos.definicoes.Ideia;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class IdeiaBrainwriting extends Ideia {

	@ManyToMany
	@JoinTable(name = "autor", joinColumns = @JoinColumn(name = "ideia_id"), inverseJoinColumns = @JoinColumn(name = "pessoa_id"))
	private List<PessoaBrainwriting> autores;

	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "ideia", cascade = CascadeType.MERGE)
	private List<Avaliacao> avaliacoes;

	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "ideia", cascade = CascadeType.MERGE)
	private List<Comentario> comentarios;

	@Override
	@JsonView({ BrainwritingViews.IdeiaBrainwritingView.class, BrainwritingViews.AvaliacaoView.class, BrainwritingViews.ComentarioView.class })
	public Long getId() {
		return super.getId();
	}

	@Override
	@JsonView(BrainwritingViews.IdeiaBrainwritingView.class)
	public String getTexto() {
		return super.getTexto();
	}

	@Override
	@JsonView(BrainwritingViews.IdeiaBrainwritingView.class)
	public Calendar getData() {
		return super.getData();
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

}
