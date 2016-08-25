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
import com.ufc.model.Pessoa;
import com.ufc.repository.PessoaRepository;
import com.ufc.service.IPessoaService;

@RestController
@Transactional
@RequestMapping(value = "/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private IPessoaService pessoaService;

	@JsonView(View.Pessoa.class)
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Pessoa> getPessoas() {
		return pessoaRepository.findAll();
	}

	@JsonView(View.Pessoa.class)
	@RequestMapping(value = "/{idPessoa}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Pessoa getPessoaPorId(@PathVariable Long idPessoa) {
		return pessoaRepository.findOne(idPessoa);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> adicionarPessoa(@RequestBody Pessoa pessoa) {
		pessoaService.adicionar(pessoa);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{idPessoa}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> atualizarPessoa(@PathVariable Long idPessoa, @RequestBody Pessoa pessoa) {
		pessoaService.alterar(idPessoa, pessoa);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
