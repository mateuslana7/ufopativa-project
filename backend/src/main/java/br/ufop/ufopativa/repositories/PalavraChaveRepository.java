package br.ufop.ufopativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufop.ufopativa.models.PalavraChave;

@Repository
public interface PalavraChaveRepository extends JpaRepository<PalavraChave, Integer> {

}
