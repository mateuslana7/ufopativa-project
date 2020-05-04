package br.ufop.ufopativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ufop.ufopativa.models.OrientacaoConcluida;

@Repository
public interface OrientacaoConcluidaRepository extends JpaRepository<OrientacaoConcluida, Integer> {
	
//	Integer countByIdServidorAndTipo();
//	Query query = entityManager.createNativeQuery("SELECT COUNT(*) FROM DOG WHERE ID =:id");
//	query.setParameter("id", 1);
//	int count = ((Number) query.getSingleResult()).intValue();
	
//	String jpql = "SELECT COUNT (*) FROM orientacao_concluida WHERE id_servidor=?1 AND orientacao_concluida.tipo='DOUT'";
//	
//	TypedQuery<Long> query = entityManager.createQuery(jpql , Long.class);
//	long total = query.getSingleResult();
	
	@Query(value = "SELECT COUNT (*) FROM orientacao_concluida WHERE id_servidor=?1 AND orientacao_concluida.tipo='DOUT'", nativeQuery = true)
	long countOrientacoesDout(long id);
	
	@Query(value = "SELECT COUNT (*) FROM orientacao_concluida WHERE id_servidor=?1 AND orientacao_concluida.tipo='MEST'", nativeQuery = true)
	long countOrientacoesMest(long id);
	
	@Query(value = "SELECT COUNT (*) FROM orientacao_concluida WHERE id_servidor=?1 AND orientacao_concluida.tipo='POS_DOUT'", nativeQuery = true)
	long countOrientacoesPosDout(long id);
	
	@Query(value = "SELECT COUNT (*) FROM orientacao_concluida WHERE id_servidor=?1 AND orientacao_concluida.tipo='OUTRA'", nativeQuery = true)
	long countOutrasOrientacoes(long id);
	
}
