package br.ufop.ufopativa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufop.ufopativa.models.Area;
import br.ufop.ufopativa.services.AreaService;

@RestController
@RequestMapping(value="/areas")
public class AreaResource {
	
	@Autowired
	private AreaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Area obj = service.findArea(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public List<Area> unidades(){
		return service.getAreas();
	}
	
}