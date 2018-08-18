package br.com.cjm.logistica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cjm.logistica.model.Grupo;
import br.com.cjm.logistica.model.Produto;
import br.com.cjm.logistica.repository.Grupos;


@Service
public class GrupoService {

	@Autowired
	private Grupos grupos;
	
	public void salvar(Grupo grupo){
		this.grupos.save(grupo);
	}
	
	
	public List<Grupo> pesquisaNome (String nome){
		return this.grupos.findByNomeContaining(nome);
	}


	public List<Grupo> findAll() {
		// TODO Auto-generated method stub
		return this.grupos.findAll();
	}


	public void save(Grupo grupo) {
		// TODO Auto-generated method stub
		this.grupos.save(grupo);
	}


	public Grupo findOne(Long id) {
		// TODO Auto-generated method stub
		return this.grupos.findOne(id);
	}
		
	
	
	
}
