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
import br.com.cjm.logistica.model.Inventario;
import br.com.cjm.logistica.model.Inventariomp;
import br.com.cjm.logistica.repository.Movimentos;
import br.com.cjm.logistica.repository.Inventariomps;
import br.com.cjm.logistica.repository.Inventarios;



@Service
public class InventariompService {

	@Autowired
	private Inventariomps inventariomps;
	
		
	
	public List<Inventariomp> getAllInventarios() {
		return (List<Inventariomp>) inventariomps.findAll();
	}
	
	public void salvar(Inventariomp inventario){
		this.inventariomps.save(inventario);
	}
	
	public List<Inventariomp> obterPorAno (String ano){
		return this.inventariomps.findByAno(ano);
	}
	
	
}
