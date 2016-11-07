package com.ufc.tecnicas.brainwriting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.tecnicas.brainwriting.model.Brainwriting;
import com.ufc.tecnicas.model.Pessoa;

public interface BrainwritingRepository extends JpaRepository<Brainwriting, Long> {
	
	List<Brainwriting> findDistinctByFacilitadorOrParticipantes(Pessoa facilitador, Pessoa participante);
}
