package br.com.cjm.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cjm.logistica.model.TipoPosto;

public interface TiposPosto extends JpaRepository<TipoPosto, Long> {

	List<TipoPosto> findByNomeContaining(String nome);

}
