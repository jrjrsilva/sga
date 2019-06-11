package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.ba.pm.sga.model.Inventario;
import br.gov.ba.pm.sga.model.Inventariomp;

public interface Inventariomps extends JpaRepository<Inventariomp, Long>{
	List<Inventariomp> findByAno(String ano); 	
}