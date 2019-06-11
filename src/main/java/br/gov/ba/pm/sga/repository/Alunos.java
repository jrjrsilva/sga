package br.com.cjm.logistica.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cjm.logistica.model.Aluno;

public interface Alunos extends JpaRepository<Aluno, Long> {

	Aluno findByMatricula(String matricula);
	
	Aluno findByNumero(Integer numero);

	List<Aluno> findByNomeGuerra(String nomeGuerra);
	
	@Query("from Aluno s where  s.turma = :turma and s.curso = :curso")
    public List<Aluno> obterPorTurmaCurso(@Param("turma") String turma, @Param("curso") String curso);

	List<Aluno> findByTurma(String turma);

}
