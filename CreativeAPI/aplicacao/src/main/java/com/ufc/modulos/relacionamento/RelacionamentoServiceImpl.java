package com.ufc.modulos.relacionamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.modulos.definicoes.Ideia;
import com.ufc.modulos.definicoes.Relacionamento;

@Service
public class RelacionamentoServiceImpl implements IRelacionamentoService {

	@Autowired
	private RelacionamentoRepository relacionamentoRepository;

	@Override
	public void criarRelacionamento(Relacionamento relacionamento) {
		relacionamentoRepository.save(relacionamento);
	}

	@Override
	public List<Relacionamento> getRelacionamentos(Ideia ideia) {
		return ideia.getRelacionamentos();
	}

}
