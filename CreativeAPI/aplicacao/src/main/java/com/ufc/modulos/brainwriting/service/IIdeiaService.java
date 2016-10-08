package com.ufc.modulos.brainwriting.service;

import com.ufc.modulos.brainwriting.model.Avaliacao;
import com.ufc.modulos.brainwriting.model.Comentario;
import com.ufc.modulos.brainwriting.model.Ideia;

public interface IIdeiaService {

	public void adicionarAvaliacao(Ideia ideia, Avaliacao avaliacao);

	public void adicionarComentario(Ideia ideia, Comentario comentario);

}
