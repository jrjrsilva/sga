package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.ba.pm.sga.model.Funcao;
import br.gov.ba.pm.sga.model.Grupo;
import br.gov.ba.pm.sga.model.GrupoServico;

public interface Funcoes extends JpaRepository<Funcao, Long> {

	List<Funcao> findByNomeContaining(String nome);
	
}
