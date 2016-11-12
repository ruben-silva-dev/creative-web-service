package com.ufc.tecnicas.brainwriting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.tecnicas.brainwriting.model.Avaliacao;
import com.ufc.tecnicas.brainwriting.model.Brainwriting;
import com.ufc.tecnicas.brainwriting.model.Comentario;
import com.ufc.tecnicas.brainwriting.model.BrainwritingIdeia;
import com.ufc.tecnicas.brainwriting.repository.BrainwritingAvaliacaoRepository;
import com.ufc.tecnicas.brainwriting.repository.BrainwritingRepository;
import com.ufc.tecnicas.brainwriting.repository.BrainwritingComentarioRepository;
import com.ufc.tecnicas.brainwriting.repository.BrainwritingIdeiaRepository;
import com.ufc.tecnicas.brainwriting.service.IBrainwritingService;
import com.ufc.tecnicas.model.Ideia;
import com.ufc.tecnicas.model.Pessoa;

@Service
public class BrainwritingService implements IBrainwritingService {

	@Autowired
	private BrainwritingRepository brainwritingRepository;

	@Autowired
	private BrainwritingIdeiaRepository ideiaRepository;

	@Autowired
	private BrainwritingAvaliacaoRepository avaliacaoRepository;

	@Autowired
	private BrainwritingComentarioRepository comentarioRepository;

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
	public void vincularIdeia(Brainwriting brainwriting, BrainwritingIdeia ideia) {
		ideia.setTecnica(brainwriting);
		ideiaRepository.save(ideia);
	}

	@Override
	public void vincularParticipante(Pessoa pessoa, Brainwriting brainwriting) {
		brainwriting.addParticipante(pessoa);
		brainwritingRepository.save(brainwriting);
	}

	@Override
	public void adicionarAvaliacao(BrainwritingIdeia ideia, Avaliacao avaliacao) {
		avaliacao.setIdeia(ideia);
		avaliacaoRepository.save(avaliacao);
	}

	@Override
	public void adicionarComentario(BrainwritingIdeia ideia, Comentario comentario) {
		comentario.setIdeia(ideia);
		comentarioRepository.save(comentario);
	}

	@Override
	public List<BrainwritingIdeia> buscarIdeias(Brainwriting brainwriting) {
		List<BrainwritingIdeia> ideias = new ArrayList<>();

		for (Ideia ideia : brainwriting.getIdeias()) {
			ideias.add((BrainwritingIdeia) ideia);
		}

		return ideias;
	}

	@Override
	public List<Brainwriting> buscarBrainwritingPorPessoa(Pessoa pessoa) {
		return brainwritingRepository.findDistinctByFacilitadorOrParticipantes(pessoa, pessoa);
	}
}
