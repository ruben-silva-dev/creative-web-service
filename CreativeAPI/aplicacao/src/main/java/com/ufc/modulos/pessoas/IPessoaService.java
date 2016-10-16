package com.ufc.modulos.pessoas;

import com.ufc.modulos.definicoes.Pessoa;

public interface IPessoaService {

	public void adicionar(Pessoa pessoa);

	public void alterar(Long idPessoa, Pessoa pessoa);
}
