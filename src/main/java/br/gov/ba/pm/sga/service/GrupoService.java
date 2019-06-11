package br.gov.ba.pm.sga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Grupo;
import br.gov.ba.pm.sga.model.Produto;
import br.gov.ba.pm.sga.repository.Grupos;


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
