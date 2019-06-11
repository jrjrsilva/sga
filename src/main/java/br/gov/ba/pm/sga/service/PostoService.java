package br.gov.ba.pm.sga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Posto;
import br.gov.ba.pm.sga.repository.Postos;


@Service
public class PostoService {

	@Autowired
	private Postos postos;
	

	public List<Posto> findAll() {
		// TODO Auto-generated method stub
		return this.postos.findAll();
	}


	public void save(Posto posto) {
		// TODO Auto-generated method stub
		this.postos.save(posto);
	}
 

	public Posto findOne(Long id) {
		// TODO Auto-generated method stub
		return this.postos.findOne(id);
	}
	
}
