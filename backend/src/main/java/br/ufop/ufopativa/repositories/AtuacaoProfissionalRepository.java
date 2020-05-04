package br.ufop.ufopativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufop.ufopativa.models.AtuacaoProfissional;

@Repository
public interface AtuacaoProfissionalRepository extends JpaRepository<AtuacaoProfissional, Integer> {

}