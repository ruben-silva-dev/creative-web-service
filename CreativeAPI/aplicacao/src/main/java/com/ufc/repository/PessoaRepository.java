package com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
