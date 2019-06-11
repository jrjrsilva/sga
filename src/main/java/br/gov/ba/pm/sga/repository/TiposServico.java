package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.ba.pm.sga.model.TipoServico;

public interface TiposServico extends JpaRepository<TipoServico, Long> {

	List<TipoServico> findByNomeContaining(String nome);

}
