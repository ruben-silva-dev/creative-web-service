package com.ufc.modulos.brainwriting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.geral.model.Pessoa;
import com.ufc.modulos.brainwriting.model.Brainwriting;

public interface BrainwritingRepository extends JpaRepository<Brainwriting, Long> {
	
	List<Brainwriting> findDistinctByFacilitadorOrParticipantes(Pessoa facilitador, Pessoa participante);
}
