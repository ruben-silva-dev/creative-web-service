package com.ufc.tecnicas.brainwriting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.tecnicas.brainwriting.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
