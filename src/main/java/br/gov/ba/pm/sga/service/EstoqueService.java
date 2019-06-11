package br.gov.ba.pm.sga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Estoque;
import br.gov.ba.pm.sga.repository.Estoques;

@Service
public class EstoqueService {

	@Autowired
	private Estoques estoques;
	
	public List<Estoque> getAllEstoques() {
		Pageable pageable = new PageRequest(0, 15);
	
		return (List<Estoque>) estoques.findAll();
		
	}
	
	public void salvar(Estoque produto){
		this.estoques.save(produto);
	}
	
	public Estoque buscar(String codigo){
		
		return this.estoques.findByCodigo(codigo);
	}
		
	
	public List<Estoque> pesquisaCodigo (String codigo){
		return this.estoques.findByCodigoContaining(codigo);
	}
	
	
	
	public List<Estoque> obterPorCodigo (String codigo){
		return this.estoques.obterPorCodigo(codigo);
	}
	
	
	public List<Estoque> pesquisaNome (String nome){
		return this.estoques.findByNomeContaining(nome);
	}
}
