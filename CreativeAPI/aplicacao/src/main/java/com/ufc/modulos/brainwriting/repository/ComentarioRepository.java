package com.ufc.modulos.brainwriting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.modulos.brainwriting.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
