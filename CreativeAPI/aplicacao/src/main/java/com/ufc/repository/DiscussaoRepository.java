package com.ufc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufc.model.Discussao;

@Repository
public interface DiscussaoRepository extends JpaRepository<Discussao, Long> {

	@Query("SELECT d FROM Discussao d WHERE d.moderador.id = :id OR :id MEMBER OF d.participantes")
	List<Discussao> findByPessoa(@Param("id") Long id);
	
}
