package br.ufop.ufopativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufop.ufopativa.models.Producao;
import br.ufop.ufopativa.repositories.ProducaoRepository;
import br.ufop.ufopativa.services.exceptions.ObjectNotFoundException;

@Service
public class ProducaoService {
	
	@Autowired
	private ProducaoRepository rep;
	
	public Producao findProducao(Integer id) {
		Optional<Producao> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Producao.class.getName()));
	}
	
	public List<Producao> getProducoes(){
		return rep.findAll();
	}

}
