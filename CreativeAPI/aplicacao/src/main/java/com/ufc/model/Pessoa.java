package com.ufc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.json.View;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Pessoa {

	@ApiModelProperty(value = "")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(View.Pessoa.class)
	private Long id;

	@JsonView(View.Pessoa.class)
	private String nome;

	@JsonView(View.Pessoa.class)
	private String email;

	private String senha;

	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "moderador", cascade = CascadeType.MERGE)
	private List<Discussao> discussoes;

	@ApiModelProperty(hidden = true)
	@ManyToMany
	@JoinTable(name = "participacao", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "discussao_id"))
	private List<Discussao> participacoes;

	@ApiModelProperty(hidden = true)
	@ManyToMany
	@JoinTable(name = "autor", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "ideia_id"))
	private List<Ideia> ideias;

	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "autor")
	private List<Avaliacao> avaliacoes;

	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "autor")
	private List<Comentario> comentarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Discussao> getDiscussoes() {
		return discussoes;
	}

	public void setDiscussoes(List<Discussao> discussoes) {
		this.discussoes = discussoes;
	}

	public void addDiscussao(Discussao discussao) {
		if (this.discussoes == null) {
			this.discussoes = new ArrayList<>();
		}

		this.discussoes.add(discussao);
	}

	public List<Discussao> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Discussao> participacoes) {
		this.participacoes = participacoes;
	}

	public List<Ideia> getIdeias() {
		return ideias;
	}

	public void setIdeias(List<Ideia> ideias) {
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
