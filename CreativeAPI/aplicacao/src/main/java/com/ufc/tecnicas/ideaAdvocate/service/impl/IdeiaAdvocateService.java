package com.ufc.tecnicas.ideaAdvocate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.tecnicas.ideaAdvocate.model.AdvocateIdeia;
import com.ufc.tecnicas.ideaAdvocate.model.Avaliacao;
import com.ufc.tecnicas.ideaAdvocate.model.Comentario;
import com.ufc.tecnicas.ideaAdvocate.model.IdeiaAdvocate;
import com.ufc.tecnicas.ideaAdvocate.repository.AdvocateAvaliacaoRepository;
import com.ufc.tecnicas.ideaAdvocate.repository.AdvocateComentarioRepository;
import com.ufc.tecnicas.ideaAdvocate.repository.AdvocateIdeiaRepository;
import com.ufc.tecnicas.ideaAdvocate.repository.IdeiaAdvocateRepository;
import com.ufc.tecnicas.ideaAdvocate.service.IIdeiaAdvocateService;
import com.ufc.tecnicas.model.Pessoa;

@Service
public class IdeiaAdvocateService implements IIdeiaAdvocateService {

	@Autowired
	private IdeiaAdvocateRepository advocateRepository;

	@Autowired
	private AdvocateIdeiaRepository ideiaRepository;

	@Autowired
	private AdvocateAvaliacaoRepository avaliacaoRepository;

	@Autowired
	private AdvocateComentarioRepository comentarioRepository;

	@Override
	public void criarAdvocate(IdeiaAdvocate advocate) {
		advocateRepository.save(advocate);
	}

	@Override
	public List<IdeiaAdvocate> buscarAdvocatesPorPessoa(Pessoa pessoa) {
		return advocateRepository.findAllByModeradorOrParticipantes(pessoa, pessoa);
	}

	@Override
	public void adicionarParticipante(Pessoa pessoa, IdeiaAdvocate advocate) {
		advocate.addParticipante(pessoa);
		advocateRepository.save(advocate);
	}

	@Override
	public void adicionarIdeia(AdvocateIdeia ideia, IdeiaAdvocate advocate) {
		ideia.setTecnica(advocate);
		ideiaRepository.save(ideia);
	}

	@Override
	public void adicionarComentario(Comentario comentario, AdvocateIdeia ideia) {
		comentario.setIdeia(ideia);
		comentarioRepository.save(comentario);
	}

	@Override
	public void adicionarAvaliacao(Avaliacao avaliacao, AdvocateIdeia ideia) {
		avaliacao.setIdeia(ideia);
		avaliacaoRepository.save(avaliacao);
	}
}
