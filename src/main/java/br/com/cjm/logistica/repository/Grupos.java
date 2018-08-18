package br.com.cjm.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cjm.logistica.model.Grupo;

public interface Grupos extends JpaRepository<Grupo, Long> {

	List<Grupo> findByNomeContaining(String nome);


	
}
