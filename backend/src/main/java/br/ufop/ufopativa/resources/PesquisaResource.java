package br.ufop.ufopativa.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.ufop.ufopativa.models.Departamento;
import br.ufop.ufopativa.models.Pessoa;
import br.ufop.ufopativa.models.Unidade;
import br.ufop.ufopativa.services.DepartamentoService;
import br.ufop.ufopativa.services.PessoaService;
import br.ufop.ufopativa.services.UnidadeService;

@RestController
@RequestMapping(value = "/pesquisa")
public class PesquisaResource {
	
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private DepartamentoService deptoService;
	@Autowired
	private UnidadeService unidService;
	
	@GetMapping
	public ResponseEntity<?> pesquisaPorNome(@RequestParam String nome){
		
		int count = 0;
		
		List<Pessoa> pessoas = pessoaService.getPessoas();
		List<Departamento> departamentos = deptoService.getDepartamentos();
		List<Unidade> unidades = unidService.getUnidades();
		
		List<ObjectNode> pessoasJson = new ArrayList<>();
		List<ObjectNode> deptosJson = new ArrayList<>();
		List<ObjectNode> unidsJson = new ArrayList<>();
		
		Map<String, List<ObjectNode>> resultadoJson = new HashMap<>();
		
		for(Pessoa p: pessoas) {
			if(p.getNomeCompleto().toUpperCase().contains(nome.toUpperCase())) {
				ObjectNode node = JsonNodeFactory.instance.objectNode();
				node.put("id", p.getId());
				node.put("nome", p.getNomeCompleto());
				pessoasJson.add(node);
				count++;
				if(count == 15)
					break;
			}
		}
		resultadoJson.put("servidores", pessoasJson);
		count = 0;
		
		for(Unidade u: unidades) {
			if(u.getNome().toUpperCase().contains(nome.toUpperCase())) {
				ObjectNode node = JsonNodeFactory.instance.objectNode();
				node.put("id", u.getId());
				node.put("nome", u.getNome());
				unidsJson.add(node);
			}
		}
		resultadoJson.put("unidades", unidsJson);
		
		for(Departamento d: departamentos) {
			if(d.getNome().toUpperCase().contains(nome.toUpperCase())) {
				ObjectNode node = JsonNodeFactory.instance.objectNode();
				node.put("id", d.getId());
				node.put("nome", d.getNome());
				deptosJson.add(node);
				count++;
				if(count == 15)
					break;
			}
		}
		resultadoJson.put("departamentos", deptosJson);
		
		return ResponseEntity.ok().body(resultadoJson);
	}
	
//	@GetMapping
//	public ResponseEntity<?> findPessoasByNome(@RequestParam String nome){
//		
//		List<Pessoa> pessoas = pessoaService.getPessoas();
//		List<ObjectNode> pessoasJson = new ArrayList<>();
//		
//		for(Pessoa p: pessoas) {
//			if(p.getNomeCompleto().toUpperCase().contains(nome.toUpperCase())) {
//				ObjectNode node = JsonNodeFactory.instance.objectNode();
//				node.put("id", p.getId());
//				node.put("nome", p.getNomeCompleto());
//				pessoasJson.add(node);
//			}
//		}
//		return ResponseEntity.ok().body(pessoasJson);
//	}
}
