package br.ufop.ufopativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufop.ufopativa.models.Financiador;

@Repository
public interface FinanciadorRepository extends JpaRepository<Financiador, Integer> {

}
