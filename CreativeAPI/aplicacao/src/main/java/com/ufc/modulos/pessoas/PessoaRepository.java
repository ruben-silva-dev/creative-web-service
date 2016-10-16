package com.ufc.modulos.pessoas;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.modulos.definicoes.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
