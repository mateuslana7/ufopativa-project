package br.ufop.ufopativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ufop.ufopativa.models.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	
//	@Query(value = "SELECT COUNT (*) FROM orientacao_concluida where id_servidor=5 and orientacao_concluida.tipo='DOUT'");
	
	@Query(value = "SELECT COUNT (*) FROM pessoa WHERE pessoa.possui_lattes='SIM'", nativeQuery = true)
	long countServidoresComLattes();
	
//	@Query(value = "SELECT id, nome_completo FROM pessoa p WHERE p.nome_completo = ?1", nativeQuery = true)
//	List<Pessoa> findPessoaByNome(String nome);
	
//	public List<Pessoa> findIdAndNomeCompletoByNomeCompleto(String nome);
}
