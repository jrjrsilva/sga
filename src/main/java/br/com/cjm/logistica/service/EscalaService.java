package br.com.cjm.logistica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cjm.logistica.model.Escala;
import br.com.cjm.logistica.repository.Escalas;

@Service
public class EscalaService {

	@Autowired
	private Escalas escalas;
	
	public void salvar(Escala escala){	
		this.escalas.save(escala);
	}

	public Escala findOne(Long id) {
		// TODO Auto-generated method stub
		return this.escalas.findOne(id);
	}

	public List<Escala> findAll() {
		// TODO Auto-generated method stub
		return this.escalas.findAll();
	}

	public List<Escala> listDescendente() {
		// TODO Auto-generated method stub
		return this.escalas.listDescendente();
	}
	
}
