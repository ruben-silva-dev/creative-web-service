package com.ufc.modulos.relacionamento;

import java.util.List;

import com.ufc.modulos.definicoes.Ideia;
import com.ufc.modulos.definicoes.Relacionamento;

public interface IRelacionamentoService {

	void criarRelacionamento(Relacionamento relacionamento);

	List<Relacionamento> getRelacionamentos(Ideia ideia);

}
