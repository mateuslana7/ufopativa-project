package br.ufop.ufopativa.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.ufop.ufopativa.models.Unidade;
import br.ufop.ufopativa.services.DadosRelevantesService;
import br.ufop.ufopativa.utils.MappingToJson;

@RestController
@RequestMapping(value = "/dados-relevantes")
public class DadosRelevantesResource {
	
	@Autowired
	private DadosRelevantesService dadosRelevService;
	
	private MappingToJson mapToJson = new MappingToJson();
	
	@GetMapping
	public ResponseEntity<?> indicadores() {
		ObjectNode response = JsonNodeFactory.instance.objectNode();
		
		response.put("totalServidores", dadosRelevService.countPessoas());
		response.put("totalUnidades", dadosRelevService.countUnidades());
		response.put("totalDeptos", dadosRelevService.countDeptos());
		response.put("totalServComLattes", dadosRelevService.countServComLattes());
		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value = "/unidades", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> unidades() throws JsonProcessingException {
		
		List<ObjectNode> unidades = new ArrayList<>();
		
		dadosRelevService.getUnidades().forEach((Unidade u) -> {
			ObjectNode node = JsonNodeFactory.instance.objectNode();
			node.put("id", u.getId());
			node.put("nome", u.getNome());
			node.put("totalServidores", u.getServidores().size());
			node.put("percentualSobTotalServ", 0);
			unidades.add(node);
		});
		
		return ResponseEntity.ok().body(unidades);
	}
	
	@GetMapping(value = "/producoes-bib", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> producoesBib() throws JsonProcessingException {
		
		List<ObjectNode> producoes = mapToJson.mappingProducoes(dadosRelevService.getProducoes());
		
		return ResponseEntity.ok().body(producoes);
	}
	
	@GetMapping(value = "/orientacoes-conc", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> orientacoesConc() throws JsonProcessingException {
		
		List<ObjectNode> orientacoes = mapToJson.mappingOrientacoes(dadosRelevService.getOrientacoesConcluidas());
		
		return ResponseEntity.ok().body(orientacoes);
	}

	
	
}
