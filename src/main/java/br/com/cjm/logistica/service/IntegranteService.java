package br.com.cjm.logistica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cjm.logistica.model.Escala;
import br.com.cjm.logistica.model.Integrante;
import br.com.cjm.logistica.model.Posto;
import br.com.cjm.logistica.repository.Integrantes;


@Service
public class IntegranteService {

	@Autowired
	private Integrantes integrantes;
	
	public void salvar(Integrante integrante){
		this.integrantes.save(integrante);
	}
		
	public List<Integrante> findAll() {
		// TODO Auto-generated method stub
		return this.integrantes.findAll();
	}

	public Integrante findOne(Long id) {
		// TODO Auto-generated method stub
		return this.integrantes.findOne(id);
	}

	public List<Integrante> findByEscala(Escala escala) {
		return this.integrantes.findByEscala(escala);
	}
	
	public List<Integrante> findByEscalaAndPosto(Escala escala,Posto posto) {
		return this.integrantes.findByEscalaAndPosto(escala,posto);
	}

	public List<Integrante> findByEscalaAndPosto(Long escalaId, Long postoId) {
		return this.integrantes.findByEscalaAndPosto(escalaId,postoId);
	}

	public List<Integrante> findByEscalaAndPosto(Long escalaId) {
		return this.integrantes.findByEscalaAndPosto(escalaId);
	}
	
}
