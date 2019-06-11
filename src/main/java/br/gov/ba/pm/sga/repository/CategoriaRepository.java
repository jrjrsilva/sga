package br.gov.ba.pm.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.ba.pm.sga.model.Pedido;

@Repository
public interface CategoriaRepository extends JpaRepository<Pedido, Integer>{

}
