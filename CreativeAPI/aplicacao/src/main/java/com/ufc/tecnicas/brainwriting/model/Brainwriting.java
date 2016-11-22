package com.ufc.tecnicas.brainwriting.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.tecnicas.model.Ideia;
import com.ufc.tecnicas.model.Pessoa;
import com.ufc.tecnicas.model.Tecnica;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "brainwriting")
public class Brainwriting extends Tecnica {

	private String gatilho;

	private String descricao;

	@Enumerated(EnumType.STRING)
	private Fase fase;

	@ManyToOne
	private Pessoa facilitador;

	@ApiModelProperty(hidden = true)
	@ManyToMany
	@JoinTable(name = "brainwriting_participacao", joinColumns = @JoinColumn(name = "brainwriting_id"), inverseJoinColumns = @JoinColumn(name = "pessoa_id"))
	private List<Pessoa> participantes;

	public Brainwriting() {
		super("brainwriting");
	}

	@Override
	@JsonView({ BrainwritingViews.BrainwritingResumo.class, BrainwritingViews.BrainwritingDetalhes.class })
	public Long getId() {
		return super.getId();
	}

	@Override
	@JsonView({ BrainwritingViews.BrainwritingResumo.class, BrainwritingViews.BrainwritingDetalhes.class })
	public String getTitulo() {
		return super.getTitulo();
	}

	@Override
	@JsonView(BrainwritingViews.BrainwritingDetalhes.class)
	public String getTipo() {
		return super.getTipo();
	}

	@JsonView(BrainwritingViews.BrainwritingDetalhes.class)
	public String getGatilho() {
		return gatilho;
	}

	public void setGatilho(String gatilho) {
		this.gatilho = gatilho;
	}

	@JsonView({ BrainwritingViews.BrainwritingResumo.class, BrainwritingViews.BrainwritingDetalhes.class })
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@JsonView({ BrainwritingViews.BrainwritingResumo.class, BrainwritingViews.BrainwritingDetalhes.class })
	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Pessoa getFacilitador() {
		return facilitador;
	}

	public void setFacilitador(Pessoa facilitador) {
		this.facilitador = facilitador;
	}

	public List<Pessoa> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Pessoa> participantes) {
		this.participantes = participantes;
	}

	@JsonView(BrainwritingViews.BrainwritingResumo.class)
	public Integer numeroParticipantes() {
		return participantes != null ? participantes.size() : 0;
	}

	@JsonView(BrainwritingViews.BrainwritingDetalhes.class)
	public List<PessoaBrainwriting> participantes() {
		List<PessoaBrainwriting> aux = new ArrayList<>();

		for (Pessoa pessoa : participantes) {
			aux.add(new PessoaBrainwriting(pessoa));
		}

		return aux;
	}

	public void addParticipante(Pessoa pessoa) {
		if (this.participantes == null) {
			this.participantes = new ArrayList<>();
		}

		this.participantes.add(pessoa);
	}

	@JsonView(BrainwritingViews.BrainwritingResumo.class)
	public Integer numeroIdeias() {
		return ideias != null ? ideias.size() : 0;
	}

	@JsonView(BrainwritingViews.BrainwritingDetalhes.class)
	@Override
	public List<Ideia> getIdeias() {
		return super.getIdeias();
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
