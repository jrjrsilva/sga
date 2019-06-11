package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.ba.pm.sga.model.Grupo;

public interface Grupos extends JpaRepository<Grupo, Long> {

	List<Grupo> findByNomeContaining(String nome);


	
}
