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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.json.View;
import com.ufc.model.Discussao;
import com.ufc.repository.DiscussaoRepository;
import com.ufc.service.IDiscussaoService;

@RestController
@Transactional
@RequestMapping(value = "/discussoes")
public class DiscussaoController {

	@Autowired
	private DiscussaoRepository discussaoRepository;

	@Autowired
	private IDiscussaoService discussaoService;

	@JsonView(View.Discussao.class)
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Discussao> getDiscussoes(@RequestParam Long idPessoa) {
		return discussaoRepository.findByPessoa(idPessoa);
	}

	@JsonView(View.Discussao.class)
	@RequestMapping(value = "/{idDiscussao}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Discussao getDiscussaoPorId(@PathVariable Long idDiscussao) {
		return discussaoRepository.findOne(idDiscussao);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> adicionarDiscussao(@RequestBody Discussao discussao) {
		discussaoService.adicionar(discussao);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{idDiscussao}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> atualizarDiscussao(@PathVariable Long idDiscussao, @RequestBody Discussao discussao) {
		discussaoService.alterar(idDiscussao, discussao);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
