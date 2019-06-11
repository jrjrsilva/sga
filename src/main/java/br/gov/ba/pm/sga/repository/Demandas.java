package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.ba.pm.sga.model.Demanda;


public interface Demandas extends JpaRepository<Demanda, Long> {

	@Query("from Demanda p where  p.codigo = :codigo")
    public List<Demanda> obterPorCodigo(@Param("codigo") String codigo);
	
	@Query("from Demanda p where  p.quantidade > 0 order by (quantidade) desc")
    public List<Demanda> porSaldoMaiorPositivo();
	
	@Query("from Demanda p where  p.quantidade <= 0 order by (quantidade) asc")
    public List<Demanda> porSaldoNegativo();
	
	List<Demanda> findByCodigoContaining(String codigo);
	
	Demanda findByCodigo(String codigo);
	
	List<Demanda> findByNomeContaining(String descricao);
}
