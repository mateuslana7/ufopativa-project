package br.ufop.ufopativa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufop.ufopativa.models.ProjetoDePesquisa;
import br.ufop.ufopativa.services.ProjetoDePesquisaService;

@RestController
@RequestMapping(value="/projetos-de-pesquisa")
public class ProjetoDePesquisaResource {
	
	@Autowired
	private ProjetoDePesquisaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		ProjetoDePesquisa obj = service.findProj(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
