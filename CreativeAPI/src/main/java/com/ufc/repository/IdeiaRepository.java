package com.ufc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.model.Ideia;

public interface IdeiaRepository extends JpaRepository<Ideia, Long> {

	List<Ideia> findByDiscussao_id(Long id);

}
