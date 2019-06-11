package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.gov.ba.pm.sga.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Integer> {

	List<Nota> findByAluno(Integer codAluno);
	
	List<Nota> findByTurma(Integer codTurma);
	
	@Transactional(readOnly=true)
	@Query("select n from Nota n where n.aluno.codAluno = :aluno and n.disciplina.codDisciplina = :disciplina and n.turma.codTurma = :turma")
	Nota findByAlunoAndDisciplinaAndTurma(
			@Param("aluno") Integer aluno,@Param("disciplina") Integer disciplina, @Param("turma") Integer turma);
	
	
	@Transactional(readOnly=true)
	@Query("select n from Nota n, MatriculaNova m where n.disciplina.codDisciplina = :disciplina "
			+ "and n.turma.codTurma = :turma and semestre = :semestre and n.turma.codTurma = m.turma.codTurma "
			+ "and n.aluno.codAluno = m.aluno.codAluno "
			+ "order by m.numero asc ")
	List<Nota> findByTurmaDisciplinaSemestre(@Param("turma") Integer turma, 
			@Param("disciplina") Integer disciplina,
			@Param("semestre") String semestre);

	
}
