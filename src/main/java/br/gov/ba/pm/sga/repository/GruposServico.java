package br.gov.ba.pm.sga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.ba.pm.sga.model.Grupo;
import br.gov.ba.pm.sga.model.GrupoServico;

public interface GruposServico extends JpaRepository<GrupoServico, Long> {

	List<GrupoServico> findByNomeContaining(String nome);
	
	List<GrupoServico> findByGrupo(Integer grupo);
	
}
