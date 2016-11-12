package com.ufc.tecnicas.ideaAdvocate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.tecnicas.ideaAdvocate.model.Comentario;

public interface AdvocateComentarioRepository extends JpaRepository<Comentario, Long> {

}
