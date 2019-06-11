package br.gov.ba.pm.sga.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Inventario;
import br.gov.ba.pm.sga.model.Movimento;
import br.gov.ba.pm.sga.model.Produto;
import br.gov.ba.pm.sga.repository.Inventarios;
import br.gov.ba.pm.sga.repository.Movimentos;



@Service
public class InventarioService {

	@Autowired
	private Inventarios inventarios;
	
	@Autowired
	private Movimentos movimentos;
	
	
	public List<Inventario> getAllInventarios() {
	
		return (List<Inventario>) inventarios.findAll();
		
	}
	
	public void salvar(Inventario inventario){
		this.inventarios.save(inventario);
	}
	
	public List<Inventario> obterPorAno (String ano){
		return this.inventarios.findByAno(ano);
	}
	
	
}
