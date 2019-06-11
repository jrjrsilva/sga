package br.gov.ba.pm.sga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Funcao;
import br.gov.ba.pm.sga.repository.Funcoes;


@Service
public class FuncaoService {

	@Autowired
	private Funcoes funcoes;
	
	public void salvar(Funcao funcao){
		this.funcoes.save(funcao);
	}
		
	public List<Funcao> pesquisaNome (String nome){
		return this.funcoes.findByNomeContaining(nome);
	}


	public List<Funcao> findAll() {
		// TODO Auto-generated method stub
		return this.funcoes.findAll();
	}


	public void save(Funcao funcao) {
		// TODO Auto-generated method stub
		this.funcoes.save(funcao);
	}
 

	public Funcao findOne(Long id) {
		// TODO Auto-generated method stub
		return this.funcoes.findOne(id);
	}
	
}
