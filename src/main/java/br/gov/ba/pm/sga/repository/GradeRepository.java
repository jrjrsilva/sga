package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.ba.pm.sga.model.Grade;
import br.gov.ba.pm.sga.model.Turma;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
	
	@Query("FROM Grade g where g.turma.codTurma = :codTurma and g.semestre = :semestre order by ano desc")
	List<Grade> findByTurmaAndSemestre(
			@Param("codTurma") Integer codTurma,@Param("semestre") String semestre);
	
	@Query("SELECT DISTINCT g.ano FROM Grade g order by ano desc")
	List<Integer> findByAno();
	
	@Query("SELECT DISTINCT g.turma FROM Grade g order by turma desc")
	List<Turma> findByTurmaAnoAll();

}
