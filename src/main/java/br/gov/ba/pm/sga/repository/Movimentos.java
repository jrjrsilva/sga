package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.ba.pm.sga.model.Grupo;
import br.gov.ba.pm.sga.model.Movimento;
import br.gov.ba.pm.sga.model.Produto;

public interface Movimentos extends JpaRepository<Movimento, Long> {

	@Query("from Movimento m order by m.dataCadastro desc")
	public List<Movimento> porDataMovimento();
}
