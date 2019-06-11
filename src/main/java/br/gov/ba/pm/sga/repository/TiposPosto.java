package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.ba.pm.sga.model.TipoPosto;

public interface TiposPosto extends JpaRepository<TipoPosto, Long> {

	List<TipoPosto> findByNomeContaining(String nome);

}
