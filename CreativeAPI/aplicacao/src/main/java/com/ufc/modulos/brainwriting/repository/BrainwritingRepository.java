package com.ufc.modulos.brainwriting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufc.modulos.brainwriting.model.Brainwriting;
import com.ufc.modulos.brainwriting.model.PessoaBrainwriting;

@Repository
public interface BrainwritingRepository extends JpaRepository<Brainwriting, Long> {

	@Query("SELECT b FROM Brainwriting b WHERE :pessoa MEMBER OF b.moderadores OR :pessoa MEMBER OF b.participantes")
	List<Brainwriting> findByPessoa(@Param("pessoa") PessoaBrainwriting pessoa);

}
