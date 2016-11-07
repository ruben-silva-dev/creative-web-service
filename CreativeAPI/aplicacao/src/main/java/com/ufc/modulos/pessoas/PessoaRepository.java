package com.ufc.modulos.pessoas;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.tecnicas.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	Pessoa findById(Long id);
	
}
