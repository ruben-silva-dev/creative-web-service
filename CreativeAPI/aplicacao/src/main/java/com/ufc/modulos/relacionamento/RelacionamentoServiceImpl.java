//package com.ufc.modulos.relacionamento;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ufc.geral.model.Ideia;
//import com.ufc.geral.model.Relacionamento;
//
//@Service
//public class RelacionamentoServiceImpl implements IRelacionamentoService {
//
//	@Autowired
//	private RelacionamentoRepository relacionamentoRepository;
//
//	@Override
//	public void criarRelacionamento(Relacionamento relacionamento) {
//		relacionamento.getTecnicaRelacionada().setIdeias(relacionamento.getTecnicaRaiz().getIdeias());
//		
//		List<Ideia> ideias = new ArrayList<>();
//		for (Ideia ideia : relacionamento.getTecnicaRaiz().getIdeias()) {
//			Ideia auxiliar = ideia;
//			auxiliar.setId(null);
//			ideias.add(auxiliar);
//		}
//		
//		relacionamento.getTecnicaRelacionada().setIdeias(ideias);
//		
//		relacionamentoRepository.save(relacionamento);
//	}
//
//	@Override
//	public List<Relacionamento> getRelacionamentos(Ideia ideia) {
//		return ideia.getRelacionamentos();
//	}
//
//}
