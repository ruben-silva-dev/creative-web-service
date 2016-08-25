package com.ufc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.model.Discussao;
import com.ufc.repository.DiscussaoRepository;
import com.ufc.service.IDiscussaoService;

@Service
public class DiscussaoService implements IDiscussaoService {

	@Autowired
	private DiscussaoRepository discussaoRepository;

	@Override
	public void adicionar(Discussao discussao) {
		discussaoRepository.save(discussao);
	}

	@Override
	public void alterar(Long idDiscussao, Discussao discussao) {
		discussao.setId(idDiscussao);
		discussaoRepository.save(discussao);
	}

}
