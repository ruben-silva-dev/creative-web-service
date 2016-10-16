package com.ufc.modulos.relacionamento;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.modulos.definicoes.Relacionamento;

public interface RelacionamentoRepository extends JpaRepository<Relacionamento, Integer> {

}
