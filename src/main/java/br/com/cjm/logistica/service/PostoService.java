package br.com.cjm.logistica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cjm.logistica.model.Posto;
import br.com.cjm.logistica.repository.Postos;


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
