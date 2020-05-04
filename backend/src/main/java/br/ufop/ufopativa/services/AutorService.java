package br.ufop.ufopativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufop.ufopativa.models.Autor;
import br.ufop.ufopativa.repositories.AutorRepository;
import br.ufop.ufopativa.services.exceptions.ObjectNotFoundException;

@Service
public class AutorService {
	@Autowired
	private AutorRepository rep;
	
	public Autor findAutor(Integer id) {
		Optional<Autor> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Autor.class.getName()));
	}
	
	public List<Autor> getAutores(){
		return rep.findAll();
	}
}
