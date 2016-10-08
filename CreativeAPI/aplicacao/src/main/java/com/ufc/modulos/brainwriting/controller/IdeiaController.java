package com.ufc.modulos.brainwriting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.modulos.brainwriting.model.Avaliacao;
import com.ufc.modulos.brainwriting.model.Comentario;
import com.ufc.modulos.brainwriting.model.Ideia;
import com.ufc.modulos.brainwriting.service.IIdeiaService;
import com.ufc.util.json.View;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Ideias de brainwriting")
@RestController
@RequestMapping(value = "/ideias/{idIdeia}")
public class IdeiaController {

	@Autowired
	private IIdeiaService ideiaService;

	@ApiOperation(value = "Retorna todas as avaliações de uma idéia")
	@JsonView(View.Avaliacao.class)
	@RequestMapping(value = "/avaliacoes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Avaliacao> getAvaliacoes(@PathVariable("idIdeia") Ideia ideia) {
		return ideia.getAvaliacoes();
	}

	@ApiOperation(value = "Adiciona uma nova avaliação a uma idéia existente")
	@RequestMapping(value = "avaliacoes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> adicionarAvaliacao(@PathVariable("idIdeia") Ideia ideia,
			@RequestBody Avaliacao avaliacao) {
		ideiaService.adicionarAvaliacao(ideia, avaliacao);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Retorna todos os comentários de uma idéia")
	@JsonView(View.Comentario.class)
	@RequestMapping(value = "/comentarios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comentario> getComentarios(@PathVariable("idIdeia") Ideia ideia) {
		return ideia.getComentarios();
	}

	@ApiOperation(value = "Adiciona um novo comentário a uma idéia existente")
	@RequestMapping(value = "/comentarios", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public HttpEntity<String> adicionarComentario(@PathVariable("idIdeia") Ideia ideia,
			@RequestBody Comentario comentario) {
		ideiaService.adicionarComentario(ideia, comentario);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
