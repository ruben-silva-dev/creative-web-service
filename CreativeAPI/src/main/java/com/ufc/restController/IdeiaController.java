package com.ufc.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.json.View;
import com.ufc.model.Discussao;
import com.ufc.model.Ideia;
import com.ufc.repository.IdeiaRepository;
import com.ufc.service.IIdeiaService;

@RestController
@Transactional
@RequestMapping(value = "/discussoes/{idDiscussao}")
public class IdeiaController {

	@Autowired
	private IdeiaRepository ideiaRepository;

	@Autowired
	private IIdeiaService ideiaService;

	@JsonView(View.Ideia.class)
	@RequestMapping(value = "/ideias", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Ideia> getIdeias(@PathVariable Long idDiscussao) {
		return ideiaRepository.findByDiscussao_id(idDiscussao);
	}

	@RequestMapping(value = "/ideias", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> adicionarIdeia(@PathVariable("idDiscussao") Discussao discussao, @RequestBody Ideia ideia) {
		ideiaService.adicionar(discussao, ideia);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
