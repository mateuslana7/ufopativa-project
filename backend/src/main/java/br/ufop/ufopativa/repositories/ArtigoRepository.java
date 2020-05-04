package br.ufop.ufopativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufop.ufopativa.models.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Integer>{

}
