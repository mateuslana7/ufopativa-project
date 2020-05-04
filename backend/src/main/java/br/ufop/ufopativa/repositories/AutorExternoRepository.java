package br.ufop.ufopativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufop.ufopativa.models.AutorExterno;

@Repository
public interface AutorExternoRepository extends JpaRepository<AutorExterno, Integer> {

}
