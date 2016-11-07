package com.ufc.tecnicas.brainwriting.service;

import java.util.List;

import com.ufc.tecnicas.brainwriting.model.Avaliacao;
import com.ufc.tecnicas.brainwriting.model.Brainwriting;
import com.ufc.tecnicas.brainwriting.model.Comentario;
import com.ufc.tecnicas.brainwriting.model.IdeiaBrainwriting;
import com.ufc.tecnicas.model.Pessoa;

public interface IBrainwritingService {

	void adicionar(Brainwriting brainwriting);

	void alterar(Long idBrainwriting, Brainwriting brainwriting);

	void vincularIdeia(Brainwriting brainwriting, IdeiaBrainwriting ideia);

	List<IdeiaBrainwriting> buscarIdeias(Brainwriting brainwriting);

	void vincularParticipante(Pessoa pessoa, Brainwriting brainwriting);

	public void adicionarAvaliacao(IdeiaBrainwriting ideia, Avaliacao avaliacao);

	public void adicionarComentario(IdeiaBrainwriting ideia, Comentario comentario);

	public List<Brainwriting> buscarBrainwritingPorPessoa(Pessoa pessoa);
}
