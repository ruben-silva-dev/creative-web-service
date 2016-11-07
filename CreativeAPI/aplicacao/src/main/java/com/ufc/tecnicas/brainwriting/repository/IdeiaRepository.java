package com.ufc.tecnicas.brainwriting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.tecnicas.brainwriting.model.IdeiaBrainwriting;

public interface IdeiaRepository extends JpaRepository<IdeiaBrainwriting, Long> {

}
