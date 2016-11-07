package com.ufc.tecnicas.brainwriting.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.tecnicas.model.Pessoa;

public class PessoaBrainwriting {

	@JsonView({ BrainwritingViews.BrainwritingDetalhes.class, BrainwritingViews.IdeiaDetalhes.class })
	private Long id;

	@JsonView({ BrainwritingViews.BrainwritingDetalhes.class, BrainwritingViews.IdeiaDetalhes.class })
	private String nome;

	@JsonView({ BrainwritingViews.BrainwritingDetalhes.class, BrainwritingViews.IdeiaDetalhes.class })
	private String email;

	public PessoaBrainwriting(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

}
