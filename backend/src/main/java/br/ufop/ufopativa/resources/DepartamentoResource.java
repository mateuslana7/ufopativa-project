package br.ufop.ufopativa.resources;

import java.util.ArrayList;
import java.util.List;

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

import br.ufop.ufopativa.models.Departamento;
import br.ufop.ufopativa.models.OrientacaoConcluida;
import br.ufop.ufopativa.models.Producao;
import br.ufop.ufopativa.models.Servidor;
import br.ufop.ufopativa.services.DepartamentoService;
import br.ufop.ufopativa.utils.MappingToJson;

@RestController
@RequestMapping(value="/departamentos")
public class DepartamentoResource {
	
	@Autowired
	private DepartamentoService service;
	
	private MappingToJson mapToJson = new MappingToJson();
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> find(@PathVariable Integer id) throws JsonProcessingException {
		
		Departamento depto = service.findDepto(id);
		long count = 0;
		
		ObjectNode deptoJson = JsonNodeFactory.instance.objectNode();
		ObjectNode unidJson = JsonNodeFactory.instance.objectNode();
		
		deptoJson.put("id", depto.getId());
		deptoJson.put("nome", depto.getNome());
		
		for(Servidor serv: depto.getServidores())
		{
			if(serv.getPossuiLattes() != null)
				count++;
		}
		
		deptoJson.put("totalServComLattes", count);
		
		
		if(depto.getUnidade() != null) {
			unidJson.put("id", depto.getUnidade().getId());
			unidJson.put("nome", depto.getUnidade().getNome());
			unidJson.put("sigla", depto.getUnidade().getSigla());
		}
		else {
			unidJson = null;
		}
		
		deptoJson.put("unidade", unidJson);
		
		return ResponseEntity.ok().body(deptoJson);
	}
	
	@GetMapping(value="/{id}/servidores")
	public ResponseEntity<?> projetosDePesqByIdPessoa(@PathVariable Integer id) {
		Departamento obj = service.findDepto(id);
		
		List<ObjectNode> servidores = new ArrayList<>();
		
		obj.getServidores().forEach((Servidor s) -> {
			ObjectNode serv = JsonNodeFactory.instance.objectNode();
			serv.put("id", s.getId());
			serv.put("nomeCompleto", s.getNomeCompleto());
			servidores.add(serv);
		});
		
		return ResponseEntity.ok().body(servidores);
	}
	
	@GetMapping
	public ResponseEntity<?> departamentos() {
		List<Departamento> obj = service.getDepartamentos();
		
		List<ObjectNode> deptos = new ArrayList<>();
		
		obj.forEach((Departamento depto) -> {
			ObjectNode node = JsonNodeFactory.instance.objectNode();
			
			node.put("id", depto.getId());
			node.put("nome", depto.getNome());
			deptos.add(node);
		});		
		
		return ResponseEntity.ok().body(deptos);
	}
	
	@GetMapping(value = "/{id}/producoes-bib", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> producoesBibByIdDepto(@PathVariable Integer id) throws JsonProcessingException {
		
		List<Producao> producoes = new ArrayList<>();
		List<ObjectNode> producoesJson = new ArrayList<>();
		
		service.findDepto(id).getServidores().forEach((Servidor serv) -> {
			producoes.addAll(serv.getProducoes());
		});
		
		producoesJson = mapToJson.mappingProducoes(producoes);
		
		return ResponseEntity.ok().body(producoesJson);
	}
	
	@GetMapping(value = "/{id}/orientacoes-conc", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> orientacoesByIdDepto(@PathVariable Integer id) throws JsonProcessingException {
		
		List<OrientacaoConcluida> orientacoes = new ArrayList<>();
		List<ObjectNode> orientacoesJson = new ArrayList<>();
		
		service.findDepto(id).getServidores().forEach((Servidor serv) -> {
			orientacoes.addAll(serv.getOrientacoesConcluidas());
		});
		
		orientacoesJson = mapToJson.mappingOrientacoes(orientacoes);
		
		return ResponseEntity.ok().body(orientacoesJson);
	}
	
}
