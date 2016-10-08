package com.ufc.modulos.brainwriting.service;

import com.ufc.modulos.brainwriting.model.Brainwriting;
import com.ufc.modulos.brainwriting.model.Ideia;

public interface IBrainwritingService {

	public void adicionar(Brainwriting brainwriting);

	public void alterar(Long idBrainwriting, Brainwriting brainwriting);

	public void vincular(Brainwriting brainwriting, Ideia ideia);
}
