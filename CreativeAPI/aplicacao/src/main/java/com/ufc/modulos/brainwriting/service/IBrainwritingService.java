package com.ufc.modulos.brainwriting.service;

import java.util.List;

import com.ufc.geral.model.Pessoa;
import com.ufc.modulos.brainwriting.model.Avaliacao;
import com.ufc.modulos.brainwriting.model.Brainwriting;
import com.ufc.modulos.brainwriting.model.Comentario;
import com.ufc.modulos.brainwriting.model.IdeiaBrainwriting;

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
