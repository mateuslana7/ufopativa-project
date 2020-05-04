package br.ufop.ufopativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufop.ufopativa.models.FormacaoAcademica;

@Repository
public interface FormacaoAcademicaRepository extends JpaRepository<FormacaoAcademica, Integer> {

}
