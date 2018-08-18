package br.com.cjm.logistica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cjm.logistica.model.TipoPosto;
import br.com.cjm.logistica.repository.TiposPosto;


@Service
public class TipoPostoService {

	@Autowired
	private TiposPosto tiposPosto;
	
	public void salvar(TipoPosto tipoPosto){
		this.tiposPosto.save(tipoPosto);
	}
	
	
	public List<TipoPosto> pesquisaNome (String nome){
		return this.tiposPosto.findByNomeContaining(nome);
	}


	public List<TipoPosto> findAll() {
		// TODO Auto-generated method stub
		return this.tiposPosto.findAll();
	}


	public void save(TipoPosto tipoPosto) {
		// TODO Auto-generated method stub
		this.tiposPosto.save(tipoPosto);
	}


	public TipoPosto findOne(Long id) {
		// TODO Auto-generated method stub
		return this.tiposPosto.findOne(id);
	}
	
}
