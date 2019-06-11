package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.ba.pm.sga.model.Inventario;

public interface Inventarios extends JpaRepository<Inventario, Long>{
	List<Inventario> findByAno(String ano); 	
}