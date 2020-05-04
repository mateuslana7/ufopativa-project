package br.ufop.ufopativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufop.ufopativa.models.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

}
