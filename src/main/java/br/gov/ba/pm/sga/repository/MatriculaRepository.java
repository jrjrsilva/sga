package br.gov.ba.pm.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.ba.pm.sga.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

}
