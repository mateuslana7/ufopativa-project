package br.ufop.ufopativa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufop.ufopativa.models.ProjetoDePesquisa;
import br.ufop.ufopativa.repositories.ProjetoDePesquisaRepository;
import br.ufop.ufopativa.services.exceptions.ObjectNotFoundException;

@Service
public class ProjetoDePesquisaService {
	
	@Autowired
	private ProjetoDePesquisaRepository rep;
	
	public ProjetoDePesquisa findProj(Integer id) {
		Optional<ProjetoDePesquisa> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + ProjetoDePesquisa.class.getName()));
	}

}
