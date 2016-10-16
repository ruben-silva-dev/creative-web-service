package com.ufc.modulos.brainwriting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.modulos.brainwriting.model.IdeiaBrainwriting;

public interface IdeiaRepository extends JpaRepository<IdeiaBrainwriting, Long> {

}
