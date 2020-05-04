package br.ufop.ufopativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufop.ufopativa.models.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {
}
