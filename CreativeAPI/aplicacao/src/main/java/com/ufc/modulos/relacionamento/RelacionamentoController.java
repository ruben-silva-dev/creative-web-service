package com.ufc.modulos.relacionamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.modulos.definicoes.GeneralViews;
import com.ufc.modulos.definicoes.Ideia;
import com.ufc.modulos.definicoes.Relacionamento;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Módulo de relacionamentos")
@RestController
@RequestMapping(value = "/relacionamentos")
public class RelacionamentoController {

	@Autowired
	private IRelacionamentoService relacionamentoService;

	@ApiOperation(value = "Retorna todos os relacionamentos de uma ideia", notes = "O método retorna um histórico das técnicas aplicadas a uma ideia.")
	@JsonView(GeneralViews.RelacionamentoView.class)
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Relacionamento> getRelacionamentos(@RequestParam("idIdeia") Ideia ideia) {
		return ideia.getRelacionamentos();
	}

	@ApiOperation(value = "Cria um relaciomento", notes = "Pode criar um relacionamento entre uma ou mais ideias independente da técnica.")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> criarRelacionamento(@RequestBody Relacionamento relacionamento) {
		relacionamentoService.criarRelacionamento(relacionamento);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
