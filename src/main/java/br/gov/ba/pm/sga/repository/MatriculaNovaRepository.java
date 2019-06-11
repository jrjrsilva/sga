package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.ba.pm.sga.model.MatriculaNova;

public interface MatriculaNovaRepository extends JpaRepository<MatriculaNova, Integer> {
	
	@Query("Select m from MatriculaNova m where m.turma.codTurma = :codTurma")
	List<MatriculaNova> findByTurma(@Param("codTurma") Integer turma);

}
