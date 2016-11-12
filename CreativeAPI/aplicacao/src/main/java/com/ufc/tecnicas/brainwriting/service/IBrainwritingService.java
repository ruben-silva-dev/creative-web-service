package com.ufc.tecnicas.brainwriting.service;

import java.util.List;

import com.ufc.tecnicas.brainwriting.model.Avaliacao;
import com.ufc.tecnicas.brainwriting.model.Brainwriting;
import com.ufc.tecnicas.brainwriting.model.Comentario;
import com.ufc.tecnicas.brainwriting.model.BrainwritingIdeia;
import com.ufc.tecnicas.model.Pessoa;

public interface IBrainwritingService {

	void adicionar(Brainwriting brainwriting);

	void alterar(Long idBrainwriting, Brainwriting brainwriting);

	void vincularIdeia(Brainwriting brainwriting, BrainwritingIdeia ideia);

	List<BrainwritingIdeia> buscarIdeias(Brainwriting brainwriting);

	void vincularParticipante(Pessoa pessoa, Brainwriting brainwriting);

	public void adicionarAvaliacao(BrainwritingIdeia ideia, Avaliacao avaliacao);

	public void adicionarComentario(BrainwritingIdeia ideia, Comentario comentario);

	public List<Brainwriting> buscarBrainwritingPorPessoa(Pessoa pessoa);
}
