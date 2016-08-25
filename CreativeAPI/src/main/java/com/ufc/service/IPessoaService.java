package com.ufc.service;

import com.ufc.model.Pessoa;

public interface IPessoaService {

	public void adicionar(Pessoa pessoa);

	public void alterar(Long idPessoa, Pessoa pessoa);
}
