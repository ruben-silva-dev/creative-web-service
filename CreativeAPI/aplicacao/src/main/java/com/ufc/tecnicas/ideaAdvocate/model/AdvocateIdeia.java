package com.ufc.tecnicas.ideaAdvocate.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.tecnicas.model.Ideia;
import com.ufc.tecnicas.model.Pessoa;
import com.ufc.tecnicas.model.Tecnica;

@Entity
@Table(name = "advocate_ideia")
public class AdvocateIdeia extends Ideia {

	@ManyToOne
	private Pessoa autor;

	@OneToMany(mappedBy = "ideia")
	private List<Comentario> comentarios;

	@OneToMany(mappedBy = "ideia")
	private List<Avaliacao> votos;

	@Enumerated(EnumType.STRING)
	private Status status;

	@JsonView({ AdvocateViews.AdvocateDetalhes.class, AdvocateViews.IdeiaDetalhes.class })
	@Override
	public Long getId() {
		return super.getId();
	}

	@JsonView({ AdvocateViews.AdvocateDetalhes.class, AdvocateViews.IdeiaDetalhes.class })
	@Override
	public String getTitulo() {
		return super.getTitulo();
	}

	@JsonView({ AdvocateViews.AdvocateDetalhes.class, AdvocateViews.IdeiaDetalhes.class })
	@Override
	public String getTexto() {
		return super.getTexto();
	}

	@JsonView({ AdvocateViews.AdvocateDetalhes.class, AdvocateViews.IdeiaDetalhes.class })
	@Override
	public Calendar getData() {
		return super.getData();
	}

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
	
	@JsonView({ AdvocateViews.AdvocateDetalhes.class, AdvocateViews.IdeiaDetalhes.class })
	public PessoaAdvocate autor(){
		return new PessoaAdvocate(autor);
	}

	@JsonView(AdvocateViews.IdeiaDetalhes.class)
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@JsonView(AdvocateViews.AdvocateDetalhes.class)
	public Integer numeroComentarios() {
		return comentarios != null ? comentarios.size() : 0;
	}

	@JsonView(AdvocateViews.IdeiaDetalhes.class)
	public List<Avaliacao> getVotos() {
		return votos;
	}

	public void setVotos(List<Avaliacao> votos) {
		this.votos = votos;
	}

	@JsonView(AdvocateViews.AdvocateDetalhes.class)
	public Integer numeroVotos() {
		return votos != null ? votos.size() : 0;
	}

	@JsonView({ AdvocateViews.AdvocateDetalhes.class, AdvocateViews.IdeiaDetalhes.class })
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public enum Status {
		NAO_DISCUTIDO("Não discutido"), EM_DISCUSSAO("Em discussão"), REJEITADO("Rejeitado"), APROVADO("Aprovado");

		private String descricao;

		private Status(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}
	}
}
