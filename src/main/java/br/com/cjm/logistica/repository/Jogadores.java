package br.com.cjm.logistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cjm.logistica.model.Jogador;
import br.com.cjm.logistica.model.Vinho;

public interface Jogadores extends JpaRepository<Jogador, Long> {

}
