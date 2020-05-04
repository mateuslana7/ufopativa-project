package br.ufop.ufopativa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufop.ufopativa.models.AtuacaoProfissional;
import br.ufop.ufopativa.services.AtuacaoProfissionalService;

@RestController
@RequestMapping(value="/atuacoes-profissionais")
public class AtuacaoProfissionalResource {
	
	@Autowired
	private AtuacaoProfissionalService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		AtuacaoProfissional obj = service.findAtuacaoProf(id);
		return ResponseEntity.ok().body(obj);
	}
	
}