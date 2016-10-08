package com.ufc.modulos.brainwriting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.modulos.brainwriting.model.Brainwriting;
import com.ufc.modulos.brainwriting.model.Ideia;
import com.ufc.modulos.brainwriting.repository.BrainwritingRepository;
import com.ufc.modulos.brainwriting.service.IBrainwritingService;

@Service
public class BrainwritingService implements IBrainwritingService {

	@Autowired
	private BrainwritingRepository brainwritingRepository;

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
	public void vincular(Brainwriting brainwriting, Ideia ideia) {
		brainwriting.addIdeia(ideia);
		brainwritingRepository.save(brainwriting);
	}

}
