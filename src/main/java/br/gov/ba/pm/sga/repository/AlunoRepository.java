package br.gov.ba.pm.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.ba.pm.sga.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	Aluno findByEmail(String email);

}