package br.ufop.ufopativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufop.ufopativa.models.Area;
import br.ufop.ufopativa.repositories.AreaRepository;
import br.ufop.ufopativa.services.exceptions.ObjectNotFoundException;

@Service
public class AreaService {
	@Autowired
	private AreaRepository rep;
	
	public Area findArea(Integer id) {
		Optional<Area> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Area.class.getName()));
	}
	
	public List<Area> getAreas(){
		return rep.findAll();
	}
}
