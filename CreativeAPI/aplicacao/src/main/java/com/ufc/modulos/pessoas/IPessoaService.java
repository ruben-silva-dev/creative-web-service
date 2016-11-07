package com.ufc.modulos.pessoas;

import java.util.List;

import com.ufc.tecnicas.model.Pessoa;

public interface IPessoaService {

	public void adicionar(Pessoa pessoa);

	public void alterar(Long idPessoa, Pessoa pessoa);
	
	public List<Pessoa> buscarPessoas(List<Pessoa> pessoas);
}
