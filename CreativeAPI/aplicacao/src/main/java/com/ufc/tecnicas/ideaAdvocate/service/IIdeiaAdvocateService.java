package com.ufc.tecnicas.ideaAdvocate.service;

import java.util.List;

import com.ufc.tecnicas.ideaAdvocate.model.AdvocateIdeia;
import com.ufc.tecnicas.ideaAdvocate.model.Avaliacao;
import com.ufc.tecnicas.ideaAdvocate.model.Comentario;
import com.ufc.tecnicas.ideaAdvocate.model.IdeiaAdvocate;
import com.ufc.tecnicas.model.Pessoa;

public interface IIdeiaAdvocateService {

	void criarAdvocate(IdeiaAdvocate advocate);

	List<IdeiaAdvocate> buscarAdvocatesPorPessoa(Pessoa pessoa);

	void adicionarParticipante(Pessoa pessoa, IdeiaAdvocate advocate);

	void adicionarIdeia(AdvocateIdeia ideia, IdeiaAdvocate advocate);

	void adicionarComentario(Comentario comentario, AdvocateIdeia ideia);

	void adicionarAvaliacao(Avaliacao avaliacao, AdvocateIdeia ideia);
}
