package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.ba.pm.sga.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {
	
	
	@Query("SELECT DISTINCT t.ano FROM Turma t order by ano desc")
	List<Integer> findByAnoAll();
	
	List<Turma> findByAno(Integer ano);

}
