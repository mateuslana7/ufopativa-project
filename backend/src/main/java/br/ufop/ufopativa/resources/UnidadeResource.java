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

import br.ufop.ufopativa.models.Unidade;
import br.ufop.ufopativa.models.Departamento;
import br.ufop.ufopativa.models.OrientacaoConcluida;
import br.ufop.ufopativa.models.Servidor;
import br.ufop.ufopativa.models.Producao;
import br.ufop.ufopativa.services.UnidadeService;
import br.ufop.ufopativa.utils.MappingToJson;

@RestController
@RequestMapping(value="/unidades")
public class UnidadeResource {
	
	@Autowired
	private UnidadeService service;
	
	private MappingToJson mapToJson = new MappingToJson();
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> find(@PathVariable Integer id) throws JsonProcessingException {
		Unidade unid = service.findUnidade(id);
		long count=0;
		
		ObjectNode unidJson = JsonNodeFactory.instance.objectNode();
		unidJson.put("id", unid.getId());
		unidJson.put("nome", unid.getNome());
		unidJson.put("sigla", unid.getSigla());
		unidJson.put("totalServidores", unid.getServidores().size());
		
		for(Servidor serv: unid.getServidores())
		{	
			if(serv.getPossuiLattes() != null)
				count++;
		}
		
		unidJson.put("totalServComLattes", count);
		
		return ResponseEntity.ok().body(unidJson);
	}
	
	@GetMapping
	public ResponseEntity<?> unidades() {
		List<Unidade> obj = service.getUnidades();
		
		List<ObjectNode> unidades = new ArrayList<>();
		
		obj.forEach((Unidade depto) -> {
			ObjectNode node = JsonNodeFactory.instance.objectNode();
			
			node.put("id", depto.getId());
			node.put("nome", depto.getNome());
			node.put("sigla", depto.getSigla());
			unidades.add(node);
		});
		
		return ResponseEntity.ok().body(unidades);
	}
	
	@GetMapping(value="/{id}/departamentos")
	public ResponseEntity<?> projetosDePesqByIdPessoa(@PathVariable Integer id) {
		Unidade obj = service.findUnidade(id);
		
		List<ObjectNode> deptos = new ArrayList<>();
		
		obj.getDepartamentos().forEach((Departamento d) -> {
			ObjectNode depto = JsonNodeFactory.instance.objectNode();
			depto.put("id", d.getId());
			depto.put("nome", d.getNome());
			depto.put("sigla", d.getSigla());
			depto.put("totalServidores", d.getServidores().size());
			deptos.add(depto);
		});
		
		return ResponseEntity.ok().body(deptos);
	}
	
	@GetMapping(value="/{id}/servs-sem-depto")
	public ResponseEntity<?> servidoresSemDepartamentoByIdUnidade(@PathVariable Integer id) {
		Unidade obj = service.findUnidade(id);
		
		List<ObjectNode> servsJson = new ArrayList<>();
		
		obj.getServidores().forEach((Servidor s) -> {
			ObjectNode serv = JsonNodeFactory.instance.objectNode();
			if(s.getDepartamento() == null) {
				serv.put("id", s.getId());
				serv.put("nomeCompleto", s.getNomeCompleto());
				servsJson.add(serv);
			}
		});
		
		return ResponseEntity.ok().body(servsJson);
	}
	
	@GetMapping(value = "/{id}/producoes-bib", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> producoesBibByIdUnidade(@PathVariable Integer id) throws JsonProcessingException {
		
		List<Producao> producoes = new ArrayList<>();
		List<ObjectNode> producoesJson = new ArrayList<>();
		
		service.findUnidade(id).getServidores().forEach((Servidor serv) -> {
			producoes.addAll(serv.getProducoes());
		});
		
		producoesJson = mapToJson.mappingProducoes(producoes);
		
		return ResponseEntity.ok().body(producoesJson);
	}
	
	@GetMapping(value = "/{id}/orientacoes-conc", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> orientacoesByIdUnidade(@PathVariable Integer id) throws JsonProcessingException {
		
		List<OrientacaoConcluida> orientacoes = new ArrayList<>();
		List<ObjectNode> orientacoesJson = new ArrayList<>();
		
		service.findUnidade(id).getServidores().forEach((Servidor serv) -> {
			orientacoes.addAll(serv.getOrientacoesConcluidas());
		});
		
		orientacoesJson = mapToJson.mappingOrientacoes(orientacoes);
		
		return ResponseEntity.ok().body(orientacoesJson);
	}
	
//	@RequestMapping(method=RequestMethod.GET)
//	public ResponseEntity<?> findAll(){
//		List<Unidade> obj = service.getUnidades();
//		return ResponseEntity.ok().body(obj);
//	}
}
