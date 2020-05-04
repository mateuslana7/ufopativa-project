package br.ufop.ufopativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufop.ufopativa.models.ProjetoDePesquisa;

@Repository
public interface ProjetoDePesquisaRepository extends JpaRepository<ProjetoDePesquisa, Integer> {

}
