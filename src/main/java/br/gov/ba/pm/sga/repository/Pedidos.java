package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.ba.pm.sga.model.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Long> {

	@Query("from Pedido p where  p.codigo = :codigo")
    public List<Pedido> obterPorCodigo(@Param("codigo") String codigo);
	
	@Query("from Pedido p where  p.quantidade > 0 order by (quantidade) desc")
    public List<Pedido> porSaldoMaiorPositivo();
	
	@Query("from Pedido p where  p.quantidade <= 0 order by (quantidade) asc")
    public List<Pedido> porSaldoNegativo();
	
	List<Pedido> findByCodigoContaining(String codigo);
		
	Pedido findByCodigo(String codigo);
	
	List<Pedido> findByNomeContaining(String descricao);
	
}
