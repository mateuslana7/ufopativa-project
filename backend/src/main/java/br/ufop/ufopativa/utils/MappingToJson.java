package br.ufop.ufopativa.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.ufop.ufopativa.models.OrientacaoConcluida;
import br.ufop.ufopativa.models.Producao;

public class MappingToJson {
	
	public MappingToJson() {
		
	}
	
	public List<ObjectNode> mappingProducoes(List<Producao> producoes) {
		Map<Integer, Map<String, Integer>> producoesPorAno  = new HashMap<>();
		
		for(Producao p: producoes) {
			
			if(p.getClass().getSimpleName().equalsIgnoreCase("Artigo")){
				producoesPorAno.computeIfAbsent(p.getAno(), (k) -> new HashMap<>());
				producoesPorAno.get(p.getAno()).computeIfAbsent("Artigo", (k) -> 0);
				producoesPorAno.get(p.getAno()).computeIfPresent("Artigo", (key, val) -> val + 1);
			}
			else if (p.getClass().getSimpleName().equalsIgnoreCase("TrabalhoEmEvento")){
				producoesPorAno.computeIfAbsent(p.getAno(), (k) -> new HashMap<>());
				producoesPorAno.get(p.getAno()).computeIfAbsent("TrabalhoEmEvento", (k) -> 0);
				producoesPorAno.get(p.getAno()).computeIfPresent("TrabalhoEmEvento", (key, val) -> val + 1);
			}
			else if(p.getClass().getSimpleName().equalsIgnoreCase("Livro")){
				producoesPorAno.computeIfAbsent(p.getAno(), (k) -> new HashMap<>());
				producoesPorAno.get(p.getAno()).computeIfAbsent("Livro", (k) -> 0);
				producoesPorAno.get(p.getAno()).computeIfPresent("Livro", (key, val) -> val + 1);
			}
			else if(p.getClass().getSimpleName().equalsIgnoreCase("CapituloDeLivro")){
				producoesPorAno.computeIfAbsent(p.getAno(), (k) -> new HashMap<>());
				producoesPorAno.get(p.getAno()).computeIfAbsent("CapituloDeLivro", (k) -> 0);
				producoesPorAno.get(p.getAno()).computeIfPresent("CapituloDeLivro", (key, val) -> val + 1);
			}
			else if(p.getClass().getSimpleName().equalsIgnoreCase("OutraProducaoBibliografica")){
				producoesPorAno.computeIfAbsent(p.getAno(), (k) -> new HashMap<>());
				producoesPorAno.get(p.getAno()).computeIfAbsent("OutraProducaoBibliografica", (k) -> 0);
				producoesPorAno.get(p.getAno()).computeIfPresent("OutraProducaoBibliografica", (key, val) -> val + 1);
			}
		}
		
		List<ObjectNode> producoesJson = new ArrayList<>();
		ObjectNode node;
		long qtdArtigos;
		long qtdTrabsEvs;
		long qtdLivros;
		long qtdCapsLivros;
		long qtdOutrasProds;
		
		for(Integer ano : producoesPorAno.keySet()) {
			
			node = JsonNodeFactory.instance.objectNode();
			qtdArtigos = 0;
			qtdTrabsEvs = 0;
			qtdLivros = 0;
			qtdCapsLivros = 0;
			qtdOutrasProds = 0;
			
			for(String tipoProd : producoesPorAno.get(ano).keySet()) {
				if(tipoProd.equalsIgnoreCase("Artigo"))
					qtdArtigos += producoesPorAno.get(ano).get(tipoProd);
				if(tipoProd.equalsIgnoreCase("TrabalhoEmEvento"))
					qtdTrabsEvs += producoesPorAno.get(ano).get(tipoProd);
				if(tipoProd.equalsIgnoreCase("Livro"))
					qtdLivros += producoesPorAno.get(ano).get(tipoProd);
				if(tipoProd.equalsIgnoreCase("CapituloDeLivro"))
					qtdCapsLivros += producoesPorAno.get(ano).get(tipoProd);
				if(tipoProd.equalsIgnoreCase("OutraProducaoBibliografica"))
					qtdOutrasProds += producoesPorAno.get(ano).get(tipoProd);
			}
			node.put("ano", ano);
			node.put("totalArtigos", qtdArtigos);
			node.put("totalTrabsEv", qtdTrabsEvs);
			node.put("totalLivros", qtdLivros);
			node.put("totalCapsLivro", qtdCapsLivros);
			node.put("totalOutras", qtdOutrasProds);
			producoesJson.add(node);	
		}
		
		return producoesJson;
	}
	
