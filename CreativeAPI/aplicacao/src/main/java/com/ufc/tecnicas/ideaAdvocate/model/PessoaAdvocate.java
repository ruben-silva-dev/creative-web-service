package com.ufc.tecnicas.ideaAdvocate.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.tecnicas.model.Pessoa;

public class PessoaAdvocate {
	private Long id;

	private String nome;

	private String email;

	public PessoaAdvocate(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
	}

	@JsonView({AdvocateViews.AdvocateResumo.class, AdvocateViews.AdvocateDetalhes.class, AdvocateViews.IdeiaDetalhes.class})
	public Long getId() {
		return id;
	}

	@JsonView({AdvocateViews.AdvocateResumo.class, AdvocateViews.AdvocateDetalhes.class, AdvocateViews.IdeiaDetalhes.class})
	public String getNome() {
		return nome;
	}

	@JsonView({AdvocateViews.AdvocateResumo.class, AdvocateViews.AdvocateDetalhes.class, AdvocateViews.IdeiaDetalhes.class})
	public String getEmail() {
		return email;
	}
}
