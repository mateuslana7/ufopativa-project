package br.ufop.ufopativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufop.ufopativa.models.FormacaoAcademica;
import br.ufop.ufopativa.repositories.FormacaoAcademicaRepository;
import br.ufop.ufopativa.services.exceptions.ObjectNotFoundException;

@Service
public class FormacaoAcademicaService {
	
	@Autowired
	private FormacaoAcademicaRepository rep;
	
	public FormacaoAcademica findDepto(Integer id) {
		Optional<FormacaoAcademica> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + FormacaoAcademica.class.getName()));
	}
	
	public List<FormacaoAcademica> getFormacoes(){
		return rep.findAll();
	}
	
}

