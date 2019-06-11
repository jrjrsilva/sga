package br.gov.ba.pm.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.ba.pm.sga.model.Jogador;
import br.gov.ba.pm.sga.model.Vinho;

public interface Jogadores extends JpaRepository<Jogador, Long> {

}
