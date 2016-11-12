package com.ufc.tecnicas.brainwriting.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.tecnicas.model.Ideia;
import com.ufc.tecnicas.model.Pessoa;
import com.ufc.tecnicas.model.Tecnica;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "brainwriting_ideia")
public class BrainwritingIdeia extends Ideia {

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

	@Override
	@JsonView({ BrainwritingViews.BrainwritingDetalhes.class, BrainwritingViews.IdeiaDetalhes.class })
	public String getTitulo() {
		return super.getTitulo();
	}

	@JsonIgnore
	@Override
	public Tecnica getTecnica() {
		return super.getTecnica();
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

}
