package com.ufc.modulos.brainwriting.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.modulos.definicoes.Pessoa;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class PessoaBrainwriting extends Pessoa {

	@ApiModelProperty(hidden = true)
	@ManyToMany(mappedBy = "participantes")
	private List<Brainwriting> participacoes;

	@ApiModelProperty(hidden = true)
	@ManyToMany(mappedBy = "autores")
	private List<IdeiaBrainwriting> ideias;

	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "autor")
	private List<Avaliacao> avaliacoes;

	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "autor")
	private List<Comentario> comentarios;

	@ApiModelProperty(hidden = true)
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "moderadores", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "brainwriting_id"))
	private List<Brainwriting> brainwriting;

	@Override
	@JsonView({ BrainwritingViews.BrainwritingPessoaView.class, BrainwritingViews.AvaliacaoView.class, BrainwritingViews.ComentarioView.class })
	public Long getId() {
		return super.getId();
	}

	@Override
	@JsonView(BrainwritingViews.BrainwritingPessoaView.class)
	public String getNome() {
		return super.getNome();
	}

	@Override
	@JsonView(BrainwritingViews.BrainwritingPessoaView.class)
	public String getEmail() {
		return super.getEmail();
	}

	public List<Brainwriting> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Brainwriting> participacoes) {
		this.participacoes = participacoes;
	}

	public List<IdeiaBrainwriting> getIdeias() {
		return ideias;
	}

	public void setIdeias(List<IdeiaBrainwriting> ideias) {
		this.ideias = ideias;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
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

}
