package com.ufc.modulos.brainwriting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.modulos.brainwriting.model.Avaliacao;
import com.ufc.modulos.brainwriting.model.Brainwriting;
import com.ufc.modulos.brainwriting.model.Comentario;
import com.ufc.modulos.brainwriting.model.IdeiaBrainwriting;
import com.ufc.modulos.brainwriting.model.PessoaBrainwriting;
import com.ufc.modulos.brainwriting.repository.BrainwritingRepository;
import com.ufc.modulos.brainwriting.repository.IdeiaRepository;
import com.ufc.modulos.brainwriting.service.IBrainwritingService;
import com.ufc.modulos.definicoes.Ideia;

@Service
public class BrainwritingService implements IBrainwritingService {

	@Autowired
	private BrainwritingRepository brainwritingRepository;

	@Autowired
	private IdeiaRepository ideiaRepository;

	@Override
	public void adicionar(Brainwriting brainwriting) {
		brainwritingRepository.save(brainwriting);
	}

	@Override
	public void alterar(Long idBrainwriting, Brainwriting brainwriting) {
		brainwriting.setId(idBrainwriting);
		brainwritingRepository.save(brainwriting);
	}

	@Override
	public void vincularIdeia(Brainwriting brainwriting, IdeiaBrainwriting ideia) {
		brainwriting.addIdeia(ideia);
		brainwritingRepository.save(brainwriting);
	}

	@Override
	public void vincularParticipante(PessoaBrainwriting pessoa, Brainwriting brainwriting) {
		brainwriting.addParticipante(pessoa);
		brainwritingRepository.save(brainwriting);
	}

	@Override
	public void adicionarAvaliacao(IdeiaBrainwriting ideia, Avaliacao avaliacao) {
		ideia.addAvaliacao(avaliacao);
		ideiaRepository.save(ideia);
	}

	@Override
	public void adicionarComentario(IdeiaBrainwriting ideia, Comentario comentario) {
		ideia.addComentario(comentario);
		ideiaRepository.save(ideia);
	}

	@Override
	public List<IdeiaBrainwriting> buscarIdeias(Brainwriting brainwriting) {
		List<IdeiaBrainwriting> ideias = new ArrayList<>();

		for (Ideia ideia : brainwriting.getIdeias()) {
			ideias.add((IdeiaBrainwriting) ideia);
		}

		return ideias;
	}
}
