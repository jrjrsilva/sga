package br.com.cjm.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cjm.logistica.model.TipoServico;

public interface TiposServico extends JpaRepository<TipoServico, Long> {

	List<TipoServico> findByNomeContaining(String nome);

}
