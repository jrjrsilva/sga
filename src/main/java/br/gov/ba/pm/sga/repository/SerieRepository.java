package br.gov.ba.pm.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.ba.pm.sga.model.Serie;

public interface SerieRepository extends JpaRepository<Serie, Integer> {

}
