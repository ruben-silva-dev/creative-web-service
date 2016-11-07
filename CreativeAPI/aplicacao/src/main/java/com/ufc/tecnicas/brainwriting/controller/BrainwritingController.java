package com.ufc.tecnicas.brainwriting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
import com.ufc.modulos.pessoas.IPessoaService;
import com.ufc.tecnicas.brainwriting.model.Avaliacao;
import com.ufc.tecnicas.brainwriting.model.Brainwriting;
import com.ufc.tecnicas.brainwriting.model.BrainwritingViews;
import com.ufc.tecnicas.brainwriting.model.Comentario;
import com.ufc.tecnicas.brainwriting.model.IdeiaBrainwriting;
import com.ufc.tecnicas.brainwriting.service.IBrainwritingService;
import com.ufc.tecnicas.model.Pessoa;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Módulo de brainwriting")
@RestController
@RequestMapping(value = "/brainwriting")
public class BrainwritingController {

	@Autowired
	private IBrainwritingService brainwritingService;

	@Autowired
	private IPessoaService pessoaService;

	@ApiOperation(value = "Retorna todos os brainwriting de uma pessoa", notes = "O método retorna tanto os brainwriting que uma pessoa modera quanto aqueles que ela participa.")
	@JsonView(BrainwritingViews.BrainwritingResumo.class)
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Brainwriting> getBrainwriting(@RequestParam("idPessoa") Pessoa pessoa) {
		return brainwritingService.buscarBrainwritingPorPessoa(pessoa);
	}

	@ApiOperation(value = "Retorna um brainwriting com base no seu id")
	@JsonView(BrainwritingViews.BrainwritingDetalhes.class)
	@GetMapping(value = "/{idBrainwriting}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Brainwriting getDiscussaoPorId(@PathVariable("idBrainwriting") Brainwriting brainwriting) {
		return brainwriting;
	}

	@ApiOperation(value = "Adiciona um novo brainwriting")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> adicionarBrainwriting(@RequestBody Brainwriting brainwriting) {
		brainwritingService.adicionar(brainwriting);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Atualiza as informações de um brainwriting existente")
	@PostMapping(value = "/{idBrainwriting}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> atualizarBrainwriting(@PathVariable Long idBrainwriting,
			@RequestBody Brainwriting brainwriting) {
		brainwritingService.alterar(idBrainwriting, brainwriting);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna todas as ideias de um brainwriting")
	@JsonView(BrainwritingViews.BrainwritingDetalhes.class)
	@GetMapping(value = "/{idBrainwriting}/ideia", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<IdeiaBrainwriting> getIdeias(@PathVariable("idBrainwriting") Brainwriting brainwriting) {
		return brainwritingService.buscarIdeias(brainwriting);
	}

	@ApiOperation(value = "Retorna uma ideia em específico")
	@JsonView(BrainwritingViews.IdeiaDetalhes.class)
	@GetMapping(value = "/ideia/{idIdeia}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public IdeiaBrainwriting getIdeia(@PathVariable("idIdeia") IdeiaBrainwriting ideia) {
		return ideia;
	}

	@ApiOperation(value = "Vincula uma ideia a um brainwriting")
	@PostMapping(value = "{idBrainwriting}/ideia", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> vincularNovaIdeia(@PathVariable("idBrainwriting") Brainwriting brainwriting,
			@RequestBody IdeiaBrainwriting ideia) {
		brainwritingService.vincularIdeia(brainwriting, ideia);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna todos os participantes de um brainwriting")
	@GetMapping(value = "{idBrainwriting}/participante", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Pessoa> getParticipantes(@PathVariable("idBrainwriting") Brainwriting brainwriting) {
		return pessoaService.buscarPessoas(brainwriting.getParticipantes());
	}

	@ApiOperation(value = "Vincula um participante a um brainwriting")
	@PostMapping(value = "{idBrainwriting}/participante", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> vincularParticipante(@RequestBody Pessoa pessoa,
			@PathVariable("idBrainwriting") Brainwriting brainwriting) {
		brainwritingService.vincularParticipante(pessoa, brainwriting);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Adiciona uma nova avaliação a uma idéia existente")
	@PostMapping(value = "ideia/{idIdeia}/avaliacao", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> adicionarAvaliacao(@PathVariable("idIdeia") IdeiaBrainwriting ideia,
			@RequestBody Avaliacao avaliacao) {
		brainwritingService.adicionarAvaliacao(ideia, avaliacao);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Adiciona um novo comentário a uma idéia existente")
	@PostMapping(value = "ideia/{idIdeia}/comentario", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public HttpEntity<?> adicionarComentario(@PathVariable("idIdeia") IdeiaBrainwriting ideia,
			@RequestBody Comentario comentario) {
		brainwritingService.adicionarComentario(ideia, comentario);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
