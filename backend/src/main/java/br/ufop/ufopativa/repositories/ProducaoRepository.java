package br.ufop.ufopativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufop.ufopativa.models.Producao;

@Repository
public interface ProducaoRepository extends JpaRepository<Producao, Integer> {
	Producao findByTituloPortugues(String tipo);
}