	public List<ObjectNode> mappingOrientacoes(List<OrientacaoConcluida> orientacoes){
		Map<Integer, Map<String, Integer>> orientacoesPorAno  = new HashMap<>();
		
		for(OrientacaoConcluida o: orientacoes) {
			
			if(o.getTipo().equalsIgnoreCase("MEST")){
				orientacoesPorAno.computeIfAbsent(o.getAno(), (k) -> new HashMap<>());
				orientacoesPorAno.get(o.getAno()).computeIfAbsent("MEST", (k) -> 0);
				orientacoesPorAno.get(o.getAno()).computeIfPresent("MEST", (key, val) -> val + 1);
			}
			else if(o.getTipo().equalsIgnoreCase("DOUT")){
				orientacoesPorAno.computeIfAbsent(o.getAno(), (k) -> new HashMap<>());
				orientacoesPorAno.get(o.getAno()).computeIfAbsent("DOUT", (k) -> 0);
				orientacoesPorAno.get(o.getAno()).computeIfPresent("DOUT", (key, val) -> val + 1);
			}
			else if(o.getTipo().equalsIgnoreCase("POS_DOUT")){
				orientacoesPorAno.computeIfAbsent(o.getAno(), (k) -> new HashMap<>());
				orientacoesPorAno.get(o.getAno()).computeIfAbsent("POS_DOUT", (k) -> 0);
				orientacoesPorAno.get(o.getAno()).computeIfPresent("POS_DOUT", (key, val) -> val + 1);
			}
			else if(o.getTipo().equalsIgnoreCase("OUTRA")){
				orientacoesPorAno.computeIfAbsent(o.getAno(), (k) -> new HashMap<>());
				orientacoesPorAno.get(o.getAno()).computeIfAbsent("OUTRA", (k) -> 0);
				orientacoesPorAno.get(o.getAno()).computeIfPresent("OUTRA", (key, val) -> val + 1);
			}
		}
		
		List<ObjectNode> orientacoesJson = new ArrayList<>();
		ObjectNode node;
		long qtdMest;
		long qtdDout;
		long qtdPosDout;
		long qtdOutra;
		
		for(Integer ano : orientacoesPorAno.keySet()) {
			
			node = JsonNodeFactory.instance.objectNode();
			qtdMest = 0;
			qtdDout = 0;
			qtdPosDout = 0;
			qtdOutra = 0;
			
			for(String tipoOrient : orientacoesPorAno.get(ano).keySet()) {
				if(tipoOrient.equalsIgnoreCase("MEST"))
					qtdMest += orientacoesPorAno.get(ano).get(tipoOrient);
				if(tipoOrient.equalsIgnoreCase("DOUT"))
					qtdDout += orientacoesPorAno.get(ano).get(tipoOrient);
				if(tipoOrient.equalsIgnoreCase("POS_DOUT"))
					qtdPosDout += orientacoesPorAno.get(ano).get(tipoOrient);
				if(tipoOrient.equalsIgnoreCase("OUTRA"))
					qtdOutra += orientacoesPorAno.get(ano).get(tipoOrient);
			}
			node.put("ano", ano);
			node.put("totalMest", qtdMest);
			node.put("totalDout", qtdDout);
			node.put("totalPosDout", qtdPosDout);
			node.put("totalOutra", qtdOutra);
			orientacoesJson.add(node);	
		}
		return orientacoesJson;
	}
	
}
