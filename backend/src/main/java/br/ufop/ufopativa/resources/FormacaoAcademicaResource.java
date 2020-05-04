package br.ufop.ufopativa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufop.ufopativa.models.FormacaoAcademica;
import br.ufop.ufopativa.services.FormacaoAcademicaService;

@RestController
@RequestMapping(value="/formacoes-academicas")
public class FormacaoAcademicaResource {
	
	@Autowired
	private FormacaoAcademicaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		FormacaoAcademica obj = service.findDepto(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public List<FormacaoAcademica> formacoesAcademicas(){
		return service.getFormacoes();
	}
	
}
