package com.ufc.modulos.brainwriting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.modulos.brainwriting.model.Avaliacao;
import com.ufc.modulos.brainwriting.model.Comentario;
import com.ufc.modulos.brainwriting.model.Ideia;
import com.ufc.modulos.brainwriting.repository.IdeiaRepository;
import com.ufc.modulos.brainwriting.service.IIdeiaService;

@Service
public class IdeiaService implements IIdeiaService {

	@Autowired
	private IdeiaRepository ideiaRepository;

	@Override
	public void adicionarAvaliacao(Ideia ideia, Avaliacao avaliacao) {
		ideia.addAvaliacao(avaliacao);
		ideiaRepository.save(ideia);
	}

	@Override
	public void adicionarComentario(Ideia ideia, Comentario comentario) {
		ideia.addComentario(comentario);
		ideiaRepository.save(ideia);
	}

}
