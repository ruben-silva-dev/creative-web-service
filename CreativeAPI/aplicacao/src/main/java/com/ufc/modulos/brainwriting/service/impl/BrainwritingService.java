package com.ufc.modulos.brainwriting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.geral.model.Ideia;
import com.ufc.geral.model.Pessoa;
import com.ufc.modulos.brainwriting.model.Avaliacao;
import com.ufc.modulos.brainwriting.model.Brainwriting;
import com.ufc.modulos.brainwriting.model.Comentario;
import com.ufc.modulos.brainwriting.model.IdeiaBrainwriting;
import com.ufc.modulos.brainwriting.repository.AvaliacaoRepository;
import com.ufc.modulos.brainwriting.repository.BrainwritingRepository;
import com.ufc.modulos.brainwriting.repository.ComentarioRepository;
import com.ufc.modulos.brainwriting.repository.IdeiaRepository;
import com.ufc.modulos.brainwriting.service.IBrainwritingService;

@Service
public class BrainwritingService implements IBrainwritingService {

	@Autowired
	private BrainwritingRepository brainwritingRepository;

	@Autowired
	private IdeiaRepository ideiaRepository;

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

	@Autowired
	private ComentarioRepository comentarioRepository;

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
		ideia.setTecnica(brainwriting);
		ideiaRepository.save(ideia);
	}

	@Override
	public void vincularParticipante(Pessoa pessoa, Brainwriting brainwriting) {
		brainwriting.addParticipante(pessoa);
		brainwritingRepository.save(brainwriting);
	}

	@Override
	public void adicionarAvaliacao(IdeiaBrainwriting ideia, Avaliacao avaliacao) {
		avaliacao.setIdeia(ideia);
		avaliacaoRepository.save(avaliacao);
	}

	@Override
	public void adicionarComentario(IdeiaBrainwriting ideia, Comentario comentario) {
		comentario.setIdeia(ideia);
		comentarioRepository.save(comentario);
	}

	@Override
	public List<IdeiaBrainwriting> buscarIdeias(Brainwriting brainwriting) {
		List<IdeiaBrainwriting> ideias = new ArrayList<>();

		for (Ideia ideia : brainwriting.getIdeias()) {
			ideias.add((IdeiaBrainwriting) ideia);
		}

		return ideias;
	}

	@Override
	public List<Brainwriting> buscarBrainwritingPorPessoa(Pessoa pessoa) {
		return brainwritingRepository.findDistinctByFacilitadorOrParticipantes(pessoa, pessoa);
	}
}
