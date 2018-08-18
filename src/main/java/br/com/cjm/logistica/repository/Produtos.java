package br.com.cjm.logistica.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.cjm.logistica.model.Produto;

public interface Produtos extends JpaRepository<Produto, Long> {

	@Query("from Produto p where  p.codigo = :codigo")
    public List<Produto> obterPorCodigo(@Param("codigo") String codigo);
	
	@Query("from Produto p where  p.quantidade > 0 order by (quantidade) desc")
    public List<Produto> porSaldoMaiorPositivo();
	
	@Query("from Produto p where  p.quantidade <= 0 order by (quantidade) asc")
    public List<Produto> porSaldoNegativo();
	
	List<Produto> findByCodigoContaining(String codigo);
	
	Produto findByEan(String aen);
	
	Produto findByCodigo(String codigo);
	
	List<Produto> findByNomeContaining(String descricao);
	
}
