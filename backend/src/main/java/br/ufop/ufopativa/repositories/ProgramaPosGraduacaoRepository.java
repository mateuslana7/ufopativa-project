package br.ufop.ufopativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufop.ufopativa.models.ProgramaPosGraduacao;

@Repository
public interface ProgramaPosGraduacaoRepository extends JpaRepository<ProgramaPosGraduacao, Integer> {

}
