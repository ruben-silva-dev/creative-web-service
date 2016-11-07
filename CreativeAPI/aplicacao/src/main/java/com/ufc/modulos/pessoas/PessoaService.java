package com.ufc.modulos.pessoas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.tecnicas.model.Pessoa;

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

	@Override
	public List<Pessoa> buscarPessoas(List<Pessoa> pessoas) {
		List<Pessoa> aux = new ArrayList<>();
		
		for(Pessoa pessoa : pessoas){
			aux.add(pessoaRepository.findById(pessoa.getId()));
		}

		return aux;
	}

}
