package com.ufc.modulos.brainwriting.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.util.json.View;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Brainwriting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(View.Discussao.class)
	private Long id;

	@JsonView(View.Discussao.class)
	private String titulo;

	@JsonView(View.Discussao.class)
	private String gatilho;

	@JsonView(View.Discussao.class)
	private String descricao;

	@JsonView(View.Discussao.class)
	@Enumerated(EnumType.STRING)
	private Fase fase;

	@ManyToMany(mappedBy = "brainwriting")
	private List<PessoaBrainwriting> moderadores;

	@ApiModelProperty(hidden = true)
	@ManyToMany
	@JoinTable(name = "participacao", joinColumns = @JoinColumn(name = "brainwriting_id"), inverseJoinColumns = @JoinColumn(name = "pessoa_id"))
	private List<PessoaBrainwriting> participantes;

	@ApiModelProperty(hidden = true)
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "brainwriting_ideia", joinColumns = @JoinColumn(name = "brainwriting_id"), inverseJoinColumns = @JoinColumn(name = "ideia_id"))
	private List<Ideia> ideias;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGatilho() {
		return gatilho;
	}

	public void setGatilho(String gatilho) {
		this.gatilho = gatilho;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

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

	public void addModerador(PessoaBrainwriting moderador) {
		if (this.moderadores == null) {
			this.moderadores = new ArrayList<>();
		}

		this.moderadores.add(moderador);
	}

	public List<PessoaBrainwriting> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<PessoaBrainwriting> participantes) {
		this.participantes = participantes;
	}

	public List<Ideia> getIdeias() {
		return ideias;
	}

	public void setIdeias(List<Ideia> ideias) {
		this.ideias = ideias;
	}

	public void addIdeia(Ideia ideia) {
		if (this.ideias == null) {
			this.ideias = new ArrayList<>();
		}

		this.ideias.add(ideia);
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
		Brainwriting other = (Brainwriting) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
