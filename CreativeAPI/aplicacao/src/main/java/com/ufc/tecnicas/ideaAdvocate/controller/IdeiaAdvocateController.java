package com.ufc.tecnicas.ideaAdvocate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.tecnicas.ideaAdvocate.model.AdvocateIdeia;
import com.ufc.tecnicas.ideaAdvocate.model.AdvocateViews;
import com.ufc.tecnicas.ideaAdvocate.model.Avaliacao;
import com.ufc.tecnicas.ideaAdvocate.model.Comentario;
import com.ufc.tecnicas.ideaAdvocate.model.IdeiaAdvocate;
import com.ufc.tecnicas.ideaAdvocate.service.IIdeiaAdvocateService;
import com.ufc.tecnicas.model.Pessoa;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/advocate")
@Api(tags = "Módulo de Ideia Advocate")
public class IdeiaAdvocateController {

	@Autowired
	private IIdeiaAdvocateService advocateService;

	@ApiOperation(value = "Criar um Ideia Advocate")
	@JsonView(AdvocateViews.AdvocateResumo.class)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<IdeiaAdvocate> criarAdvocate(@RequestBody IdeiaAdvocate advocate) {
		advocateService.criarAdvocate(advocate);
		return new ResponseEntity<IdeiaAdvocate>(advocate, HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar todos os Ideia Advocate de uma pessoa", notes = "O método retorna tanto os Ideia Advocate que a pessoa modera bem como os que ela participa")
	@JsonView(AdvocateViews.AdvocateResumo.class)
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<IdeiaAdvocate>> buscarAdvocates(@RequestParam("idPessoa") Pessoa pessoa) {
		return new ResponseEntity<List<IdeiaAdvocate>>(advocateService.buscarAdvocatesPorPessoa(pessoa), HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar um Ideia Advocate")
	@JsonView(AdvocateViews.AdvocateDetalhes.class)
	@GetMapping(value = "/{idAdvocate}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<IdeiaAdvocate> buscarAdvocate(@PathVariable("idAdvocate") IdeiaAdvocate advocate) {
		return new ResponseEntity<IdeiaAdvocate>(advocate, HttpStatus.OK);
	}

	@ApiOperation(value = "Adicionar participante em um Ideia Advocate")
	@JsonView(AdvocateViews.AdvocateResumo.class)
	@PostMapping(value = "/{idAdvocate}/participante", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<IdeiaAdvocate> adicionarParticipante(@RequestBody Pessoa pessoa,
			@PathVariable("idAdvocate") IdeiaAdvocate advocate) {
		advocateService.adicionarParticipante(pessoa, advocate);
		return new ResponseEntity<IdeiaAdvocate>(advocate, HttpStatus.OK);
	}

	@ApiOperation(value = "Adicionar ideia em um Ideia Advocate")
	@JsonView(AdvocateViews.AdvocateDetalhes.class)
	@PostMapping(value = "/{idAdvocate}/ideia", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AdvocateIdeia> adicionarIdeia(@PathVariable("idAdvocate") IdeiaAdvocate advocate,
			@RequestBody AdvocateIdeia ideia) {
		advocateService.adicionarIdeia(ideia, advocate);
		return new ResponseEntity<AdvocateIdeia>(ideia, HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar uma ideia")
	@JsonView(AdvocateViews.IdeiaDetalhes.class)
	@GetMapping(value = "/ideia/{idIdeia}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AdvocateIdeia> buscarIdeia(@PathVariable("idIdeia") AdvocateIdeia ideia) {
		return new ResponseEntity<AdvocateIdeia>(ideia, HttpStatus.OK);
	}

	@ApiOperation(value = "Adicionar avaliação em uma ideia")
	@JsonView(AdvocateViews.IdeiaDetalhes.class)
	@PostMapping(value = "/ideia/{idIdeia}/avaliacao", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Avaliacao> adicionarAvaliacao(@RequestBody Avaliacao avaliacao,
			@PathVariable("idIdeia") AdvocateIdeia ideia) {
		advocateService.adicionarAvaliacao(avaliacao, ideia);
		return new ResponseEntity<Avaliacao>(avaliacao, HttpStatus.OK);
	}

	@ApiOperation(value = "Adicionar comentário em uma ideia")
	@JsonView(AdvocateViews.IdeiaDetalhes.class)
	@PostMapping(value = "/ideia/{idIdeia}/comentario", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Comentario> adicionarComentario(@RequestBody Comentario comentario,
			@PathVariable("idIdeia") AdvocateIdeia ideia) {
		advocateService.adicionarComentario(comentario, ideia);
		return new ResponseEntity<Comentario>(comentario, HttpStatus.OK);
	}

}
