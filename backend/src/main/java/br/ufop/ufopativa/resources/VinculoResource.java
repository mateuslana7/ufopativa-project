package br.ufop.ufopativa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufop.ufopativa.models.Vinculo;
import br.ufop.ufopativa.services.VinculoService;

@RestController
@RequestMapping(value="/vinculos")
public class VinculoResource {
	
	@Autowired
	private VinculoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Vinculo obj = service.findVinculo(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
