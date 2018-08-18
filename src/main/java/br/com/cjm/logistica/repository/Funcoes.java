package br.com.cjm.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cjm.logistica.model.Funcao;
import br.com.cjm.logistica.model.Grupo;
import br.com.cjm.logistica.model.GrupoServico;

public interface Funcoes extends JpaRepository<Funcao, Long> {

	List<Funcao> findByNomeContaining(String nome);
	
}
