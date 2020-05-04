package br.ufop.ufopativa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufop.ufopativa.models.OrientacaoConcluida;
import br.ufop.ufopativa.models.Producao;
import br.ufop.ufopativa.models.Unidade;
import br.ufop.ufopativa.repositories.DepartamentoRepository;
import br.ufop.ufopativa.repositories.OrientacaoConcluidaRepository;
import br.ufop.ufopativa.repositories.PessoaRepository;
import br.ufop.ufopativa.repositories.ProducaoRepository;
import br.ufop.ufopativa.repositories.UnidadeRepository;

@Service
public class DadosRelevantesService {
	
	@Autowired
	private PessoaRepository pessoaRep;
	@Autowired
	private UnidadeRepository unidRep;
	@Autowired
	private DepartamentoRepository deptoRep;
	@Autowired
	private ProducaoRepository prodRep;
	@Autowired
	private OrientacaoConcluidaRepository orientRep;
	
	
	public long countPessoas() {
		return pessoaRep.count();
	}
	
	public long countUnidades() {
		return unidRep.count();
	}
	
	public long countDeptos() {
		return deptoRep.count();
	}
	
	public long countServComLattes() {
		return pessoaRep.countServidoresComLattes();
	}
	
	public List<Unidade> getUnidades(){
		return unidRep.findAll();
	}
	
	public List<Producao> getProducoes(){
		return prodRep.findAll();
	}
	
	public List<OrientacaoConcluida> getOrientacoesConcluidas(){
		return orientRep.findAll();
	}

}
