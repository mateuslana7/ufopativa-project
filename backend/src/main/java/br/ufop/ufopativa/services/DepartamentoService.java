package br.ufop.ufopativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufop.ufopativa.models.Departamento;
import br.ufop.ufopativa.repositories.DepartamentoRepository;
import br.ufop.ufopativa.services.exceptions.ObjectNotFoundException;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository rep;
	
	public Departamento findDepto(Integer id) {
		Optional<Departamento> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Departamento.class.getName()));
	}
	
	public List<Departamento> getDepartamentos(){
		return rep.findAll();
	}
}

