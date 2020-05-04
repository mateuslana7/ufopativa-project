package br.ufop.ufopativa.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.ufop.ufopativa.models.Pessoa;
import br.ufop.ufopativa.models.Producao;
import br.ufop.ufopativa.models.ProjetoDePesquisa;
import br.ufop.ufopativa.models.FormacaoAcademica;
import br.ufop.ufopativa.models.Servidor;
import br.ufop.ufopativa.services.PessoaService;
import br.ufop.ufopativa.utils.MappingToJson;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService service;
	
	private MappingToJson mapToJson = new MappingToJson();
	
//	@RequestMapping(value = "/pesquisa", method = RequestMethod.POST)
//	public ResponseEntity<?> pessoasByNome(@RequestParam String nome){
//		
//		
//		
//		return ResponseEntity.ok().body(pessoas);
//	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> find(@PathVariable Integer id) throws JsonProcessingException {
		
		Pessoa pessoa = service.findPessoa(id);
		
		ObjectNode pessoaJson = JsonNodeFactory.instance.objectNode();
		
		pessoaJson.put("id", pessoa.getId());
		if(pessoa.getDataAtualizacao() != null)	
			pessoaJson.put("dataAtualizacao", pessoa.getDataAtualizacao().getTime());
		pessoaJson.put("idLattes", pessoa.getIdLattes());
		pessoaJson.put("nomeCompleto", pessoa.getNomeCompleto());
		pessoaJson.put("linkLattes", pessoa.getLinkLattes());
		if(pessoa.getPossuiLattes() == null)
			pessoaJson.put("possuiLattes", "NAO");
		else
			pessoaJson.put("possuiLattes", pessoa.getPossuiLattes());
		pessoaJson.put("nomesCitacoes", pessoa.getNomesCitacoes());
		
		Servidor s = (Servidor) pessoa;
				
		pessoaJson.put("tipo", s.getTipo());
		pessoaJson.put("ppgs", s.getPpgs());
		
		ObjectNode deptoJson = JsonNodeFactory.instance.objectNode();
		ObjectNode unidJson = JsonNodeFactory.instance.objectNode();
		
		if(s.getDepartamento() != null) {
			deptoJson.put("id", s.getDepartamento().getId());
			deptoJson.put("nome", s.getDepartamento().getNome());
		}else {
			deptoJson = null;
		}
		
		if(s.getUnidade() != null) {
			unidJson.put("id", s.getUnidade().getId());
			unidJson.put("nome", s.getUnidade().getNome());
			unidJson.put("sigla", s.getUnidade().getSigla());
		}else {
			unidJson = null;
		}
		
//		deptoJson.put("unidade", unidJson);
		pessoaJson.put("departamento", deptoJson);
		pessoaJson.put("unidade", unidJson);
		
		return ResponseEntity.ok().body(pessoaJson);
	}

	@GetMapping
	public List<Pessoa> pessoas() {
		return service.getPessoas();
	}
	
	@GetMapping(value="/{id}/palavras-chaves")
	public ResponseEntity<?> palavrasChavesByIdPessoa(@PathVariable Integer id) {
		Pessoa obj = service.findPessoa(id);		
		return ResponseEntity.ok().body(obj.getPalavrasChaves());
	}
	
	@GetMapping(value="/{id}/areas")
	public ResponseEntity<?> areasByIdPessoa(@PathVariable Integer id) {
		Pessoa obj = service.findPessoa(id);		
		return ResponseEntity.ok().body(obj.getAreas());
	}
	
	@GetMapping(value = "/{id}/producoes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> producoesByIdPessoa(@PathVariable Integer id) throws JsonProcessingException {
		Map<String, List<ObjectNode>> producoesJson = new HashMap<>();
		
		service.findPessoa(id).getProducoes().forEach((Producao p) -> {
			
			String tipoProducao = p.getClass().getSimpleName();	
			ObjectNode node = JsonNodeFactory.instance.objectNode();
			
			node.put("ano", p.getAno());
			node.put("tituloPortugues", p.getTituloPortugues());
			producoesJson.computeIfAbsent(tipoProducao, (k) -> new ArrayList<>());
			producoesJson.get(tipoProducao).add(node);
		});
		 
		return ResponseEntity.ok().body(producoesJson);
	}
	
	@GetMapping(value = "/{id}/producoes-bib", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> producoesBibByIdPessoa(@PathVariable Integer id) throws JsonProcessingException {
		Pessoa pessoa = service.findPessoa(id);
		List<Producao> producoes = new ArrayList<>();
		List<ObjectNode> producoesJson = new ArrayList<>();
		
		producoes.addAll(pessoa.getProducoes());
		
		producoesJson = mapToJson.mappingProducoes(producoes);
		
		return ResponseEntity.ok().body(producoesJson);
	}
	
	@GetMapping(value="/{id}/projetos-pesq")
	public ResponseEntity<?> projetosDePesqByIdPessoa(@PathVariable Integer id) {
		
		List<ObjectNode> projetos = new ArrayList<>();
		
		service.findPessoa(id).getProjetosDePesquisa().forEach((ProjetoDePesquisa proj) -> {
			ObjectNode node = JsonNodeFactory.instance.objectNode();
			
			if(proj.getSituacao().equalsIgnoreCase("EM_ANDAMENTO")) {
				node.put("id", proj.getId());
				node.put("nome", proj.getNome());
				node.put("anoInicio", proj.getAnoInicio());
				projetos.add(node);
			}
		});
		
		return ResponseEntity.ok().body(projetos);
	}
	
	@GetMapping(value="/{id}/formacoes-acad")
	public ResponseEntity<?> formacoesAcadByIdPessoa(@PathVariable Integer id) {

		List<ObjectNode> formacoes = new ArrayList<>();
		
		service.findPessoa(id).getFormacoesAcademicas().forEach((FormacaoAcademica f) -> {
			if(f.getSituacao().equalsIgnoreCase("CONCLUIDO")) {
				ObjectNode formacao = JsonNodeFactory.instance.objectNode();
				
				formacao.put("id", f.getId());
				formacao.put("anoConclusao", f.getAnoConclusao());
				formacao.put("tipo", f.getTipo());
				formacao.put("curso", f.getCurso());
				formacao.put("instituicao", f.getInstituicao());
				formacoes.add(formacao);
			}
		});
		
		return ResponseEntity.ok().body(formacoes);
	}
	
	@GetMapping(value = "/{id}/orientacoes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> orientacoesByIdPessoa(@PathVariable Integer id) throws JsonProcessingException {
		
		Pessoa pessoa = service.findPessoa(id);
		Servidor servidor = (Servidor) pessoa;
		List<ObjectNode> orientacoes = new ArrayList<>();
		
		MappingToJson mapToJson = new MappingToJson();
		
		if(servidor.getOrientacoesConcluidas() != null)
			orientacoes = mapToJson.mappingOrientacoes(servidor.getOrientacoesConcluidas());
		
		return ResponseEntity.ok().body(orientacoes);
	}
	
}
