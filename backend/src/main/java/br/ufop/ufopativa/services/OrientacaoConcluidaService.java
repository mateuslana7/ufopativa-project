package br.ufop.ufopativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufop.ufopativa.models.OrientacaoConcluida;
import br.ufop.ufopativa.repositories.OrientacaoConcluidaRepository;
import br.ufop.ufopativa.services.exceptions.ObjectNotFoundException;

@Service
public class OrientacaoConcluidaService {
	
	@Autowired
	private OrientacaoConcluidaRepository rep;
	
	public OrientacaoConcluida findOrientacao(Integer id) {
		Optional<OrientacaoConcluida> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + OrientacaoConcluida.class.getName()));
	}
	
	public List<OrientacaoConcluida> getOrientacoes(){
		return rep.findAll();
	}
	
	public long orientacoesDout(Integer id) {
		return rep.countOrientacoesDout(id);	
	}
	
	public long orientacoesMest(Integer id) {
		return rep.countOrientacoesMest(id);
	}
	
	public long orientacoesPosDout(Integer id) {
		return rep.countOrientacoesPosDout(id);
	}
	
	public long outrasOrientacoes(Integer id) {
		return rep.countOutrasOrientacoes(id);
	}

}
