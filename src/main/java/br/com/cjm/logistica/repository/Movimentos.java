package br.com.cjm.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cjm.logistica.model.Grupo;
import br.com.cjm.logistica.model.Movimento;
import br.com.cjm.logistica.model.Produto;

public interface Movimentos extends JpaRepository<Movimento, Long> {

	@Query("from Movimento m order by m.dataCadastro desc")
	public List<Movimento> porDataMovimento();
}
