package br.ufop.ufopativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufop.ufopativa.models.Vinculo;

@Repository
public interface VinculoRepository extends JpaRepository<Vinculo, Integer> {

}
