package com.ufc.modulos.brainwriting.controller;

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
import com.ufc.modulos.brainwriting.model.Avaliacao;
import com.ufc.modulos.brainwriting.model.Brainwriting;
import com.ufc.modulos.brainwriting.model.BrainwritingViews;
import com.ufc.modulos.brainwriting.model.Comentario;
import com.ufc.modulos.brainwriting.model.IdeiaBrainwriting;
import com.ufc.modulos.brainwriting.model.PessoaBrainwriting;
import com.ufc.modulos.brainwriting.repository.BrainwritingRepository;
import com.ufc.modulos.brainwriting.service.IBrainwritingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Módulo de brainwriting")
@RestController
@RequestMapping(value = "/brainwriting")
public class BrainwritingController {

	@Autowired
	private BrainwritingRepository brainwritingRepository;

	@Autowired
	private IBrainwritingService brainwritingService;

	@ApiOperation(value = "Retorna todos os brainwriting de uma pessoa", notes = "O método retorna tanto os brainwriting que uma pessoa modera quanto aqueles que ela participa.")
	@JsonView(BrainwritingViews.BrainwritingView.class)
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Brainwriting> getBrainwriting(@RequestParam("idPessoa") PessoaBrainwriting pessoa) {
		return brainwritingRepository.findByPessoa(pessoa);
	}

	@ApiOperation(value = "Retorna um brainwriting com base no seu id")
	@JsonView(BrainwritingViews.BrainwritingView.class)
	@GetMapping(value = "/{idBrainwriting}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Brainwriting getDiscussaoPorId(@PathVariable Long idBrainwriting) {
		return brainwritingRepository.findOne(idBrainwriting);
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
	@JsonView(BrainwritingViews.IdeiaBrainwritingView.class)
	@GetMapping(value = "/{idBrainwriting}/ideia", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<IdeiaBrainwriting> getIdeias(@PathVariable("idBrainwriting") Brainwriting brainwriting) {
		return brainwritingService.buscarIdeias(brainwriting);
	}

	@ApiOperation(value = "Retorna uma ideia em específico")
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
	@JsonView(BrainwritingViews.BrainwritingPessoaView.class)
	@GetMapping(value = "{idBrainwriting}/participante", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<PessoaBrainwriting> getParticipantes(@PathVariable("idBrainwriting") Brainwriting brainwriting) {
		return brainwriting.getParticipantes();
	}

	@ApiOperation(value = "Vincula um participante a um brainwriting")
	@PostMapping(value = "{idBrainwriting}/participante", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> vincularParticipante(@RequestBody PessoaBrainwriting pessoa,
			@PathVariable("idBrainwriting") Brainwriting brainwriting) {
		brainwritingService.vincularParticipante(pessoa, brainwriting);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna todas as avaliações de uma idéia")
	@JsonView(BrainwritingViews.AvaliacaoView.class)
	@GetMapping(value = "ideia/{idIdeia}/avaliacao", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Avaliacao> getAvaliacoes(@PathVariable("idIdeia") IdeiaBrainwriting ideia) {
		return ideia.getAvaliacoes();
	}

	@ApiOperation(value = "Adiciona uma nova avaliação a uma idéia existente")
	@PostMapping(value = "ideia/{idIdeia}/avaliacao", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> adicionarAvaliacao(@PathVariable("idIdeia") IdeiaBrainwriting ideia,
			@RequestBody Avaliacao avaliacao) {
		brainwritingService.adicionarAvaliacao(ideia, avaliacao);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna todos os comentários de uma idéia")
	@JsonView(BrainwritingViews.ComentarioView.class)
	@GetMapping(value = "ideia/{idIdeia}/comentario", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comentario> getComentarios(@PathVariable("idIdeia") IdeiaBrainwriting ideia) {
		return ideia.getComentarios();
	}

	@ApiOperation(value = "Adiciona um novo comentário a uma idéia existente")
	@PostMapping(value = "ideia/{idIdeia}/comentario", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public HttpEntity<?> adicionarComentario(@PathVariable("idIdeia") IdeiaBrainwriting ideia,
			@RequestBody Comentario comentario) {
		brainwritingService.adicionarComentario(ideia, comentario);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
