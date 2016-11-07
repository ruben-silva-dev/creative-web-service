package com.ufc.tecnicas.brainwriting.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.tecnicas.model.Ideia;
import com.ufc.tecnicas.model.Pessoa;
import com.ufc.tecnicas.model.Tecnica;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class IdeiaBrainwriting extends Ideia {

	@ManyToOne
	private Pessoa autor;

	@ApiModelProperty(hidden = true)
	@OneToMany
	@JoinColumn(name = "ideia_id")
	private List<Avaliacao> avaliacoes;

	@ApiModelProperty(hidden = true)
	@OneToMany
	@JoinColumn(name = "ideia_id")
	private List<Comentario> comentarios;

	@Override
	@JsonView({ BrainwritingViews.BrainwritingDetalhes.class, BrainwritingViews.IdeiaDetalhes.class })
	public Long getId() {
		return super.getId();
	}

	@Override
	@JsonView({ BrainwritingViews.BrainwritingDetalhes.class, BrainwritingViews.IdeiaDetalhes.class })
	public String getTexto() {
		return super.getTexto();
	}

	@Override
	@JsonView({ BrainwritingViews.BrainwritingDetalhes.class, BrainwritingViews.IdeiaDetalhes.class })
	public Calendar getData() {
		return super.getData();
	}

	public Pessoa getAutor() {
		return autor;
	}

	public void setAutor(Pessoa autor) {
		this.autor = autor;
	}

	@JsonView({ BrainwritingViews.BrainwritingDetalhes.class, BrainwritingViews.IdeiaDetalhes.class })
	public PessoaBrainwriting autor() {
		return new PessoaBrainwriting(autor);
	}

	@JsonView(BrainwritingViews.IdeiaDetalhes.class)
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	@JsonView(BrainwritingViews.BrainwritingDetalhes.class)
	public Integer numeroAvaliacoes() {
		return avaliacoes.size();
	}

	public void addAvaliacao(Avaliacao avaliacao) {
		if (this.avaliacoes == null) {
			this.avaliacoes = new ArrayList<>();
		}

		avaliacao.setIdeia(this);
		this.avaliacoes.add(avaliacao);
	}

	@JsonView(BrainwritingViews.IdeiaDetalhes.class)
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@JsonView(BrainwritingViews.BrainwritingDetalhes.class)
	public Integer numeroComentarios() {
		return comentarios.size();
	}

	public void addComentario(Comentario comentario) {
		if (this.comentarios == null) {
			this.comentarios = new ArrayList<>();
		}

		comentario.setIdeia(this);
		this.comentarios.add(comentario);
	}

	@JsonIgnore
	@Override
	public Tecnica getTecnica() {
		return super.getTecnica();
	}

}
