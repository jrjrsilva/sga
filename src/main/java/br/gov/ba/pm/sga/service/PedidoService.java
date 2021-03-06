package br.gov.ba.pm.sga.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Movimento;
import br.gov.ba.pm.sga.model.Pedido;
import br.gov.ba.pm.sga.repository.Movimentos;
import br.gov.ba.pm.sga.repository.Pedidos;



@Service
public class PedidoService {

	@Autowired
	private Pedidos pedidos;
	
	@Autowired
	private Movimentos movimentos;
	
	
	public List<Pedido> getAllPedidos() {
		Pageable pageable = new PageRequest(0, 15);
	
		return (List<Pedido>) pedidos.findAll();
		
	}
	
	public void salvar(Pedido pedido){
		this.pedidos.save(pedido);
	}
	
	public Pedido buscar(String codigo){
		return this.pedidos.findByCodigo(codigo);
	}
		
	
	public List<Pedido> pesquisaCodigo (String codigo){
		return this.pedidos.findByCodigoContaining(codigo);
	}
	
	
	
	public List<Pedido> obterPorCodigo (String codigo){
		return this.pedidos.obterPorCodigo(codigo);
	}
	
	
	public List<Pedido> pesquisaNome (String nome){
		return this.pedidos.findByNomeContaining(nome);
	}
		
	
	
	
	public List<Pedido> porSaldoPositivo(){
		return this.pedidos.porSaldoMaiorPositivo();
	}
	
	public List<Pedido> porSaldoNegativo(){
		return this.pedidos.porSaldoNegativo();
	}
	
	
	
	
}
