package br.ufop.ufopativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufop.ufopativa.models.Pessoa;
import br.ufop.ufopativa.repositories.PessoaRepository;
import br.ufop.ufopativa.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository rep;
	
//	public List<Pessoa> findPessoaByNome(String nome) {
//		return rep.findPessoaByNome(nome);
//	}
	
	public Pessoa findPessoa(Integer id) {
		Optional<Pessoa> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
	}
	
	public List<Pessoa> getPessoas(){
		return rep.findAll();
	}

}
