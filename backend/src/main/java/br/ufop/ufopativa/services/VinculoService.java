package br.ufop.ufopativa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufop.ufopativa.models.Vinculo;
import br.ufop.ufopativa.repositories.VinculoRepository;
import br.ufop.ufopativa.services.exceptions.ObjectNotFoundException;

@Service
public class VinculoService {
	
	@Autowired
	private VinculoRepository rep;
	
	public Vinculo findVinculo(Integer id) {
		Optional<Vinculo> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Vinculo.class.getName()));
	}

}
