package br.ufop.ufopativa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufop.ufopativa.models.OrientacaoConcluida;
import br.ufop.ufopativa.services.OrientacaoConcluidaService;

@RestController
@RequestMapping(value="/orientacoes-concluidas")
public class OrientacaoConcluidaResource {
	
	@Autowired
	private OrientacaoConcluidaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		OrientacaoConcluida obj = service.findOrientacao(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public List<OrientacaoConcluida> pessoas(){
		return service.getOrientacoes();
	}
}
