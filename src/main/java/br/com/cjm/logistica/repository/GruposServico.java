package br.com.cjm.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cjm.logistica.model.Grupo;
import br.com.cjm.logistica.model.GrupoServico;

public interface GruposServico extends JpaRepository<GrupoServico, Long> {

	List<GrupoServico> findByNomeContaining(String nome);
	
	List<GrupoServico> findByGrupo(Integer grupo);
	
}
