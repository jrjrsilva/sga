package br.com.cjm.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cjm.logistica.model.Inventario;

public interface Inventarios extends JpaRepository<Inventario, Long>{
	List<Inventario> findByAno(String ano); 	
}