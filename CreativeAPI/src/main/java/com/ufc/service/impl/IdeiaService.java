package com.ufc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.model.Discussao;
import com.ufc.model.Ideia;
import com.ufc.repository.IdeiaRepository;
import com.ufc.service.IIdeiaService;

@Service
public class IdeiaService implements IIdeiaService {

	@Autowired
	private IdeiaRepository ideiaRepository;

	@Override
	public void adicionar(Discussao discussao, Ideia ideia) {
		ideia.setDiscussao(discussao);
		ideiaRepository.save(ideia);
	}

}
