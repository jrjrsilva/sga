package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.ba.pm.sga.model.Escala;

public interface Escalas extends JpaRepository<Escala, Long>{
	
	
	@Query("from Escala es order by es.dataInicio DESC")
    public List<Escala>  listDescendente();

}
