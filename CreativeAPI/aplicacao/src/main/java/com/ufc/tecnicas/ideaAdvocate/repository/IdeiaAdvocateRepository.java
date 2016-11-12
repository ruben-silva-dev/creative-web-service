package com.ufc.tecnicas.ideaAdvocate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.tecnicas.ideaAdvocate.model.IdeiaAdvocate;
import com.ufc.tecnicas.model.Pessoa;

public interface IdeiaAdvocateRepository extends JpaRepository<IdeiaAdvocate, Long> {

	List<IdeiaAdvocate> findAllByModeradorOrParticipantes(Pessoa moderador, Pessoa participante);

}
