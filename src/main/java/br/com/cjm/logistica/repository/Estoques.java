package br.com.cjm.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cjm.logistica.model.Estoque;


public interface Estoques extends JpaRepository<Estoque, Long> {

	@Query("from Estoque p where  p.codigo = :codigo")
    public List<Estoque> obterPorCodigo(@Param("codigo") String codigo);
	
	@Query("from Estoque p where  p.quantidade > 0 order by (quantidade) desc")
    public List<Estoque> porSaldoMaiorPositivo();
	
	@Query("from Estoque p where  p.quantidade <= 0 order by (quantidade) asc")
    public List<Estoque> porSaldoNegativo();
	
	List<Estoque> findByCodigoContaining(String codigo);
	
	Estoque findByCodigo(String codigo);
	
	List<Estoque> findByNomeContaining(String descricao);
}
