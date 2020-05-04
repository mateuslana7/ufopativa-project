package br.ufop.ufopativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufop.ufopativa.models.Unidade;
import br.ufop.ufopativa.repositories.UnidadeRepository;
import br.ufop.ufopativa.services.exceptions.ObjectNotFoundException;

@Service
public class UnidadeService {
	
	@Autowired
	private UnidadeRepository rep;
	
	public Unidade findUnidade(Integer id) {
		Optional<Unidade> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Unidade.class.getName()));
	}
	
	public List<Unidade> getUnidades(){
		return rep.findAll();
	}

}
