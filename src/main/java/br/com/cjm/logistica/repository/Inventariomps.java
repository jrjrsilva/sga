package br.com.cjm.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cjm.logistica.model.Inventario;
import br.com.cjm.logistica.model.Inventariomp;

public interface Inventariomps extends JpaRepository<Inventariomp, Long>{
	List<Inventariomp> findByAno(String ano); 	
}