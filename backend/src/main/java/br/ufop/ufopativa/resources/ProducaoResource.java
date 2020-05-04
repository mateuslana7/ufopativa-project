package br.ufop.ufopativa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufop.ufopativa.models.Producao;
import br.ufop.ufopativa.services.ProducaoService;

@RestController
@RequestMapping(value="/producoes")
public class ProducaoResource {
	
	@Autowired
	private ProducaoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Producao obj = service.findProducao(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public List<Producao> unidades(){
		return service.getProducoes();
	}
	
//	@RequestMapping(method=RequestMethod.GET)
//	public ResponseEntity<?> findAll(){
//		List<Unidade> obj = service.getUnidades();
//		return ResponseEntity.ok().body(obj);
//	}
}
