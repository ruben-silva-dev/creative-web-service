package com.ufc.tecnicas.ideaAdvocate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.tecnicas.model.Ideia;
import com.ufc.tecnicas.model.Pessoa;
import com.ufc.tecnicas.model.Tecnica;

@Entity
@Table(name = "ideia_advocate")
public class IdeiaAdvocate extends Tecnica {

	private String gatilho;

	private String descricao;

	@ManyToMany
	@JoinTable(name = "advocate_participacao", joinColumns = @JoinColumn(name = "advocate_id"), inverseJoinColumns = @JoinColumn(name = "pessoa_id"))
	private List<Pessoa> participantes;

	@ManyToOne
	private Pessoa moderador;

	public IdeiaAdvocate() {
		super("ideiaAdvocate");
	}

	@JsonView({ AdvocateViews.AdvocateResumo.class, AdvocateViews.AdvocateDetalhes.class })
	@Override
	public Long getId() {
		return super.getId();
	}

	@JsonView({ AdvocateViews.AdvocateResumo.class, AdvocateViews.AdvocateDetalhes.class })
	@Override
	public String getTitulo() {
		return super.getTitulo();
	}

	@Override
	public String getTipo() {
		return super.getTipo();
	}

	@JsonView(AdvocateViews.AdvocateDetalhes.class)
	@Override
	public List<Ideia> getIdeias() {
		return super.getIdeias();
	}

	@JsonView(AdvocateViews.AdvocateResumo.class)
	public Integer numeroIdeias() {
		return super.ideias != null ? super.getIdeias().size() : 0;
	}

	@JsonView({ AdvocateViews.AdvocateResumo.class, AdvocateViews.AdvocateDetalhes.class })
	public String getGatilho() {
		return gatilho;
	}

	public void setGatilho(String gatilho) {
		this.gatilho = gatilho;
	}

	@JsonView({ AdvocateViews.AdvocateResumo.class, AdvocateViews.AdvocateDetalhes.class })
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Pessoa> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Pessoa> participantes) {
		this.participantes = participantes;
	}

	@JsonView(AdvocateViews.AdvocateDetalhes.class)
	public List<PessoaAdvocate> participantes() {
		List<PessoaAdvocate> aux = new ArrayList<>();

		for (Pessoa pessoa : participantes) {
			aux.add(new PessoaAdvocate(pessoa));
		}

		return aux;
	}

	@JsonView(AdvocateViews.AdvocateResumo.class)
	public Integer numeroParticipantes() {
		return participantes != null ? participantes.size() : 0;
	}

	public void addParticipante(Pessoa participante) {
		if (this.participantes == null) {
			this.participantes = new ArrayList<>();
		}

		this.participantes.add(participante);
	}

	public Pessoa getModerador() {
		return moderador;
	}

	public void setModerador(Pessoa moderador) {
		this.moderador = moderador;
	}

	@JsonView({ AdvocateViews.AdvocateResumo.class, AdvocateViews.AdvocateDetalhes.class })
	public PessoaAdvocate moderador() {
		return new PessoaAdvocate(moderador);
	}
}
