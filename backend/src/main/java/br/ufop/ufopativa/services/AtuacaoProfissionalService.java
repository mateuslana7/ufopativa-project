package br.ufop.ufopativa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufop.ufopativa.models.AtuacaoProfissional;
import br.ufop.ufopativa.repositories.AtuacaoProfissionalRepository;
import br.ufop.ufopativa.services.exceptions.ObjectNotFoundException;

@Service
public class AtuacaoProfissionalService {
	@Autowired
	private AtuacaoProfissionalRepository rep;
	
	public AtuacaoProfissional findAtuacaoProf(Integer id) {
		Optional<AtuacaoProfissional> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + AtuacaoProfissional.class.getName()));
	}
}
