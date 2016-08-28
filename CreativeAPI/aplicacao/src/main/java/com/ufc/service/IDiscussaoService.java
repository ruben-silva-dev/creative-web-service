package com.ufc.service;

import com.ufc.model.Discussao;

public interface IDiscussaoService {

	public void adicionar(Discussao discussao);

	public void alterar(Long idDiscussao, Discussao discussao);

}
