package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.ba.pm.sga.model.Escala;
import br.gov.ba.pm.sga.model.Integrante;
import br.gov.ba.pm.sga.model.Posto;

public interface Integrantes extends JpaRepository<Integrante, Long>{
	
    List<Integrante> findByEscala(Escala escala); 
    
    List<Integrante> findByEscalaAndPosto(Escala escala, Posto posto);
    
    @Query("from Integrante inte where inte.escala.id = :escalaId and inte.posto.id = :postoId")
    List<Integrante> findByEscalaAndPosto(@Param("escalaId")Long escalaId,@Param("postoId") Long postoId);
    
    @Query("from Integrante inte where inte.escala.id = :escalaid and inte.aluno.id = :id")
    Integrante findByEscalaAndAluno(Long escalaid, Long id);
    
    @Query("from Integrante inte where inte.escala.id = :escalaId and inte.posto.id in(1,2,6,7)")
    List<Integrante> findByEscalaAndPosto(@Param("escalaId")Long escalaId);
   
    
    default void deleteIntegranteEscala(Long id, Long escalaid) {
    	Integrante integrante = findByEscalaAndAluno(escalaid,id);
    	
    	//this.delete(integrante);
    }
    
    
    

}
