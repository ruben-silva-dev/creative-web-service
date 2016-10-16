package com.ufc.modulos.brainwriting.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.modulos.definicoes.Ideia;
import com.ufc.modulos.definicoes.Tecnica;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Brainwriting extends Tecnica {

	private String gatilho;

	private String descricao;

	@Enumerated(EnumType.STRING)
	private Fase fase;

	@ManyToMany(mappedBy = "brainwriting")
	private List<PessoaBrainwriting> moderadores;

	@ApiModelProperty(hidden = true)
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "participacao", joinColumns = @JoinColumn(name = "brainwriting_id"), inverseJoinColumns = @JoinColumn(name = "pessoa_id"))
	private List<PessoaBrainwriting> participantes;

	public Brainwriting() {
		super("brainwriting");
	}

	@Override
	@JsonView(BrainwritingViews.BrainwritingView.class)
	public Long getId() {
		return super.getId();
	}

	@Override
	@JsonView(BrainwritingViews.BrainwritingView.class)
	public String getTitulo() {
		return super.getTitulo();
	}

	@Override
	@JsonView(BrainwritingViews.BrainwritingView.class)
	public String getTipo() {
		return super.getTipo();
	}

	@JsonView(BrainwritingViews.BrainwritingView.class)
	public String getGatilho() {
		return gatilho;
	}

	public void setGatilho(String gatilho) {
		this.gatilho = gatilho;
	}

	@JsonView(BrainwritingViews.BrainwritingView.class)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@JsonView(BrainwritingViews.BrainwritingView.class)
	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public List<PessoaBrainwriting> getModeradores() {
		return moderadores;
	}

	public void setModeradores(List<PessoaBrainwriting> moderadores) {
		this.moderadores = moderadores;
	}

	public List<PessoaBrainwriting> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<PessoaBrainwriting> participantes) {
		this.participantes = participantes;
	}

	public void addParticipante(PessoaBrainwriting pessoa) {
		if (this.participantes == null) {
			this.participantes = new ArrayList<>();
		}

		this.participantes.add(pessoa);
	}

	@ApiModelProperty(hidden = true)
	@Override
	public List<Ideia> getIdeias() {
		return super.getIdeias();
	}

	public void addIdeia(IdeiaBrainwriting ideia) {
		if (ideias == null) {
			ideias = new ArrayList<>();
		}

		this.ideias.add(ideia);
	}

	public enum Fase {
		NOVA("Nova"), RECEBENDO_IDEIAS("Recebendo ideias"), DISCUTINDO_IDEIAS("Discutindo ideias"), AVALIANDO_IDEIAS(
				"Avaliando ideias"), ENCERRADA("Encerrada");

		private String descricao;

		private Fase(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}
	}

}
