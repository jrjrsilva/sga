package br.gov.ba.pm.sga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Demanda;
import br.gov.ba.pm.sga.repository.Demandas;

@Service
public class DemandaService {

	@Autowired
	private Demandas demandas;
	
	public List<Demanda> getAllDemandas() {
		Pageable pageable = new PageRequest(0, 15);
	
		return (List<Demanda>) demandas.findAll();
		
	}
	
	public void salvar(Demanda produto){
		this.demandas.save(produto);
	}
	
	public Demanda buscar(String codigo){
		
		return this.demandas.findByCodigo(codigo);
	}
		
	
	public List<Demanda> pesquisaCodigo (String codigo){
		return this.demandas.findByCodigoContaining(codigo);
	}
	
	
	
	public List<Demanda> obterPorCodigo (String codigo){
		return this.demandas.obterPorCodigo(codigo);
	}
	
	
	public List<Demanda> pesquisaNome (String nome){
		return this.demandas.findByNomeContaining(nome);
	}
}
