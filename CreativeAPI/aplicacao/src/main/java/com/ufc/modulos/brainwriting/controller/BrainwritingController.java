package com.ufc.modulos.brainwriting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.modulos.brainwriting.model.Brainwriting;
import com.ufc.modulos.brainwriting.model.Ideia;
import com.ufc.modulos.brainwriting.model.PessoaBrainwriting;
import com.ufc.modulos.brainwriting.repository.BrainwritingRepository;
import com.ufc.modulos.brainwriting.service.IBrainwritingService;
import com.ufc.util.json.View;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Técnica de brainwriting")
@RestController
@RequestMapping(value = "/brainwriting")
public class BrainwritingController {

	@Autowired
	private BrainwritingRepository brainwritingRepository;

	@Autowired
	private IBrainwritingService brainwritingService;

	@ApiOperation(value = "Retorna todos os brainwriting de uma pessoa", notes = "O método retorna tanto os brainwriting que uma pessoa modera quanto aqueles que ela participa.")
	@JsonView(View.Discussao.class)
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Brainwriting> getBrainwriting(@RequestParam("idPessoa") PessoaBrainwriting pessoa) {
		return brainwritingRepository.findByPessoa(pessoa);
	}

	@ApiOperation(value = "Retorna um brainwriting com base no seu id")
	@JsonView(View.Discussao.class)
	@RequestMapping(value = "/{idBrainwriting}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Brainwriting getDiscussaoPorId(@PathVariable Long idBrainwriting) {
		return brainwritingRepository.findOne(idBrainwriting);
	}

	@ApiOperation(value = "Adiciona um novo brainwriting")
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> adicionarBrainwriting(@RequestBody Brainwriting brainwriting) {
		brainwritingService.adicionar(brainwriting);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Atualiza as informações de um brainwriting existente")
	@RequestMapping(value = "/{idBrainwriting}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> atualizarBrainwriting(@PathVariable Long idBrainwriting,
			@RequestBody Brainwriting brainwriting) {
		brainwritingService.alterar(idBrainwriting, brainwriting);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Retorna todas as ideias de um brainwriting")
	@JsonView(View.Ideia.class)
	@RequestMapping(value = "/{idBrainwriting}/ideias", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Ideia> getIdeias(@PathVariable("idBrainwriting") Brainwriting brainwriting) {
		return brainwriting.getIdeias();
	}

	@ApiOperation(value = "Vincula uma ideia existente a um brainwriting")
	@RequestMapping(value = "{idBrainwriting}/ideias/{idIdeia}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> vincularIdeiaExistente(@PathVariable("idBrainwriting") Brainwriting brainwriting,
			@PathVariable("idIdeia") Ideia ideia) {
		brainwritingService.vincular(brainwriting, ideia);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Vincula uma nova ideia a um brainwriting", notes = "A ideia é primeiro salva e depois vinculada ao brainwriting.")
	@RequestMapping(value = "{idBrainwriting}/ideias", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> vincularNovaIdeia(@PathVariable("idBrainwriting") Brainwriting brainwriting,
			@RequestBody Ideia ideia) {
		brainwritingService.vincular(brainwriting, ideia);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Retorna todos os participantes de um brainwriting")
	@JsonView(View.Pessoa.class)
	@RequestMapping(value = "{idBrainwriting}/participantes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<PessoaBrainwriting> getParticipantes(@PathVariable("idBrainwriting") Brainwriting brainwriting) {
		return brainwriting.getParticipantes();
	}
}
