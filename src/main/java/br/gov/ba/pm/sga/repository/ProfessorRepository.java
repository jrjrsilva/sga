package br.gov.ba.pm.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.ba.pm.sga.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

	Professor findByEmail(String email);

	
}
