package br.com.cjm.logistica.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.cjm.logistica.model.Movimento;
import br.com.cjm.logistica.model.Produto;
import br.com.cjm.logistica.repository.Movimentos;
import br.com.cjm.logistica.repository.Produtos;



@Service
public class ProdutoService {

	@Autowired
	private Produtos produtos;
	
	@Autowired
	private Movimentos movimentos;
	
	
	public List<Produto> getAllProdutos() {
		return (List<Produto>) produtos.findAll();
		
	}
	
	public void salvar(Produto produto){
		Movimento mv = new Movimento();	
		this.produtos.save(produto);
	}
	
	public Produto buscar(String codigo){
		
		return this.produtos.findByCodigo(codigo);
	}	
	
	public List<Produto> pesquisaCodigo (String codigo){
		return this.produtos.findByCodigoContaining(codigo);
	}
	
	public List<Produto> obterPorCodigo (String codigo){
		return this.produtos.obterPorCodigo(codigo);
	}
	
	public List<Produto> pesquisaNome (String nome){
		return this.produtos.findByNomeContaining(nome);
	}	
	
	public Produto buscarEan(String ean){
		
		return this.produtos.findByEan(ean);
	}
	
	public List<Produto> porSaldoPositivo(){
		return this.produtos.porSaldoMaiorPositivo();
	}
	
	public List<Produto> porSaldoNegativo(){
		return this.produtos.porSaldoNegativo();
	}
}
