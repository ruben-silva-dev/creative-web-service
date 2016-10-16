package com.ufc.modulos.pessoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.modulos.definicoes.Pessoa;

@Service
public class PessoaService implements IPessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public void adicionar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

	@Override
	public void alterar(Long idPessoa, Pessoa pessoa) {
		pessoa.setId(idPessoa);
		pessoaRepository.save(pessoa);
	}

}
